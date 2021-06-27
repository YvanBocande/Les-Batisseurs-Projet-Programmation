package Game;

import Utilitaire.Scan;
import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class is used for a player to play. It ask what he want to do and how he want to do.
 */
public class HumanPlayer extends Player implements Serializable{


	/**
	 * the constructor initializes the auto player using the player constructor.
	 * @param name a String wich is the name of the player
	 * @param number an int wich is the number of player.
	 * @param cards the cards of the deck og the game
	 */
	public HumanPlayer(String name, int number, Deck cards) {
		super(name, number, cards);
	}

	/**
	 * this methods makes play the human player using the scanner.
	 * @param game the Game of the player
	 * @param send the workers wich were already send 
	 */
	public boolean play(Game game,ArrayList<String> send) {
		boolean ret = false;
		Scanner scan = new Scanner(System.in);
		boolean stop =false;
		System.out.println(game);
		System.out.println(this);
		System.out.println("1: Ouvrir un chantier");
		System.out.println("2: Recruter un ouvrier");
		System.out.println("3: Envoyer un ouvrier travailler sur un chantier");
		System.out.println("4: Prendre des ecus: 1 actions = 1 ecus, 2 actions = 4 ecus, 3 actions = 6 ecus");
		System.out.println("5: Acheter une action suplementaire (5 ecus)");
		System.out.println("6: Terminer un chantier");
		System.out.println("7: Sauvegarder la partie en cours");
		System.out.println("\n");

		while(stop != true){
			System.out.print("Votre choix: ");
			int choice = Scan.intscanNum();
			int secondChoice;
			int thirdChoice;
			if(choice >=1 && choice <8){

				if(choice == 1){
					System.out.print("numero du chantier: ");
					secondChoice = Scan.intscanNum();
					if(secondChoice>0 && secondChoice <6){
						super.addChantier(game.getDeckBuldings().getCard(secondChoice-1));
						game.getDeckBuldings().deleteCard(secondChoice-1);
						stop = true;
					} else {
						System.out.println("entree incorrect");
					}
				}
				if(choice == 2){
					System.out.print("numero de l'ouvrier: ");
					secondChoice = Scan.intscanNum();
					if(secondChoice>0 && secondChoice <6){
						super.addWorker(game.getDeckWorkers().getCard(secondChoice-1));
						game.getDeckWorkers().deleteCard(secondChoice-1);
						stop = true;
					} else {
						System.out.println("entree incorrect");
					}
				}
				if(choice == 3){
					System.out.print("numero de l'ouvrier: ");
					secondChoice = Scan.intscanNum();
					System.out.print("numero du chantier: ");
					thirdChoice = Scan.intscanNum();
					if(secondChoice>0 && secondChoice <=getMyWorkers().size() && thirdChoice>0 && thirdChoice <=getMyChantiers().size()){

						int cost=1;
						for(String elem:send){
							if(Integer.parseInt(elem) == thirdChoice-1){
								cost++;
							}
						}

						int a =thirdChoice-1;
						send.add(Integer.toString(a));
						if(cost <= getNumAction()){
							stop = super.sendWorking(secondChoice-1, thirdChoice-1,cost);
						} else {
							System.out.println("vous ne possedez pas assez d'actions");
							System.out.println("\n");
						}
					} else {
					System.out.println("entree incorrect");
					}
				}
				if(choice == 4){
					System.out.print("nombre d'actions depensees (1 actions = 1 ecus, 2 actions = 3 ecus, 3 actions = 6 ecus): ");
					secondChoice = Scan.intscanNum();
					if(secondChoice == 1 || secondChoice == 2 || secondChoice == 3 && secondChoice <= getNumAction()){
						if(secondChoice == 3){
							secondChoice = secondChoice*2;
						}
						if(secondChoice == 2){
							secondChoice = 3;
						}
						super.takeEcus(secondChoice);
						stop = true;
					} else {
						System.out.println("nombre entre incorrect");
					}
	
				}
				if(choice == 5){
					stop = super.buyAction();
				}
				if(choice == 6){
					System.out.print("numero du chantier a terminer: ");
					secondChoice = Scan.intscanNum();
					if(secondChoice > 0 && secondChoice <= getMyChantiers().size()){
						stop = finishAction(secondChoice-1);
					} else {
						System.out.println("entree incorrect");
					}
				}
				if(choice == 7){
					System.out.println("Etes-vous sûr?(O/N)");
					String sur = scan.next();
					if(sur.equalsIgnoreCase("O")){
						System.out.println("nom de la sauvegarde");
						String file = scan.next();
						game.save("../saves/"+ file +".txt");
						stop = true;
						ret = true;
					}
				}

			} else {
				System.out.println("\n");
				System.out.println("Choix incorrect!");
			}
		}
		return ret;
	}
}