package hw7.server.src.main.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientHandler {
    private String nickname;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;

    public ClientHandler(Integer numero, Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.nickname = "Client" + numero;
            new Thread(() -> {
                server.subscribe(this);
                boolean continueChat = true;
                String msg = null;
                try {
                    while (continueChat) {
                        msg = in.readUTF();
                        if (msg.startsWith("/")) {
                            if (msg.equalsIgnoreCase("/end")) {
                                continueChat = false;
                            } else if (msg.startsWith("/w")) {
                                String[] massMsg = msg.split(" ");
                                server.personalMessage(massMsg,this.nickname);
                            }

                        } else {
                            server.broadcastMessage(nickname + " : " + msg);

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    disconnect();
                }

            }).start();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
