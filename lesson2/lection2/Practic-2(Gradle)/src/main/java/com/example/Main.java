package com.example;

import java.sql.*;

public class Main {

    // Singleton
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:WorkDB.db");

        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO student(name, score) VALUES(?, ?)");

        connection.setAutoCommit(false);
        for (int i = 1; i <= 10_000; i++) {
            Savepoint savepoint = connection.setSavepoint();
            preparedStatement.setString(1, "BOB" + i);
            preparedStatement.setInt(2, 20 * i);

            if (20 * i > 500) {
                connection.rollback(savepoint);
            }

            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        connection.commit();


        // id, name, score
        try (Statement statement = connection.createStatement();
             ResultSet resultSet =
                     statement.executeQuery("SELECT * FROM student")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");

                System.out.println(id + " " + name + " " + score);
            }
        } catch (Exception e) {

        }

        connection.close();
    }
}
