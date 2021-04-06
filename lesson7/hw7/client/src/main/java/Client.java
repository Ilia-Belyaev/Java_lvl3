package hw7.client.src.main.java;

import hw7.server.src.main.java.ClientHandler;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) { myClient();
    }
    public static void myClient(){
        try (
                Socket socket = new Socket("localhost",8189);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Scanner scanner = new Scanner(System.in)) {
            String message = "";
            Thread clientThread = new Thread(() -> {
                String serverMessage = "";
                try {
                    while (!socket.isClosed()) {
                        serverMessage = in.readUTF();
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            clientThread.start();
            do {
                message = scanner.nextLine();
                out.writeUTF(message);
                //out.flush();
            } while (!message.equalsIgnoreCase("/end"));
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}
