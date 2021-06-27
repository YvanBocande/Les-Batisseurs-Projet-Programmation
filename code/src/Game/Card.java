package Game;

import java.io.Serializable;

/**
 * this abstract class is used to define cards with their attributes. Other attributes will be added depending on the type of player.
 */
public abstract class Card implements Serializable{

	private int tuile;
	private int stone;
	private int knowledge;
	private int wood;
	private String name;

	/**
	 * the constructor initializes the card with the attributes.
	 *  For machines and workers this corresponds to the materials produced and for buldings it corresponds to the necessary materials.
	 * @param tuile an int wich is the number of tuile on the card
	 * @param stone an int wich is the number of stone on the card
	 * @param knowledge an int wich is the number of knowledge on the card
	 * @param wood an int wich is the number of wood on the card
	 * @param name a String wich is the name on the card
	 */
	public Card(int tuile,int stone,int knowledge, int wood, String name) {
		if(tuile >=0 && stone >= 0 && knowledge >=0 && wood >=0 && name != null){
			this.tuile = tuile;
			this.stone = stone;
			this.knowledge = knowledge;
			this.wood = wood;
			this.name = name;
		}
	}

	/**
	 * return the number of gold of the card
	 * @return an int wich is the attribute gold
	 */
	public int getTuile() {
		return tuile;
	}

	
	/**
	 * return the number of wood of the card
	 * @return an int wich is the attribute wood
	 */
	public int getwood() {
		return this.wood;
	}

	/**
	 * return the number of stone of the card
	 * @return an int wich is the attribute stone
	 */
	public int getStone() {
		return this.stone;
	}

	/**
	 * return the number of knowledge of the card
	 * @return an int wich is the attribute knowledge
	 */
	public int getKnowledge() {
		return this.knowledge;
	}

	/**
	 * return the name of the card
	 * @return a String wich correspond to the attribute name
	 */
	public String getName() {
		return this.name;
	}
}