package IMT_HearStone;

import java.util.function.Consumer;


public class Mage extends Champion {

    public static final Mage JAINA = new Mage("Jaina", 30, 1, cible -> {
        cible.subirDegats(5);
    });
  
    public static final Mage MEDIVH = new Mage("Medivh", 30, 2, cible -> {
    MEDIVH.addArmure(5); // MEDIVH s'ajoute de l'armure à lui-même
    });

    public static final Mage KHADGAR = new Mage("Khadgar", 30, 1, cible -> {
        cible.subirDegats(2);
    });

  

    private Deck deck;

    // Constructeur privé pour empêcher la création d'instances en dehors de la classe
    private Mage(String nom, int pointsDeVie, int puissanceAttaque, Consumer<Champion> capaciteSpeciale) {
        super(nom, pointsDeVie, puissanceAttaque);
        this.capaciteSpeciale = capaciteSpeciale;
    }

    @Override
    public void jouerTour() {
        this.recupererMana();
    
        Carte cartePiochee = this.deck.piocherCarte();
        if (cartePiochee != null) {
            main.add(cartePiochee);
        }
    
        for (Carte carte : new ArrayList<>(main)) {
            if (this.manaActuel >= carte.getCoutMana()) {
                jouerCarte(carte);
                main.remove(carte);
            }
        }
    
    }


    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return this.deck;
    }

    @Override
    public void attaquer(Attaquable cible) {
        super.attaquer(cible); 
    }

    public void special(Champion ennemi) {
        this.capaciteSpeciale.executer(ennemi);
    }

  
}

