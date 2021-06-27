package Game;

import java.io.Serializable;

/**
 * this class represent a card of a worker with the competences and cost
 */
public class Worker extends Card implements Serializable{

	private int cost;
	private boolean isWorking;

	/**
	 * this constructor initialize all the attibute of the Worker object
	 * @param tuile an int wich is the number of tuile on the card
	 * @param stone an int wich is the number of stone on the card
	 * @param knowledge an int wich is the number of knowledge on the card
	 * @param wood an int wich is the number of wood on the card
	 * @param name a String wich is the name on the card
	 * @param cost the cost to send the worker work
	 */
	public Worker(int tuile,int stone,int knowledge, int wood, String name, int cost) {
		super(tuile, stone, knowledge, wood, name);
		if(cost>=0){
			this.cost = cost;
		}
	}

	/**
	 * return true if the worker is working
	 * @return the attribute isWorking
	 */
	public boolean isWorking(){
		return isWorking;
	}

	/**
	 * change the value of the attribute isWorking with the param
	 * @param value the new value of the attribute isWorking
	 */
	public void setIsWorking(boolean value){
		isWorking = value;
	}

	public int getCost() {
		return cost;
	}

	/**
	 * print the card with all the informations and attributes
	 */
	public String toString(){
		return super.getName() + "--> " + " Tuile:" + super.getTuile()+ "  Pierre:" + super.getStone()+ "  Savoir:" + super.getKnowledge()+ "  Bois:" + super.getwood()+ "  Cout:" + this.cost;
	}
}