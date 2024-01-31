package IMT_HearStone;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import HearStoneClasseChampion.*;


public class Main {
    
    static Scanner scanner = new Scanner(System.in); // Scanner global
    // private static StringBuilder logs = new StringBuilder();

    
    public static void main(String[] args) {
    	System.out.println("Yahiani Hamza & Boubeker Ibrahim");
        // ajouterLog("Yahiani Hamza & Boubeker Ibrahim");
        Logger.log("Yahiani Hamza & Boubeker Ibrahim");

        // CrÃ©ation des Mages
    	
        Mage jaina = Mage.JAINA;
        Mage KHADGAR = Mage.KHADGAR;
       
        
        Deck.associerDeck(jaina);
        Deck.associerDeck(KHADGAR);
        
//        jaina.afficherDeck();
//        System.out.println("\n");
//        medivh.afficherDeck();

               
            
        Monitor MaitreDeLaPartie = new Monitor(scanner ,jaina , KHADGAR);
        	
        //MaitreDeLaPartie.jouerTour(jaina);
        while(((jaina.getPointsDeVie() > 0) || (KHADGAR.getPointsDeVie() > 0 )) ) {

	        	for (int i = 0; i < 10; i++) {
		        	System.out.println("-----------------------------");
		        }
                Logger.log("-----------------------------");
		        MaitreDeLaPartie.jouerTour(jaina);
		        System.out.println("\nTour de jaina fini");
                Logger.log("\nTour de jaina fini");
                // ajouterLog("\\nTour de jaina fini");
		        
	            System.out.println("\n");

		        for (int i = 0; i < 10; i++) {
		        	System.out.println("-----------------------------");
		        }
                // ajouterLog("--------------");
                Logger.log("--------------");
		        MaitreDeLaPartie.jouerTour(KHADGAR);
		        System.out.println("Tour de medivh fini");
                Logger.log("Tour de medivh fini");
		        
		        System.out.println("\nJe reset le mana ( +1 bien sur ^^) ");
                Logger.log("\nJe reset le mana ( +1 bien sur ^^) ");
		        jaina.recupererMana();
		        KHADGAR.recupererMana();
        }
        if (jaina.getPointsDeVie() <= 0) {
        	System.out.println("Medivh a gagné la partie.");
            Logger.log("Medivh a gagné la partie.");
        }
        else {
        	System.out.println("Jaina a gagné la partie.");
            Logger.log("Jaina a gagné la partie.");
        }
        
        
        
        Logger.close();
        scanner.close();
        
        // ecrireLogsDansFichier("logs.txt");
    }

    // private static void ajouterLog(String instruction) {
    //     logs.append(instruction).append("\n");
    // }
        // private static void ecrireLogsDansFichier(String nomFichier) {
        // try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier))) {
        //     writer.write(logs.toString());
        //     System.out.println("Logs écrits dans le fichier : " + nomFichier);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    // }
}
