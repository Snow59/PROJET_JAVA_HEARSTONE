package IMT_HearStone;

import HearStoneClasseChampion.*;


public class Main {
    public static void main(String[] args) {
        // Création des Mages
    	
        Mage jaina = Mage.JAINA;
        Mage medivh = Mage.MEDIVH;
       
        
        Deck.associerDeck(jaina);
        Deck.associerDeck(medivh);
        
        jaina.getDeck();
        medivh.getDeck();
               
        
        PlateauDeJeu plateau = new PlateauDeJeu(jaina, medivh);
        
        Monitor MaitreDeLaPartie = new Monitor(jaina , medivh);
        	
        MaitreDeLaPartie.jouerTour(jaina);
        
            
    }
}
