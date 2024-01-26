package IMT_HearStone;

import java.util.function.Consumer;


public class Mage extends Champion {

    public static final Mage JAINA = new Mage("Jaina", 30, 1, cible -> {
        cible.subirDegats(5);
    });
  
    public static final Mage MEDIVH = new Mage("Medivh", 30, 2, cible -> {
        this.addArmure(5);
    });

    public static final Mage KHADGAR = new Mage("Khadgar", 30, 1, cible -> {
        // Capacité spéciale de Khadgar: infliger -2 PV au champion ennemi
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
        // Récupération du mana en début de tour
        this.recupererMana();
    
        Carte cartePiochee = this.deck.piocherCarte();
        if (cartePiochee != null) {
            main.add(cartePiochee);
        }
    
        // Jouer des cartes de la main
        for (Carte carte : new ArrayList<>(main)) {
            if (this.manaActuel >= carte.getCoutMana()) {
                jouerCarte(carte);
                main.remove(carte);
            }
        }
    
    }


    @Override
    public void attaquer(Attaquable cible) {
        super.attaquer(cible); 
    }

    @Override
    public void special() {
        this.capaciteSpeciale.executer(cible);
    }

  
}

