package IMT_HearStone;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    public static List<Carte> creerDeck() {
        List<Carte> deck = new ArrayList<>();
        deck.add(new Carte("Éclair", 2, 3, 0, 0));
        deck.add(new Carte("Boule de Feu", 4, 6, 0, 0));
        
        return deck;
    }
}

