package Game;
import Utilitaire.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;


import java.awt.*;


import Utilitaire.Scan;

/**
 * this class is used to start a game and to manage the players during a game
 * @author Yvan Bocande
 */
public class Game implements Serializable{


	private ArrayList<Player> players;
	private int numberPlayer;
	private int curent;
	private Deck deckWorkers;
	private Deck deckBuldings;

	/**
	 * this constructor instantiates an object of type Game and starts the game with the configuration file. It can load a game in progress.
	 * @param graphic true if if a a grpahic version a a game
	 */
	public Game(boolean graphic) {
		players = new ArrayList<Player>();
		curent = 1;
	

		if(graphic == false){
			deckBuldings = new Deck("BM");
			deckWorkers = new Deck("W");
			gaming();
		} else {
			deckBuldings = new Deck("BMG");
			deckWorkers = new Deck("WG");
		}
	}

	/**
	 * this method starts the game
	 * @return the number of the actionb choice
	 */
	public int startGame() {
		System.out.println(" _       _____   _____        _____       ___   _____   _____   _   _____   _____   _____   _   _   _____    _____ 		");
		System.out.println("| |     | ____| /  ___/      |  _  \\     /   | |_   _| |_   _| | | /  ___/ /  ___/ | ____| | | | | |  _  \\  /  ___/ ");
		System.out.println("| |     | |__   | |___       | |_| |    / /| |   | |     | |   | | | |___  | |___  | |__   | | | | | |_| |  | |___  ");
		System.out.println("| |     |  __|  \\___  \\      |  _  |   / / | |   | |     | |   | | \\___  \\ \\___  \\ |  __|  | | | | |  _  /  \\___  \\ ");
		System.out.println("| |___  | |___   ___| |      | |_| |  / /  | |   | |     | |   | |  ___| |  ___| | | |___  | |_| | | | \\ \\   ___| | ");
		System.out.println("|_____| |_____| /_____/      |_____/ /_/   |_|   |_|     |_|   |_| /_____/ /_____/ |_____| \\_____/ |_|  \\_\\ /_____/ ");
		System.out.println("\n");
		System.out.println("========================================= Les batisseurs Moyen-Age ====================================================");
		System.out.println("\n");

		System.out.println("1: Jouer");
		System.out.println("2: Regles");
		System.out.println("3: Quitter le jeu");

		boolean stop = false;
		int ret =  Scan.intscanNum();
		while(ret !=1 && ret != 2 && ret != 3){
			System.out.println("entree incorrect");
			ret = Scan.intscanNum();
		}
		return ret;
	}

