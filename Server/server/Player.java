package server;
/*
  Author: Haolin Zhang
  File:   Player.java
  Date:   July 19, 2022
  Ver:    1.1

  Description:
          Basic information for each client
 */

import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Player {
    public String username;
    public String password;
    public static int balance;
    public boolean isDealer = false;
	  public Deck deck;
    public static ObjectOutputStream oos;
    private ArrayList<Card> cards;

    public Player() {
        this.username = "[Undefined]";
        this.password = "[Undefined]";
        this.balance = -1;
    }

    /*
     * constructor for Account class, initialize all variables
     */
    public Player(String username, String password, int balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    /*
     * getter function for password
     * @return String password
     */

    public String getPassword(String username) {
        return this.password;
    }

    /*
     * getter function for password
     * @return int balance
     */
    public static int getBalance(String username) {
        return balance;
    }

    /*
     * setter function for balance
     * @param int newBalance
     */
    public void addBalance(int amount) {
        this.balance = this.balance + amount;
    }

    /*
     * set ObjectOutputStream for each player when they are connected
     * @param ObjectOutputStream oos
     */
    public void setOos(ObjectOutputStream oos) {
        Player.oos = oos;
    }

    /*
     * return the ObjectOutputStream of the player so that we can send msg to client
     * @return ObjectOutputStream oos
     */
    public ObjectOutputStream getOos() {
        return oos;
    }

}
