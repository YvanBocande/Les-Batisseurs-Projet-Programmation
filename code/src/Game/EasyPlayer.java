package Game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * this class redifine the method play to play in a random way
 */
public class EasyPlayer extends AutoPlayer implements Serializable{

	/**
	 * the constructor initializes the player using the player constructor.
	 * @param name a String wich is the name of the player
	 * @param number an int wich is the number of player.
	 * @param cards the cards of the deck og the game
	 */	
	public EasyPlayer(String name, int number, Deck cards) {
		super(name, number, cards);
	}

	/**
	 * this class will play in a random way
	 */
	public boolean play(Game game, ArrayList<String> send) {
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
			int choice;

			int i = new Random().nextInt(10);
			if (i < 4 ) {
				choice =  3;
			} else {
				choice = 1 + (int)(Math.random() * ((6 - 1) + 1));
			}
			
			System.out.println(choice);
			int secondChoice;
			int thirdChoice;
			if(choice >=1 && choice <7){

				if(choice == 1 && getMyChantiers().size() < 3){
					secondChoice = 1 + (int)(Math.random() * ((5 - 1) + 1));
					super.addChantier(game.getDeckBuldings().getCard(secondChoice-1));
					game.getDeckBuldings().deleteCard(secondChoice-1);
					stop = true;
				}
				if(choice == 2 && getMyWorkers().size() <6){
					secondChoice = 1 + (int)(Math.random() * ((5 - 1) + 1));
					if(secondChoice>1){
						super.addWorker(game.getDeckWorkers().getCard(secondChoice-1));
						game.getDeckWorkers().deleteCard(secondChoice-1);
						stop = true;
					}
				}
				if(choice == 3){
					secondChoice = 1 + (int)(Math.random() * ((getMyWorkers().size() - 2) + 1));
					thirdChoice = 1 + (int)(Math.random() * ((getMyChantiers().size() - 2) + 1));
					if(secondChoice >1 && thirdChoice >1){
						int cost=1;
						for(String elem:send){
							if(Integer.parseInt(elem) == thirdChoice-1){
								cost++;
							}
						}

						int a =thirdChoice-1;
						send.add(Integer.toString(a));
						stop = super.sendWorking(secondChoice-1, thirdChoice-1,cost);
					}
				}
				if(choice == 4){
					secondChoice = 1 + (int)(Math.random() * ((3 - 1) + 1));
					if(secondChoice == 2 || secondChoice == 3){
						secondChoice = secondChoice*2;
					}
					super.takeEcus(secondChoice);
					stop = true;
				}
				if(choice == 5){
					stop = super.buyAction();
				}
				if(choice == 6){
					secondChoice = 1 + (int)(Math.random() * ((getMyChantiers().size() - 2) + 1));
					if(secondChoice >1 ){
						stop = finishAction(secondChoice-1);
					}
				}

			} else {
				System.out.println("\n");
				System.out.println("Choix incorrect!");
			}
		}
		return false;
	}

	/**
	 * this class will play in a random way
	 */
	public boolean playG(Game game, ArrayList<String> send) {
		boolean stop =false;

		while(stop != true){
			int choice;

			int i = new Random().nextInt(10);
			if (i < 4 ) {
				choice =  3;
			} else {
				choice = 1 + (int)(Math.random() * ((6 - 1) + 1));
			}
			
			System.out.println(choice);
			int secondChoice;
			int thirdChoice;
			if(choice >=1 && choice <7){

				if(choice == 1 && getMyChantiers().size() < 3){
					secondChoice = 1 + (int)(Math.random() * ((5 - 1) + 1));
					super.addChantier(game.getDeckBuldings().getCard(secondChoice-1));
					game.getDeckBuldings().deleteCard(secondChoice-1);
					stop = true;
				}
				if(choice == 2 && getMyWorkers().size() <6){
					secondChoice = 1 + (int)(Math.random() * ((5 - 1) + 1));
					if(secondChoice>1){
						super.addWorker(game.getDeckWorkers().getCard(secondChoice-1));
						game.getDeckWorkers().deleteCard(secondChoice-1);
						stop = true;
					}
				}
				if(choice == 3){
					secondChoice = 1 + (int)(Math.random() * ((getMyWorkers().size() - 2) + 1));
					thirdChoice = 1 + (int)(Math.random() * ((getMyChantiers().size() - 2) + 1));
					if(secondChoice >1 && thirdChoice >1){
						int cost=1;
						for(String elem:send){
							if(Integer.parseInt(elem) == thirdChoice-1){
								cost++;
							}
						}

						int a =thirdChoice-1;
						send.add(Integer.toString(a));
						stop = super.sendWorking(secondChoice-1, thirdChoice-1,cost);
					}
				}
				if(choice == 4){
					secondChoice = 1 + (int)(Math.random() * ((3 - 1) + 1));
					if(secondChoice == 2 || secondChoice == 3){
						secondChoice = secondChoice*2;
					}
					super.takeEcus(secondChoice);
					stop = true;
				}
				if(choice == 5){
					stop = super.buyAction();
				}
				if(choice == 6){
					secondChoice = 1 + (int)(Math.random() * ((getMyChantiers().size() - 2) + 1));
					if(secondChoice >1 ){
						stop = finishAction(secondChoice-1);
					}
				}

			} else {
			}
		}
		return false;
	}
		
}
