package com.geekbrains.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private Vector<ClientHandler> clients;
    private AuthService authService;
    private static File thisDirectory;
    private static File storyMsg;
    private static OutputStream os;
    private ExecutorService executorService;
    private static final Logger logger = Logger.getLogger(com.geekbrains.server.Server.class.getName());
    public AuthService getAuthService() {
        return authService;
    }

    public Server() {
        clients = new Vector<>();
        authService = new SimpleAuthService();
        executorService = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            MyDB instance = MyDB.getInstance();
            createFileWithStoryMessage();////////////Создаю файл при запуске сервера
            logger.log(Level.INFO,"Сервер запущен на порту 8189");
            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(this,socket,executorService);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO,"Сервер завершил свою работу");
    }

    public void broadcastMsg(String msg) throws IOException {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
        try {//доави
            os = new BufferedOutputStream(new FileOutputStream(thisDirectory + "\\message_history.txt", true));
            os.write((msg+"\n").getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            os.close();
        }
    }


    public static void createFileWithStoryMessage() {
        try {
            thisDirectory = new File("client/src/main/java/com/geekbrains/client");
            thisDirectory.mkdir();
            storyMsg = new File(thisDirectory + "\\message_history.txt");
            storyMsg.createNewFile();
            //return storyMsg;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void privateMsg(ClientHandler sender, String receiverNick, String msg) {
        if (sender.getNickname().equals(receiverNick)) {
            sender.sendMsg("заметка для себя: " + msg);
            logger.log(Level.INFO,"Клиент " + sender.getNickname()+" сделал для себя пометку.");
            return;
        }
        for (ClientHandler o : clients) {
            if (o.getNickname().equals(receiverNick)) {
                o.sendMsg("от " + sender.getNickname() + ": " + msg);
                sender.sendMsg("для " + receiverNick + ": " + msg);
                logger.log(Level.INFO,"Клиент " + sender.getNickname() + " отправил приватное сообщение " + receiverNick );
                return;
            }
        }
        sender.sendMsg("Клиент " + receiverNick + " не найден");
        logger.log(Level.INFO,"Клиент " + receiverNick + " не найден");
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastClientsList();
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastClientsList();
    }

    public boolean isNickBusy(String nickname) {
        for (ClientHandler o : clients) {
            if (o.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public void broadcastClientsList() {
        StringBuilder sb = new StringBuilder(15 * clients.size());
        sb.append("/clients ");
        // '/clients '
        for (ClientHandler o : clients) {
            sb.append(o.getNickname()).append(" ");
        }
        // '/clients nick1 nick2 nick3 '
        sb.setLength(sb.length() - 1);
        // '/clients nick1 nick2 nick3'
        String out = sb.toString();
        for (ClientHandler o : clients) {
            o.sendMsg(out);
        }
    }

}