	/**
	 * change the player to play
	 */
	public void changeCurrentPlayer() {
		if(curent <numberPlayer){
			curent++;
		} else {
			curent = 1;
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * print the board of the game to play
	 */
	public String toString() {
		String ret = "";
		ret = ret + "Au tour de " + players.get(curent-1).getName() + "\n";
		ret = ret + "=============================\n";
		ret = ret + "pioche des batiments:\n";
		ret = ret +"=============================\n";
		ret = ret + "\n";
		ret = ret + deckBuldings.Show5FisrtCards();		
		ret = ret +"\n";
		ret = ret +"=============================\n";
		ret = ret +"pioche des ouvriers: \n";
		ret = ret +"=============================\n";
		ret = ret + "\n";
		ret = ret + deckWorkers.Show5FisrtCards();
		ret = ret +"\n";
		return ret;
	}

	/**
	 * return the deck of cards of the game
	 * @return the attribute deck of type Deck of the object
	 */
	public Deck getDeckWorkers() {
		return this.deckWorkers;
	}

	public Deck getDeckBuldings() {
		return deckBuldings;
	}

	public void play(){

	}

	public void gaming(){
		int choice = this.startGame();
		if(choice == 1){
			this.selectionPartie();
			this.choixNoms();
			this.gameplay();
		}
		if(choice == 2){
			this.rules();
		}
		if(choice == 3){
		
		}
	}

	/**
	 * open a document with the rules
	 */
	public void rules(){
		System.out.println("\n");
		try{
			BufferedReader lecteur = new BufferedReader (new FileReader("../data/rules.txt"));
			String s = lecteur.readLine();
			while(s!=null){
				System.out.println(s);
				s = lecteur.readLine();
			}
		} catch (IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("\n");
		this.gaming();
	}

	/**
	 * use to select the number of player of the game
	 */
	public void selectionNombre(){
		System.out.println("     _   _____   _   _   _____   _____   ");
		System.out.println("    | | /  _  \\ | | | | | ____| |  _  \\  ");
		System.out.println("    | | | | | | | | | | | |__   | |_| |  ");
		System.out.println(" _  | | | | | | | | | | |  __|  |  _  /  ");
		System.out.println("| |_| | | |_| | | |_| | | |___  | | \\ \\  ");
		System.out.println("\\_____/ \\_____/ \\_____/ |_____| |_|  \\_\\ ");
		System.out.println("=================================================================");
		System.out.println("\n");
		System.out.println("nombre de joueurs: ");
		System.out.println("2) 2 joueurs");
		System.out.println("3) 3 joueurs");
		System.out.println("4) 4 joueurs");
		System.out.print("Votre choix: ");
		numberPlayer = Scan.intscanNum();
		while(numberPlayer <2 || numberPlayer>4 ){
			System.out.print("Entree incorrect, reesayez: ");
			numberPlayer = Scan.intscanNum();
		}
	}

	/**
	 * select if there is a new game or charg an other game
	 */
	public void selectionPartie(){
		System.out.println("     _   _____   _   _   _____   _____   ");
		System.out.println("    | | /  _  \\ | | | | | ____| |  _  \\  ");
		System.out.println("    | | | | | | | | | | | |__   | |_| |  ");
		System.out.println(" _  | | | | | | | | | | |  __|  |  _  /  ");
		System.out.println("| |_| | | |_| | | |_| | | |___  | | \\ \\  ");
		System.out.println("\\_____/ \\_____/ \\_____/ |_____| |_|  \\_\\ ");
		System.out.println("=================================================================");
		System.out.println("\n");
		System.out.println("1) Nouvelle partie");
		System.out.println("2) Charger une partie");
		System.out.print("Votre choix: ");
		int choix = Scan.intscanNum();;
		while(choix != 1 && choix != 2 ){
			System.out.println("Entree incorrect");
			choix = Scan.intscanNum();;
		}
		if(choix == 1){
			this.selectionNombre();
		}
		if(choix == 2){
			String file = this.preLoad();
			if(file.equals("rrr")){
				this.selectionPartie();
			}else{
				this.load(file);
				this.gameplay();
			}
		}
	}

	/**
	 * scan to choice the names of the players
	 */
	public void choixNoms(){
		Scanner scan = new Scanner(System.in);
		System.out.println("     _   _____   _   _   _____   _____   ");
		System.out.println("    | | /  _  \\ | | | | | ____| |  _  \\  ");
		System.out.println("    | | | | | | | | | | | |__   | |_| |  ");
		System.out.println(" _  | | | | | | | | | | |  __|  |  _  /  ");
		System.out.println("| |_| | | |_| | | |_| | | |___  | | \\ \\  ");
		System.out.println("\\_____/ \\_____/ \\_____/ |_____| |_|  \\_\\ ");
		System.out.println("=================================================================");
		System.out.println("\n");

		System.out.println("Entrer le nom des joueurs:");
		System.out.println("Pour jouer face a des ordinateurs, indiquer ordinateur comme nom:");
		for (int i = 1; i<=numberPlayer;i++){
			System.out.print("joueur " + i + ": ");
			String name = scan.next();
			this.addPlayer(name,i);
		}


		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("\n");

	}

	/**
	 * this methods is used to make play the player. Its not stop while no player have win
	 */
	public void gameplay(){
		Scanner scan = new Scanner(System.in);
		boolean stop = false;
		while(stop == false){

			players.get(curent - 1).resetNumberActionLeft();
			ArrayList<String> send = new ArrayList<String>();
			while(players.get(curent - 1).getNumAction()>0 && players.get(curent-1).getPoints()<17 && stop == false){
				stop = players.get(curent-1).play(this,send);

				System.out.println("\n");
				System.out.println("\n");
			}
			Player p = aGagner();
			if(p != null){
				System.out.println("Bravo " + p.getName() + " tu as gagne!!!!!!!!!!!!!!");
				this.classement();
				System.out.println("\n");
				stop = true;
				System.out.println("voulez vous rejouer? (O/N)");
				String choix = scan.next();
				if(choix.equalsIgnoreCase("O")){
					this.gaming();
				}
			}
			players.get(curent - 1).resetNumberActionLeft();
			this.changeCurrentPlayer();
		}
	}
	
	/**
	 * used to know if a player have more than 17 points
	 * @return the Player who have win (null if nobody have win)
	 */
	public Player aGagner(){
		if(players.get(curent-1).getPoints()>=17){
			for(Player elem:players){
				elem.victoryPointsAdd();
			}
			Player p = new HumanPlayer("yvan",8,deckWorkers);
			for(Player elem:players){
				if(elem.getPoints() > p.getPoints()){
					p = elem;
				}
			}
			return p;
		} else {
			return null;
		}
	}

	/**
	 * print the classement of the players(more points)
	 */
	public void classement(){
		int i =1;
		while(players.isEmpty() != true){
			Player p = new HumanPlayer("yvan",8,deckWorkers);
			for(Player elem:players){
				if(elem.getPoints() > p.getPoints()){
					p = elem;
				}
			}
			System.out.println(i+": " + p.getName() + " avec " + p.getPoints() + " points.");
			players.remove(p);
			i++;
		}
	}

	/**
	 * print the classement of the players(more points) for the grafical version to print
	 * @return an Arraylist with the classement
	 */
	public ArrayList<String> classementG(){
		ArrayList<String> ret = new ArrayList<String>();
		int i =1;
		while(players.isEmpty() != true){
			Player p = new HumanPlayer("yvan",8,deckWorkers);
			for(Player elem:players){
				if(elem.getPoints() > p.getPoints()){
					p = elem;
				}
			}
			ret.add(p.getName() + " avec " + p.getPoints() + " points.");
			players.remove(p);
			i++;
		}

		return ret;
	}

	/**
	 * used to know if a player have more than 17 points
	 * @return the Player who have win (null if nobody have win)
	 */
	public Player aGagnerG(){
		boolean fini = false;
		for(Player elem:players){
			if(elem.getPoints()>=17){
				fini = true;
			}
		}
		if(fini==true){
			for(Player elem:players){
				elem.victoryPointsAdd();
			}
			Player p = new HumanPlayer("yvan",8,deckWorkers);
			for(Player elem:players){
				if(elem.getPoints() > p.getPoints()){
					p = elem;
				}
			}
			return p;
		} else {
			return null;
		}
	}

	/**
	 * save the game in the file passed in parameters with a serialization
	 * @param file the name of the file where save
	 */
	public void save(String file){
		try{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(this);
			out.close();
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Partie sauvegardee avec succes");
	}

	/**
	 * give the attributes of the game wich was save to the new game
	 * @param file the name of the file where load
	 */
	public void load(String file){

		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("../saves/" + file));
			Game g = (Game) in.readObject();
			in.close();
			this.players = g.getPlayers();
			this.numberPlayer = g.getNumberPlayer();
			this.curent = g.getCurent();
			this.deckBuldings = g.getDeckBuldings();
			this.deckWorkers = g.getDeckBuldings();
		} catch(IOException e){
			System.out.println(e.getMessage());
		} catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Partie chargee avec succes!");
		System.out.println("\n");
	}

	public Game loadG(String file){
		Game g = null;

		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("../saves/" + file));
			g = (Game) in.readObject();
			in.close();
		} catch(IOException e){
			System.out.println(e.getMessage());
		} catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		}
		System.out.println("Partie chargee avec succes!");
		System.out.println("\n");

