/*
    Author: Haolin Zhang
    File: ServerThread.java
    Date: July 19, 2022
    Ver: 1.0

    Description: Multiple threading handler for client connections
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class ServerThread implements Runnable {
    private Boolean socketIsOpen = true;
    private Socket cSocket;
    private static Server server;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;

    public ServerThread(Socket socket, Server server) {
        this.cSocket = socket;
        ServerThread.server = server;
        try {
            this.outputStream = socket.getOutputStream();
            this.objectOutputStream = new ObjectOutputStream(outputStream);
            this.inputStream = socket.getInputStream();
            this.objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            socketIsOpen = false;
            System.out.println(e.getMessage());
        }
    }

    /*
     * function to validate user entered information
     * @param Message msg
     * @return Boolean true  for valid
     *                 false for invalid
     */
    public boolean validateLogin(Message msg) {
        if (msg.getType().equals("login")) {
            String info = msg.getData();
            String[] line = info.split(",");
            String username = line[0];
            if (server.getClientInfo().get(username).getPassword(username).equals(line[1])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run() {
        try {
            System.out.println("[NEW CLIENT CONNECTED]: " + cSocket);

            Message msg = (Message) objectInputStream.readObject();

            if (validateLogin(msg)) {
                System.out.println("login verified!");
            } else {
                System.out.println("login failed!");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
