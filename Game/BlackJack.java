/*
  Author: Steven Tran
  File:   Server.java
  Date:   July 21, 2022
  Ver:    1.1

  Description:
          Game class for game rule
 */
import java.util.*;
import java.io.*;

import cs401bjproject.Lobby;
import java.util.Vector;

import javax.swing.JTextField;
public class BlackJack2 {
	private int user;
	private static ArrayList<Player> players;
	private static Player dealer;
	private Deck deck;
	private Scanner scan;
	private int index = 0;
	/*
	 * default constructor for BlackJack game
	 * initialize all variables
	 */
	public BlackJack2(Player dealer, ArrayList<Player> players) {
		this.dealer = dealer;
		this.players = players;
	}

	/*
	 * add bet amount to player
	 */
	public void bet(Player player, int amount) {
		Scanner userInput = new Scanner(System.in);
		double amount1 = 0;
		while (amount1 > 0) {
			//Play on 
			// take the bets 	
			amount1 = userInput.nextDouble(); 
		}
		double playerBalance = Player.getBalance(players.get(index).username); 
	/* 
	 * 
	 * Haolin needs to help with this portion 	
	 * How do we get balance from Server/ Client to update for every betting 
	 * 
	 * 
	*/
		
		
	}

	/*
	 * draw a card from main deck
	 */
	public void hit(Player player, Deck tmpdeck) {
		
		/* here the player needs to choose the button hit 
		 * after the hit button is selected the updated amount of cards is added by one 
		 * //they hit

		//load players value then add a new amount 

		*/	
		System.out.println("hello");
		Deck tmpDeck = this.deck; 
		this.deck = tmpDeck;
		this.deck.draw(tmpDeck);
		//Deck playingDeck = new Deck();
		//Deck playerDeck = new Deck();
		//playerDeck.draw(playingDeck);
		
		//System.out.print("Your Hand is: "+ playerDeck.cardsValue());
		System.out.print(tmpDeck.toString());
		if (tmpDeck.cardsValue() > 21) {
			System.out.println("You lose");
//--------------the amount bet will be taken from player 
		}
			//playerTurn(player,deck);
	}

	/*
	 * do nothing, mark as skip
	 */
	public void stay(Player player) {
		
		System.out.println("Stay is called");
	}

	/*
	 * add a new player to ArrayList<Player> players
	 */
	public void addPlayer(Player player) {
		
		players.add(player);
		System.out.println("Adding " + player.username + " to the game");
		
	}

	/*
	 * String contains who is in the game and their cards
	 * looks like this:
	 * "DEALER, ANDREW BUSTOS, CLUB TWO, DIAMOND SIX\n PLAYER, HAOLIN ZHANG, SPADE FIVE, SPADE THREE\n PLAYER, STEVEN TRAN, HEART FIVE, DIAMOND SIX..."
	 */
	public String getInfo() {
		for (int i = 0; i < Lobby.numOfPlayers; i++) {
			System.out.println(players.get(i).username + "\n");
			System.out.println(players.get(i).toString());
		}
		return "";
	}

	public void start() {
		
		/* Order of operations
		 * Accept players into a lobby (addPlayer) done by 
		 * 
		 * First accept available bets 
		 * 
		 */

		//Create playing deck
		int choice;
		
		scan = new Scanner(System.in);
		Deck playingDeck = new Deck();
		//id++;
		playingDeck.createFullDeck();
		//playingDeck.shuffle();
		//Create a deck for a player
		Deck playerDeck = new Deck();
		//id++;
		Deck dealerDeck = new Deck();			
		//Start dealing
		//player gets cards
		playerDeck.draw(playingDeck);
		playerDeck.draw(playingDeck);
		//dealer gets cards
		dealerDeck.draw(playingDeck);
		dealerDeck.draw(playingDeck);			
		System.out.println(playingDeck);
		/*
		Scanner userInput = new Scanner(System.in);
		JTextField myField = new JTextField();
		
		System.out.print("Player's Hand is: "+ playerDeck.cardsValue());
		System.out.print(playerDeck.toString());
		//Displayer Dealers Hand
		System.out.println("\nDealer's Hand: \n\n" + dealerDeck.getCard(0).toString() + "\n[Hidden]");
	*/	
		
		//create a for loop for which players turn 
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < Lobby.numOfPlayers; j++) {
				System.out.print(i);
			}
			
//			System.out.println(players);
		}
		
		//Display Player's hand
		System.out.print(players + "'s Hand is: "+ playerDeck.cardsValue());
		System.out.print(playerDeck.toString());
		//Displayer Dealer's Hand
		System.out.println("\n\n" + dealer + "'s Hand: \n" + dealerDeck.getCard(0).toString() + "\n[Hidden]");
		
		
		//Print number of players in lobby 
		System.out.println(Lobby.numOfPlayers);
		
		//just to test for scanner
		System.out.println("\n" + "choose 0 to hit" + "\n" + "choose 1 to stay" + "\n" + "choose 2 to show all hands");

		/* if (Lobby.numOfPlayers = 0) 
		 * get the first player from arraylist and allow them to use different commands 
		 * set the index of players in lobby 
		 * while(index < Lobby.numOfPlayers)
		 */
		
		while(index < 6) {
			do {
				choice = scan.nextInt();
				scan.nextLine();
				switch(choice) 
				{
				case 0: //hit(null);
					hit(players.get(index), playingDeck);
					System.out.println("Hit is called");
					continue;
				case 1: //stay(null);
					stay(players.get(index));
					index++;
					break;
				case 2: 
					getInfo();
					continue;
				default: System.out.println("Invalid");	
				}
				
			}
			//while (index < players.size());
			while(index < Lobby.numOfPlayers);
			while (index == Lobby.numOfPlayers) {
				while(dealerDeck.cardsValue() < 17) {
					dealerDeck.draw(playingDeck);
					System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
				}
				if(dealerDeck.cardsValue() > 21 ) {
					System.out.println("Dealer busts! you win.");
				}

			}
		}
		
		/*playerList = players.size();
		listIterator()
		*/
}
	
	public static void main(String[] args) {
		System.out.println("Welcome to BlackJack\n");
		/*
		 * Make bets at this section 
		 */
		Deck playingDeck = new Deck();
		
		playingDeck.createFullDeck();
		//playingDeck.shuffle();
		System.out.println(playingDeck);
		
		
		
		BlackJack2 blackJack = new BlackJack2(dealer, players); 
		blackJack.start();

		
		/*
		 * After game is over move used cards back to playing deck
		 */
		Deck usedDeck = new Deck();
		usedDeck.moveAllToDeck(playingDeck);

	}
}	
