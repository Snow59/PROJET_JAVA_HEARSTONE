package IMT_HearStone;

import java.util.ArrayList;
import java.util.List;

// Donc dans cette classe Deck j'ai voulu sur les centaines de cartes que possède le jeux , en y ajouter 20.
// Elles seront distribuées aléatoirement aux champions en début de game.
// Biensur ce sont des cartes qui existent vraiment

//Pour rappel le constructeur Carte se construit comment ça : Carte(Nom, CoûtMana, Dégatattaque , Armure)
//

public class Deck {
    public static List<Carte> creerDeck() {
        List<Carte> deck = new ArrayList<>();
    
        deck.add(new Carte("Explosion de lave", 2, 2, 0, 0));
        deck.add(new Carte("Métamorphose", 4, 0, 0, 0));
        deck.add(new Carte("Dr. Boum", 7, 7, 0, 0));
        deck.add(new Carte("Éclat solaire", 0, 0, 0, 8));
        deck.add(new Carte("Assassinat", 5, 0, 0, 0));
        deck.add(new Carte("Champion frissegueule", 4, 2, 0, 0));
        deck.add(new Carte("Tir des Arcanes", 1, 2, 0, 0));
        deck.add(new Carte("Bénédiction des rois", 4, 0, 4, 4));
        deck.add(new Carte("Sprint", 7, 0, 0, 0));
        deck.add(new Carte("Élémentaire d'eau", 4, 3, 0, 0));
        deck.add(new Carte("Gardien des rois", 7, 5, 0, 6));
        deck.add(new Carte("Grommash Hurlenfer", 8, 4, 0, 0));
        deck.add(new Carte("Choc sacré", 1, 1, 0, 0));
        deck.add(new Carte("Jaina liche de givre", 9, 0, 0, 0));
        deck.add(new Carte("Alexstrasza", 9, 8, 0, 0));
        deck.add(new Carte("Flamme infernale", 4, 3, 0, 0));
        deck.add(new Carte("Krul le déchaîné", 9, 7, 0, 0));
        deck.add(new Carte("Gangregarde", 2, 2, 0, 0));
        deck.add(new Carte("Potion de polymorphie", 3, 0, 0, 0));
        deck.add(new Carte("Kazakus", 4, 3, 0, 0));

        return deck;
    }
}


