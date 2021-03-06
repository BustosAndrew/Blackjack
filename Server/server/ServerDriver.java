package server;
/*
  Author: Haolin Zhang
  File:   ServerDriver.java
  Date:   July 18, 2022
  Ver:    1.1

  Description:
          Driver class for Blackjack server
 */
public class ServerDriver {
    final static String host = "localhost";
    final static int port = 7777;

    public static void main(String args[]) {
        Server server = new Server(host, port);
        server.run();
    }
}
