package Game;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Player implements Serializable{

	private ArrayList<Chantier> myChantiers; 
	private ArrayList<Card> myWorkers; 
	private int numberActionLeft;
	private int ecus;
	private String name;
	private int victoryPoints;

	/**
	 * initialize all the attribute of the player. initialize all the arrayList with nothing inside.
	 * @param name a String wich is the name of the player
	 * @param number an int wich is the number of the player
	 * @param cards the cards of the deck og the game
	 */
	public Player(String name, int number, Deck cards) {
		this.name = name;
		myChantiers = new ArrayList<Chantier>();
		myWorkers = new ArrayList<Card>();
		ecus = 10;
		numberActionLeft = 3;
		victoryPoints = 0;
		
		boolean stop = false;
		for(int i=0;i<cards.getCards().size() && stop == false;i++){
			Card elem = cards.getCard(i);
				if(elem.getName().equals("Apprenti") || elem.getName().equals("Apprenti"+"1") || elem.getName().equals("Apprenti"+"2")|| elem.getName().equals("Apprenti"+"3")|| elem.getName().equals("Apprenti"+"4")|| elem.getName().equals("Apprenti"+"5")|| elem.getName().equals("Apprenti"+"6")|| elem.getName().equals("Apprenti"+"7") || elem.getName().equals("Apprenti"+"8")){
					addWorker(elem);
					Card c = elem;
					cards.getCards().remove(elem);
					cards.getCards().add(c);
					stop = true;
				}
		}
		numberActionLeft++;
	}

	/**
	 * ask to the player the action he want to do and do the action with an other method
	 * @param send the workers wich were already send 
	 * @param game the game wich is played
	 */
	public abstract boolean play(Game game,ArrayList<String> send);

	/**
	 * this method add a card to the Arraylist choice in parameters 
	 * @param carte the card to add to the ArrayList
	 */
	public void addWorker(Card carte){
			if(carte != null){
				myWorkers.add(carte);
			}
			numberActionLeft--;
	}

	/**
	 * this method add a card to the Arraylist myChantiers
	 * @param b the chantier to add to the ArrayList
	 */
	public void addChantier(Card b){
		if(b != null){
			Chantier c = new Chantier(b);
			myChantiers.add(c);
		}
		numberActionLeft--;
	}
	

	/**
	 * this method remove a card to the Arraylist choice in parameters (myMachines,myWorkers,myBuldings)
	 * @param num the card to remove of the ArrayList
	 */
	public void removeWorker(int num){
		myWorkers.remove(num);
	}

	/**
	 * return the name of the player
	 * @return a String wich is the attribute name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * this method is used ti start a bulding in taking a new card (type bulding) on the deck
	 * @param b the bulding to take on the dek
	 */
	public void openBulding(Bulding b) {
		if(b != null){
			myChantiers.add(new Chantier(b));
		}
		this.numberActionLeft--;
	}

	/**
	 * this method is used to add a new worker to our myWorkers. The cost of the worker will be remove of the ecus of the player
	 * @param w the num of the card to take on the dek
	 */
	public void recrutWorker(Worker w) {
		if(w != null){
			myWorkers.add(w);
		}
		this.numberActionLeft--;
	}

	/**
	 * This method is used to send a worker to a bulding 
	 * @param numw the num of the worker to send in your hand
	 * @param numC the num of the chantier to send in your hand
	 * @param cost the cost
	 * @return true if the worker have been send working
	 */
	public boolean sendWorking(int numW, int numC,int cost) {
		int cout = 0;
		boolean ret = false;
		if(myWorkers.get(numW) instanceof Worker){
			Worker w =  (Worker) myWorkers.get(numW);
			cout = w.getCost();
		}

		if(cout <=ecus){
			if(numW >= 0 && numW<myWorkers.size() && numC >= 0 && numC<myChantiers.size()){
				myChantiers.get(numC).addWorker(myWorkers.get(numW));
				ecus = ecus - cout;
				this.removeWorker(numW);
				ret = true;
				numberActionLeft = numberActionLeft - cost;
			}
		} else {
			System.out.println("vous ne possede pas assez d'argent");
			ret = false;
		}
		return ret;
	}

	/**
	* add 5 ecus of the attribute ecus
	* @param nb the number of ecus to take
	*/
	public void takeEcus(int nb) {
		this.ecus = this.ecus+nb;
		if(nb==1){
			numberActionLeft--;
		}
		if(nb==3){
			numberActionLeft = numberActionLeft - 2;
		}
		if(nb==6){
			numberActionLeft = numberActionLeft - 3;
		}
	}

	/**
	 * this method finish a bulding and give the points of victory of it
	 * @param num the number of the chantier
	 */
	public boolean finishAction(int num) {
		boolean ret = false;
		Chantier c = myChantiers.get(num);
		if(c.enoughRessources()){
			ret = true;
			if(c.getBuild() instanceof Bulding){
				myChantiers.remove(num);
				Bulding b = (Bulding) c.getBuild();
				victoryPoints = victoryPoints + b.getPointVictory();
				ecus = ecus+ b.getEcus();
			}
			if(c.getBuild() instanceof Machine){
				myChantiers.remove(num);
				Machine m = (Machine) c.getBuild();
				victoryPoints = victoryPoints + m.getPointVictory();
				myWorkers.add(m);
			}
			for(Card elem: c.getWorkers()){
				myWorkers.add(elem);
			}

		} else {
			System.out.println("les ressources necessaires a la construction ne sont pas reuni");
		}
		return ret;
	}

	/**
	 * give the number of actions lefts of the player
	 * @return an int wich corresponds to the attribute numberActionsLeft
	 */
	public int getNumAction() {
		return numberActionLeft;
	}

	/**
	 * give the number of points of victory of the player
	 * @return an int wich corresponds to the attribute victoryPoints
	 */
	public int getPoints() {
		return victoryPoints;
	}

	public boolean buyAction(){
		boolean ret =false;
		if(ecus >=5){
			ecus = ecus-5;
			numberActionLeft++;
			ret = true;
		} else {
			System.out.println("vous ne possede pas assez d'argent");
		}
		return ret;
	}

	public String toString() {
		String ret = "";
		ret = ret + this.name + "\n";
		ret = ret + "================================================ \n";
		ret = ret +  "Vos chantiers \n";
		ret = ret + "================================================ \n";
		ret = ret + "\n";
		int i = 1;
		
		int l= 0;
		while(l+5<myChantiers.size()){
			ret = ret + this.printMyChantiers(l,l+5);
			l=l+5;
		}
		ret = ret + this.printMyChantiers(l, myChantiers.size());
		ret = ret + "\n";

		ret = ret + "================================================ \n";
		ret = ret +  "Votre main\n";
		ret = ret + "================================================ \n";
		ret = ret + "nombre d'ecus: " + ecus + "      nombre de points de victoire: " + victoryPoints+"      nombre d'actions restantes: " +numberActionLeft + "\n";
		ret = ret + "\n";

		l= 0;
		while(l+5<myWorkers.size()){
			ret = ret + this.printMyWorkers(l,l+5);
			l=l+5;
		}
		ret = ret + this.printMyWorkers(l, myWorkers.size());
		ret = ret + "\n";
		return ret;
	}

	public void resetNumberActionLeft() {
		this.numberActionLeft = 3;
	}

	public ArrayList<Card> getMyWorkers() {
		return myWorkers;
	}

	public ArrayList<Chantier> getMyChantiers() {
		return myChantiers;
	}

	public void victoryPointsAdd(){
		while(ecus>9){
			victoryPoints++;
			ecus = ecus-10;
		}
	}

	public String printMyChantiers(int debut,int fin){
		String ret = "";
			ret = ret + "\n";
			for(int i = debut+1; i<=fin;i++){
				ret = ret + "_________________________" + "   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|" + myChantiers.get(i-1).getBuild().getName()+"("+i+")";
				for(int j=1;j<21-myChantiers.get(i-1).getBuild().getName().length();j++){
					ret = ret + " ";
				}
				ret = ret + "|   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			String truc;
			int nb;

			for(int i = debut+1; i<=fin;i++){
				if(myChantiers.get(i-1).getBuild() instanceof Machine){
					Machine m = (Machine) myChantiers.get(i-1).getBuild();
					truc =  m.prod() + " produit:";
					nb = m.nbProd();
					ret = ret + "|" + truc + nb +"       ";
					ret = ret + "|   ";
				}	
				
				if(myChantiers.get(i-1).getBuild() instanceof Bulding){
					Bulding b = (Bulding) myChantiers.get(i-1).getBuild();
					truc =  "ecus gagnes:";
					nb = b.getEcus();
					if(String.valueOf(nb).length() == 2){
						ret = ret + "|" + truc + nb +"         ";
					} else {
						ret = ret + "|" + truc + nb +"          ";
					}
					ret = ret + "|   ";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|Pierre:" + myChantiers.get(i-1).numberStone() +"/" +myChantiers.get(i-1).getBuild().getStone() + "             ";
				ret = ret + "|   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|Bois:"+ myChantiers.get(i-1).numberWood() +"/"  + myChantiers.get(i-1).getBuild().getwood() + "               ";
				ret = ret + "|   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|Tuile:"+ myChantiers.get(i-1).numberTuile() +"/"  + myChantiers.get(i-1).getBuild().getTuile() + "              ";
				ret = ret + "|   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|Savoir:"+ myChantiers.get(i-1).numberKnowledge() +"/"  + myChantiers.get(i-1).getBuild().getTuile() + "             ";
				ret = ret + "|   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}


			for(int i = debut+1; i<=fin;i++){
				if(myChantiers.get(i-1).getBuild() instanceof Machine){
					Machine m = (Machine) myChantiers.get(i-1).getBuild();
					ret = ret + "|Point de victoire:" +m.getPointVictory() +"    |   ";
				}
				if(myChantiers.get(i-1).getBuild() instanceof Bulding){
					Bulding b = (Bulding) myChantiers.get(i-1).getBuild();
					ret = ret + "|Point de victoire:" +b.getPointVictory() +"    |   ";
				}if(myChantiers.get(i-1).getBuild() instanceof Worker){
					ret = ret + "|                       |   ";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|_______________________|   ";
			}

		return ret;
	}

	public String printMyWorkers(int debut,int fin){
		String ret = "";
			ret = ret + "\n";
			for(int i = debut+1; i<=fin;i++){
				ret = ret + "_________________________" + "   ";
				if(i==myWorkers.size()){
					ret= ret + "\n";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|" + myWorkers.get(i-1).getName()+"("+i+")";
				for(int j=1;j<21-myWorkers.get(i-1).getName().length();j++){
					ret = ret + " ";
				}
				ret = ret + "|   ";
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			String truc;
			int nb;

			for(int i = debut+1; i<=fin;i++){
				if(myWorkers.get(i-1) instanceof Machine){
					truc =  "ecus coutes:";
					nb = 0;
					if(String.valueOf(nb).length() == 2){
						ret = ret + "|" + truc + nb +"         ";
					} else {
						ret = ret + "|" + truc + nb +"          ";
					}
					ret = ret + "|   ";
					}	
				
				if(myWorkers.get(i-1) instanceof Worker){
					Worker w = (Worker) myWorkers.get(i-1);
					truc =  "ecus coutes:";
					nb = w.getCost();
					if(String.valueOf(nb).length() == 2){
						ret = ret + "|" + truc + nb +"         ";
					} else {
						ret = ret + "|" + truc + nb +"          ";
					}
					ret = ret + "|   ";
					
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			for(int i = debut+1; i<=fin;i++){
				if(myWorkers.get(i-1) instanceof Worker){
					ret = ret + "|Pierre:" + myWorkers.get(i-1).getStone() + "               ";
					ret = ret + "|   ";
				}
				if(myWorkers.get(i-1) instanceof Machine){
					Machine m = (Machine) myWorkers.get(i-1);
					ret = ret + "|Pierre:" + m.getStoneP() + "               ";
					ret = ret + "|   ";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			for(int i = debut+1; i<=fin;i++){
				if(myWorkers.get(i-1) instanceof Worker){
					ret = ret + "|Bois:" + myWorkers.get(i-1).getwood() + "                 ";
					ret = ret + "|   ";
				}
				if(myWorkers.get(i-1) instanceof Machine){
					Machine m = (Machine) myWorkers.get(i-1);
					ret = ret + "|Bois:" + m.getWoodP() + "                 ";
					ret = ret + "|   ";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			for(int i = debut+1; i<=fin;i++){
				if(myWorkers.get(i-1) instanceof Worker){
					ret = ret + "|Tuile:" + myWorkers.get(i-1).getTuile() + "                ";
					ret = ret + "|   ";
				}
				if(myWorkers.get(i-1) instanceof Machine){
					Machine m = (Machine) myWorkers.get(i-1);
					ret = ret + "|Tuile:" + m.getTuileP() + "                ";
					ret = ret + "|   ";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}

			for(int i = debut+1; i<=fin;i++){
				if(myWorkers.get(i-1) instanceof Worker){
					ret = ret + "|Savoir:" + myWorkers.get(i-1).getKnowledge() + "               ";
					ret = ret + "|   ";
				}
				if(myWorkers.get(i-1) instanceof Machine){
					Machine m = (Machine) myWorkers.get(i-1);
					ret = ret + "|Savoir:" + m.getKnowledgeP() + "               ";
					ret = ret + "|   ";
				}
			}
			if(debut+1 <=fin){
				ret= ret + "\n";
			}
			

			for(int i = debut+1; i<=fin;i++){
				ret = ret + "|_______________________|   ";
			}

		return ret;
		
	}

	public int getNumberActionLeft() {
		return numberActionLeft;
	}

	public int getEcus() {
		return ecus;
	}

	public void setNumberActionLeft(int numberActionLeft) {
		this.numberActionLeft = numberActionLeft;
	}

	

}