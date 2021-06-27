package Game;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Deck implements Serializable{

	private ArrayList<Card> cards;

	/**
	 * initialize the attribute cards using the methods initializeDeck and suffleDeck
	 * @param type the type of deck to create
	 */
	public Deck(String type) {
		if (type != null){
			this.cards = new ArrayList<Card>();
			if(type.equalsIgnoreCase("B")){
				initializeDeckBuldings("../data/buldings.txt");
			}
			if(type.equalsIgnoreCase("M")){
				initializeDeckMachines("../data/machines.txt");
			}
			if(type.equalsIgnoreCase("W")){
				initializeDeckWorkers("../data/workers.txt");
			}
			if(type.equalsIgnoreCase("BM")){
				initializeDeckBuldings("../data/buldings.txt");
				initializeDeckMachines("../data/machines.txt");
			}
			if(type.equalsIgnoreCase("WM")){
				initializeDeckWorkers("../data/workers.txt");
				initializeDeckMachines("../data/machines.txt");
			}
			if(type.equalsIgnoreCase("BMG")){
				initializeDeckBuldings("../data/buldingsG.txt");
				initializeDeckMachines("../data/machinesG.txt");
			}
			if(type.equalsIgnoreCase("WG")){
				initializeDeckWorkers("../data/workersG.txt");
			}
			this.suffleDeck();
		}
	}

	/**
	 * create the workers cards using the constructor of card of the deck and put them in the attribute card
	 * @param file the name of the file 
	 */
	public void initializeDeckWorkers(String file) {
		boolean fini = false;
		String nom;
		int cout;
		int pierre;
		int tuile;
		int bois;
		int savoir;

		try {
		Scanner in = new Scanner(new FileReader(file));
		
		
		while(fini == false && in.hasNextLine()){
			nom = in.next().trim();
			cout = in.nextInt();
			pierre = in.nextInt();
			bois = in.nextInt();
			savoir = in.nextInt();
			tuile = in.nextInt();
			Worker worker = new Worker(tuile,pierre,savoir,bois,nom,cout);
			cards.add(worker);
		}


		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 * create the buldings cards using the constructor of card of the deck and put them in the attribute card
	 * 	@param file the name of the file 
	 */
	public void initializeDeckBuldings(String file) {
		String nom;
		int ecus;
		int points;
		int tuile;
		int bois;
		int savoir;
		int pierre;

		try {
		Scanner in = new Scanner(new FileReader(file));
		
		
		while(in.hasNextLine()){
			nom = in.next().trim();
			ecus = in.nextInt();
			points = in.nextInt();
			pierre = in.nextInt();
			bois = in.nextInt();
			savoir = in.nextInt();
			tuile = in.nextInt();
			Bulding bulding = new Bulding(tuile, pierre, savoir, bois, nom, points,ecus);
			cards.add(bulding);
		}


		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 * create the machines cards using the constructor of card of the deck and put them in the attribute card
	 * @param file the name of the file 
	 */
	public void initializeDeckMachines(String file) {
		String nom;
		int points;
		int tuile;
		int bois;
		int savoir;
		int pierre;
		int tuileP;
		int boisP;
		int savoirP;
		int pierreP;

		try {
		Scanner in = new Scanner(new FileReader(file));
		
		
		while(in.hasNextLine()){
			nom = in.next().trim();
			pierreP = in.nextInt();
			boisP = in.nextInt();
			savoirP = in.nextInt();
			tuileP = in.nextInt();
			points = in.nextInt();
			pierre = in.nextInt();
			bois = in.nextInt();
			savoir = in.nextInt();
			tuile = in.nextInt();

			Machine machine = new Machine(tuile, pierre, savoir, bois, nom, pierreP, boisP, savoirP, tuileP, points);
			cards.add(machine);
		}


		} catch (IOException e){
			System.out.println(e.getMessage());
		}

	}

	/**
	 * change the order of the cards in the arrayList in attributes
	 */
	public void suffleDeck() {
		ArrayList<Card> tmp = new ArrayList<Card>();
		Random rand = new Random();

		while(cards.size()>0){
			int number = rand.nextInt(cards.size()-1 - 0 + 1) + 0;
			tmp.add(cards.get(number));
			cards.remove(number);
		}

		this.cards = tmp;
	}

	/**
	 * return the 5 first card of the deck
	 * @return the cart wich is in the first postion of the arraylist
	*/
	public String Show5FisrtCards() {
		String ret = "";
		for(int i = 1; i<6;i++){
			ret = ret + "_________________________" + "   ";
		}
		ret = ret + "\n";

		for(int i = 1; i<6;i++){
			ret = ret + "|" + cards.get(i-1).getName()+"("+i+")";
			for(int j=1;j<21-cards.get(i-1).getName().length();j++){
				ret = ret + " ";
			}
			ret = ret + "|   ";
		}
		ret = ret + "\n";

		String truc;
		int nb;

		for(int i = 1; i<6;i++){
			if(cards.get(i-1) instanceof Machine){
				Machine m = (Machine) cards.get(i-1);
				truc =  m.prod() + " produit:";
				nb = m.nbProd();
				ret = ret + "|" + truc + nb +"       ";
				ret = ret + "|   ";
			}	
			
			if(cards.get(i-1) instanceof Bulding){
				Bulding b = (Bulding) cards.get(i-1);
				truc =  "ecus gagnes:";
				nb = b.getEcus();
				if(String.valueOf(nb).length() == 2){
					ret = ret + "|" + truc + nb +"         ";
				} else {
					ret = ret + "|" + truc + nb +"          ";
				}
				ret = ret + "|   ";
			}

			if(cards.get(i-1) instanceof Worker){
				Worker w = (Worker) cards.get(i-1);
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
		ret= ret + "\n";

		for(int i = 1; i<6;i++){
			ret = ret + "|Pierre:" + cards.get(i-1).getStone() + "               ";
			ret = ret + "|   ";
		}
		ret= ret + "\n";

		for(int i = 1; i<6;i++){
			ret = ret + "|Bois:" + cards.get(i-1).getwood() + "                 ";
			ret = ret + "|   ";
		}
		ret= ret + "\n";

		for(int i = 1; i<6;i++){
			ret = ret + "|Tuile:" + cards.get(i-1).getTuile() + "                ";
			ret = ret + "|   ";
		}
		ret= ret + "\n";

		for(int i = 1; i<6;i++){
			ret = ret + "|Savoir:" + cards.get(i-1).getKnowledge() + "               ";
			ret = ret + "|   ";
		}
		ret= ret + "\n";

		for(int i = 1; i<6;i++){
			if(cards.get(i-1) instanceof Machine){
				Machine m = (Machine) cards.get(i-1);
				ret = ret + "|Point de victoire:" +m.getPointVictory() +"    |   ";
			}
			if(cards.get(i-1) instanceof Bulding){
				Bulding b = (Bulding) cards.get(i-1);
				ret = ret + "|Point de victoire:" +b.getPointVictory() +"    |   ";
			}if(cards.get(i-1) instanceof Worker){
				ret = ret + "|                       |   ";
			}
		}
		ret= ret + "\n";
		ret = ret + "|_______________________|   |_______________________|   |_______________________|   |_______________________|   |_______________________|   ";

		return ret;
	}

	/**
	 * show the card wich is at the number passed in parameters in the ArrayList
	 * @param number the number of the card to return
	 * @return a Card wich is at the number in the arraylist
	 */
	public Card getCard(int number) {
		return cards.get(number);
	}

	/**
	 * delete the card wich is at the number passed in parameters in the ArrayList
	 * @param num the number of the card to delete
	 */
	public void deleteCard(int num){
		Card c = cards.get(num);
		cards.remove(num);
		cards.add(c);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
}