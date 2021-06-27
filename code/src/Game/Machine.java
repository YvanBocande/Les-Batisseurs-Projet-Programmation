package Game;

import java.io.Serializable;

/**
 * this class represent a Machine with its skills and cost to build
 */
public class Machine extends Card implements Serializable{

	private int stoneP;
	private int woodP;
	private int tuileP;
	private int knowledgeP;
	private int victoryPoint;
	private boolean isFinish;
	private boolean isWorking;
	private static final int cost = 0;


	/**
	 * this constructor initialize all the attibute of the Machine object
	 * @param tuile an int wich is the number of gold on the card
	 * @param stone an int wich is the number of stone on the card
	 * @param knowledge an int wich is the number of knowledge on the card
	 * @param wood an int wich is the number of wood on the card
	 * @param name a String wich is the name on the card
	 * @param tuileP an int wich is the gold produce vby the card
	 * @param stoneP an int wich is the stone produce by the card
	 * @param knowledgeP an int wich is the knowledge produce by the card
	 * @param woodP an int wich is the wood produce by the card
	 * @param victoryPoint the number of points won
	 */
	public Machine(int tuile,int stone,int knowledge, int wood, String name, int stoneP, int woodP, int knowledgeP, int tuileP,int victoryPoint) {
		super(tuile, stone, knowledge, wood, name);
		if(stoneP>=0 && woodP>=0 && tuileP>=0 && knowledgeP>=0){
			this.victoryPoint = victoryPoint;
			this.tuileP = tuileP;
			this.stoneP = stoneP;
			this.woodP = woodP;
			this.knowledgeP = knowledgeP;
			isFinish = false;
			isWorking = false;
		}
	}

	/**
	 * return the thing product
	 * @return a String with the thing product
	 */
	public String prod(){
		if(woodP> 0){
			return "bois  ";
		}
		if(stoneP> 0){
			return "pierre";
		}
		if(knowledgeP> 0){
			return "savoir";
		}
		else{
			return "tuile ";
		}
	}

	public int nbProd(){
		if(woodP> 0){
			return woodP;
		}
		if(stoneP> 0){
			return stoneP;
		}
		if(knowledgeP> 0){
			return knowledgeP;
		}
		else{
			return tuileP;
		}

		
	}

	/**
	 * return the number of tuile produce of the card
	 * @return an int wich is the attribute tuile
	 */
	public int getTuileP() {
		return this.tuileP;
	}

	/**
	 * return the number of wood produce of the card
	 * @return an int wich is the attribute wood
	 */
	public int getWoodP() {
		return woodP;
	}

	/**
	 * return the number of stone produce of the card
	 * @return an int wich is the attribute stone
	 */
	public int getStoneP() {
		return stoneP;
	}

	/**
	 * return the number of knowledge produce of the card
	 * @return an int wich is the attribute knowledge
	 */
	public int getKnowledgeP() {
		return knowledgeP;
	}

	/**
	 * return true if the bulding is finish to build (enough materials)
	 * @return a boolean wich is the attribute finish
	 */
	public boolean isFinish() {
		return isFinish;
	}

	/**
	 * change the value of isFinish
	 */
	public void setFinish() {
		isFinish = true;
	}

	/**
	 * return true if the bulding is workinf (enough materials)
	 * @return a boolean wich is the attribute finish
	 */
	public boolean isWorking() {
		return isWorking;
	}

	/**
	 * change the value of isFinish
	 * @param value the value to put
	 */
	public void setWorking(boolean value) {
		isWorking = value;
	}

	/**
	 * return the cost of the machine
	 * @return 0 
	 */
	public static int getCost() {
		return cost;
	}

	/**
	 * return the number of victory points
	 * @return the attribute VictoryPoint
	 */
	public int getPointVictory() {
		return victoryPoint;
	}
}