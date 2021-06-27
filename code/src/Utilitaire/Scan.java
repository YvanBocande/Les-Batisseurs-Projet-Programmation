package Utilitaire;

import java.util.Scanner;

public class Scan {

    public static int intscanNum(){
        Scanner scan = new Scanner(System.in);
        String in = scan.next();
        boolean isNumeric =  in.matches("[+-]?\\d*(\\.\\d+)?");
        while(!isNumeric){
            System.out.print("Vous devez entrer un nombre : ");
            in = scan.next();
            isNumeric =  in.matches("[+-]?\\d*(\\.\\d+)?");
        }

        return Integer.parseInt(in);
    }
}
