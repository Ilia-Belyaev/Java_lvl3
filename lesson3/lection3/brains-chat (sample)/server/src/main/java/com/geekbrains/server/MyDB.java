package com.geekbrains.server;

import java.sql.*;

public class MyDB implements AutoCloseable{
    private static MyDB instance;
    private static Connection connection;
    private static PreparedStatement loginAndPass;
    //private static PreparedStatement nick;

    private MyDB() {
    }

    public static MyDB getInstance() {
        if (instance == null) {
            openConnect();
            createPreparedStatements();
            instance = new MyDB();
        }
        return instance;
    }

    private static void openConnect() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:BaseClient.db");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private static void createPreparedStatements()  {
        try {
            loginAndPass = connection.prepareStatement("SELECT * FROM clients WHERE login=? AND password=?");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String findLogAndPass(String login, String password) {
        ResultSet resultSet = null;
        try {
            loginAndPass.setString(1, login);
            loginAndPass.setString(2, password);
            resultSet = loginAndPass.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeResultSet(resultSet);
        }
        return null;
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    @Override
    public void close(){
        try {
            loginAndPass.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
