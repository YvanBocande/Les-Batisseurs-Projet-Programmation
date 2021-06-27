package Game;

import java.io.Serializable;

public class Bulding extends Card implements Serializable{


	private int victoryPoint;
	private boolean finish;
	private int ecus;

	/**
	 * this constructor initialize all the attibute of the Bulding object
	 * @param tuile an int wich is the number of gold on the card
	 * @param stone an int wich is the number of stone on the card
	 * @param knowledge an int wich is the number of knowledge on the card
	 * @param wood an int wich is the number of wood on the card
	 * @param name a String wich is the name on the card
	 * @param victoryPoint the number of point of victory
	 * @param ecus an int wich represent the number of Ecus won
	 */
	public Bulding(int tuile,int stone,int knowledge, int wood, String name, int victoryPoint, int ecus) {
		super(tuile, stone, knowledge, wood, name);
		if(victoryPoint>=0 && ecus >= 0){
			this.victoryPoint = victoryPoint;
			this.ecus = ecus;
		}
	}


	/**
	 * return the number of point of victory of the card
	 * @return an int wich is the attribute victoryPoint
	 */
	public int getPointVictory() {
		return victoryPoint;
	}

	/**
	 * return true if the bulding is finish to build (enough materials)
	 * @return a boolean wich is the attribute finish
	 */
	public boolean isFinish() {
		return finish;
	}

	/**
	 * print the card with all the informations and attributes
	 */
	public String toString(){
		return super.getName() + "--> " + " Tuile:" + super.getTuile()+ "  Pierre:" + super.getStone()+ "  Savoir:" + super.getKnowledge()+ "  Bois:" + super.getwood()+ "  Points de victoire:" + this.victoryPoint+ "  Ecus gagné:" + this.ecus;
	}

	public int getEcus() {
		return ecus;
	}
}