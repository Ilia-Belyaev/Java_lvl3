package hw7.server.src.main.java;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private List<ClientHandler> clients;
    private AtomicInteger numero = new AtomicInteger(1);

    public Server() {
        this.clients = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is listening on 8189");
            while(true) {
                Socket socket = serverSocket.accept();
                new ClientHandler(numero.getAndIncrement(), this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcastMessage(String message) {
        for(ClientHandler client: clients) {
            client.sendMessage(message);
        }
    }
    public void personalMessage(String[] message,String nickname){

        for(ClientHandler client: clients) {
            //System.out.println(message[1]+ " "+client.getNickname());
            if(message[1].equals(client.getNickname())) {
                String msg = (String.join(" ",message)).replace("/w "+client.getNickname(),""+nickname + " : ");
                client.sendMessage(msg);
                break;
            }
        }
    }

    public void broadcastClientsList() {
        StringBuilder sb = new StringBuilder(15* clients.size());
        sb.append("/clients ");
        for(ClientHandler o: clients){
            sb.append(o.getNickname()).append(" ");
        }
        String out = sb.toString();
        broadcastMessage(out);
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientsList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientsList();
    }
}
