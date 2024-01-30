package IMT_HearStone;

import java.util.Scanner;

import HearStoneClasseChampion.*;


public class Main {
    static Scanner scanner = new Scanner(System.in); // Scanner global

    
    public static void main(String[] args) {
    	//System.out.println("Yahiani Hamza & Boubeker Ibrahim"); <-- fait le mettre pour identifier notre groupe
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
		        MaitreDeLaPartie.jouerTour(jaina);
		        System.out.println("\nTour de jaina fini");
		        
	            System.out.println("\n");

		        for (int i = 0; i < 10; i++) {
		        	System.out.println("-----------------------------");
		        }
		        MaitreDeLaPartie.jouerTour(KHADGAR);
		        System.out.println("Tour de medivh fini");
		        
		        System.out.println("\nJe reset le mana ( +1 biensur ^^) ");
		        jaina.recupererMana();
		        KHADGAR.recupererMana();
        }
        if (jaina.getPointsDeVie() <= 0) {
        	System.out.println("Medivh a gagné la partie.");
        }
        else {
        	System.out.println("Jaina a gagné la partie.");
        }
        
        
        
        scanner.close();
            
    }
}
