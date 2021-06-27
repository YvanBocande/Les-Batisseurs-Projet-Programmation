import java.util.Scanner;

import Game.*;
import View.VueTotal;

public class Launcher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Version graphique ou textuel (G/T): ");
        String choix = scan.next();

        while(!choix.equalsIgnoreCase("G") &&  !choix.equalsIgnoreCase("T")){
            System.out.println("choix incorrect");
            choix = scan.next();
        }

        if(choix.equalsIgnoreCase("T")){
            Game Test = new Game(false);
        } else {
            VueTotal vue = new VueTotal();
            vue.setVisible(true);
        }
        
    }
}
  