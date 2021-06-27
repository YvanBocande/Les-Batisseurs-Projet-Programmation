package Game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * this class is a subclass of the player class. It defines a player who plays alone in a random way.
 * @author Yvan Bocande
 */
public abstract class AutoPlayer extends Player implements Serializable {

	/**
	 * the constructor initializes the auto player using the player constructor.
	 * @param name a String wich is the name of the player
	 * @param number an int wich is the number of player.
	 * @param cards the deck of the game
	 */
	public AutoPlayer(String name, int number,Deck cards) {
		super(name,number,cards);
	}

	/**
	 * this abstract class will be redefined according to the difficulty of the player to play
	 * @param game the game of the player
	 * @param send the workers wich were already send 
	 */
	public abstract  boolean play(Game game,ArrayList<String> send);
}