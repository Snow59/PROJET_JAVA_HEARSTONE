import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import HearStoneClasseChampion.Mage;
import IMT_HearStone.Carte;
import IMT_HearStone.Deck;
import IMT_HearStone.Logger;
import IMT_HearStone.Monitor;
import IMT_HearStone.PlateauDeJeu;

public class TestUnitaire {
/*
     * assertEquals(,)
     * assertNotEquals(,)
     * assertNotNull()
     * assertNull()
     * assertTrue()
     */

	
    /**
     * Simuler l’attaque d’un Champion sur un autre avec des points
     * d’attaque égaux aux points de vie du Champion adverse
     * Vérifier que ce dernier ait bien 0 points de vie.
     */
    @Test
    public void testAttaqueMortChampion() {
        Mage tueur = new Mage("Assassin", 1, 30, null);
        Mage cible = new Mage("Petit chat Fragile", 30, 1, null);
        tueur.attaquer(cible);
        
        assertEquals(0, cible.getPointsDeVie());
    }

    /**
     * Simuler l’attaque d’un monstre sur un autre avec des points
     * d’attaque égaux aux points de vie du monstre attaqué.
     * Vérifier que ce dernier ait bien 0 points de vie et disparait du plateau.
     */
    @Test
    public void testAttaqueMortCarte(){
        Mage tueur = new Mage("Assassin", 1, 30, null);
        Mage cible = new Mage("Petit chat Fragile", 30, 1, null);
        List<Carte> deck = new ArrayList<>();
        List<Carte> deck2 = new ArrayList<>();
        List<Carte> plateau = new ArrayList<Carte>();

        deck.add(new Carte("Poison",1,1,10,0,0,"Classique"));
        
        tueur.setDeck(deck);
        deck2.add(new Carte("Victime",10,1,1,0,0,"Classique"));
        cible.setDeck(deck2);
        
        Monitor MaitreDeLaPartie = new Monitor(null, tueur, cible);
        
        
        Carte tueur1 = Deck.getCarte(tueur, 0);
        Carte cible1 = Deck.getCarte(cible, 1);
        plateau.add(tueur1);
        plateau.add(cible1);
        
        Logger.log(""+plateau);
        //tueur.afficherDeck();
        //cible.afficherDeck();
        //System.out.println(tueur1);
		tueur1.actionClassique(tueur1, cible1);
        //Deck.getCarte(tueur1, 1);
        //MaitreDeLaPartie.jouerCarte(cible, null);
        //jouerCarte(tueur, tueur.getDeck());
       
        

    }


}
