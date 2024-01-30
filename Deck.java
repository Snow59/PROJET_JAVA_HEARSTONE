package IMT_HearStone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sound.sampled.LineListener;

import java.util.Collections;

// Donc dans cette classe Deck j'ai voulu sur les centaines de cartes que possÃ¨de le jeux , en y ajouter 20.
// Elles seront distribuÃ©es alÃ©atoirement aux champions en dÃ©but de game.
// Biensur ce sont des cartes qui existent vraiment

//Pour rappel le constructeur Carte se construit comme Ã§a : Carte(Nom, CoÃ»tMana, DÃ©gatattaque , Armure, VieRendu, TypeDeCarte)

public class Deck{
	
	

	private List<Carte> cartes;
	
    public static List<Carte> creerDeck() {
        List<Carte> deck = new ArrayList<>();
        
                
        // Ajout de 30 cartes avec une variÃ©tÃ© de types et de capacitÃ©s
        deck.add(new Carte("Explosion de Lave",5, 2, 3, 0, 0, "Classique"));
        deck.add(new Carte("Gardien Protecteur",5, 4, 0, 6, 0, "Protecteur"));
        deck.add(new Carte("Soigneur Mystique",5, 3, 0, 0, 4, "Soigneur"));
        deck.add(new Carte("Mascotte EnjouÃ©e",5, 1, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Guerrier Agile",5, 3, 4, 0, 0, "Classique"));
        deck.add(new Carte("Mage du Feu",5, 5, 5, 0, 0, "Classique"));
        deck.add(new Carte("Bouclier de Fer",5, 2, 0, 5, 0, "Protecteur"));
        deck.add(new Carte("PrÃªtre de la Vie",5, 4, 0, 0, 5, "Soigneur"));
        deck.add(new Carte("Mascotte FÃ©roce",5, 1, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Archer Ã‰lite",5, 4, 5, 0, 0, "Classique"));
        deck.add(new Carte("Chevalier Protecteur",5, 6, 0, 7, 0, "Protecteur"));
        deck.add(new Carte("Chaman GuÃ©risseur",5, 5, 0, 0, 6, "Soigneur"));
        deck.add(new Carte("Dragon Enchanteur",5, 8, 8, 0, 0, "Classique"));
        deck.add(new Carte("Gardien de l'Ordre",5, 7, 0, 8, 0, "Protecteur"));
        deck.add(new Carte("Mascotte Magique",5, 3, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("NÃ©cromancien",5, 6, 6, 0, 0, "Classique"));
        deck.add(new Carte("Paladin de la LumiÃ¨re",5, 7, 0, 4, 0, "Protecteur"));
        deck.add(new Carte("Mascotte de la Chance",5, 2, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Soldat Endurci",5, 5, 4, 0, 0, "Classique"));
        deck.add(new Carte("Ã‰lÃ©mentaire de Glace",5, 6, 0, 7, 0, "Protecteur"));
        deck.add(new Carte("Druide de la ForÃªt",5, 4, 0, 0, 3, "Soigneur"));
        deck.add(new Carte("Mascotte MystÃ©rieuse",5, 1, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Sorcier Noir",5, 8, 7, 0, 0, "Classique"));
        deck.add(new Carte("Protecteur Ancien",5, 9, 0, 9, 0, "Protecteur"));
        deck.add(new Carte("Soigneur Ancien",5, 7, 0, 0, 7, "Soigneur"));
        deck.add(new Carte("Mascotte HÃ©roÃ¯que",5, 4, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Guerrier Berserker",5, 3, 5, 0, 0, "Classique"));
        deck.add(new Carte("Sentinelle InÃ©branlable",5, 8, 0, 8, 0, "Protecteur"));
        deck.add(new Carte("Mage GuÃ©risseur",5, 6, 0, 0, 6, "Soigneur"));
        deck.add(new Carte("Mascotte du Destin",5, 2, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Assassin Furtif",5, 5, 5, 0, 0, "Classique"));

        return deck;
    }
    
    public static void associerDeck(Champion champion) {
        List<Carte> deckInitial = creerDeck(); // CrÃ©e un nouveau deck avec toutes les cartes
        melangerDeck(deckInitial); // MÃ©lange le deck
        List<Carte> deckPourChampion = new ArrayList<>(deckInitial.subList(0, 5)); // Prend les 5 premiÃ¨res cartes
        champion.setDeck(deckPourChampion); // Associe ce deck au champion
    }

     

    public static void melangerDeck(List<Carte> carte) {
        Collections.shuffle(carte); 
    }

    public static Carte getCarte(Champion champion, int id) {
    	for(Carte carte : champion.getDeck() ) {
    		
    		if (carte.getId() == id){
    			return carte;
    		}
    	}
    		
		return null;
    }
    
    
    
    
    public static boolean checkmana(Champion champion, Carte carte) {
    	
    	if (champion.getManaActuel() >= carte.getCoutMana())
    	{
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

	public static Carte piocherCarte() {
		
		
		 	Random random = new Random();
	        int index = random.nextInt(creerDeck().size()); // Sélectionne un indice aléatoire
	        return creerDeck().get(index);
			
		}
}
    
   
    

