package IMT_HearStone;

import HearStoneClasseChampion.*;


public class Main {
    public static void main(String[] args) {
    	//System.out.println("Yahiani Hamza & Boubeker Ibrahim"); <-- fait le mettre pour identifier notre groupe
        // CrÃ©ation des Mages
        Mage jaina = Mage.JAINA;
        Mage medivh = Mage.MEDIVH;
       
        
        Deck.associerDeck(jaina);
        Deck.associerDeck(medivh);
        
        System.out.println("Deck de jaina "+jaina.getDeck());
        System.out.println("Deck de medivh"+ medivh.getDeck());

               
        
        PlateauDeJeu plateau = new PlateauDeJeu(jaina, medivh);
        
        Monitor MaitreDeLaPartie = new Monitor(jaina , medivh);
        	
        MaitreDeLaPartie.jouerTour(jaina);
        //MaitreDeLaPartie.jouerTour(medivh);

        
            
    }
}