		return g;
	}

	/**
	 * return the nmber of player
	 * @return an int wich is the number of players
	 */
	public int getNumberPlayer() {
		return numberPlayer;
	}

	/**
	 * return the number of the current player
	 * @return an int wich is the attribute current
	 */
	public int getCurent() {
		return curent;
	}

	public String preLoad(){

		//affiche les sauvegardes
		System.out.println("\n");
		System.out.println("Voici les sauvegarde disponibles: ");
		String[] pathnames;
		File f = new File("../saves");
		pathnames = f.list();
		int i = 1;
		for (String pathname : pathnames) {
            System.out.println(i + ": " + pathname);
			i++;
        }
		System.out.println("\n");
		System.out.println(0 + ": retour");
		System.out.print("numero de la sauvegarde que vous voulez charger: ");
		int n = Scan.intscanNum();
		if(n!= 0){
			while(n<1 || n>pathnames.length){
				System.out.println("entree incorrect");
				n = Scan.intscanNum();;
			}
		} else {
			return "rrr";
		}
		return pathnames[n-1];
	}

	/**
	 * change the number of players
	 * @param numberPlayer the new number of players
	 */
	public void setNumberPlayer(int numberPlayer) {
		this.numberPlayer = numberPlayer;
	}

	public void addPlayer(String name, int i){
		if(name.equals("ordinateur")){
			players.add(new EasyPlayer(name+i,i-1,deckWorkers));
		} else {
			players.add(new HumanPlayer(name,i-1,deckWorkers));
		}
	}

	/**
	 * open the pdf with the rules of the game
	 */
	public void printPDF(){
        File fichier = new File("../data/rules.pdf");
        // On verifie que la classe Desktop soit bien supportee : 
        if (Desktop.isDesktopSupported()) { 
            // On recupere l'instance du desktop : 
            Desktop desktop = Desktop.getDesktop(); 
            // On verifie que la fonction open est bien supportee : 
            if (desktop.isSupported(Desktop.Action.OPEN)) { 
                // Et on lance l'application associe au fichier pour l'ouvrir : 
                try { 
                desktop.open(fichier); 
                }catch(IOException ex) {
                    // Gestion de l'erreur.
                    ex.getMessage();
                } 
            }
        }
    }
}