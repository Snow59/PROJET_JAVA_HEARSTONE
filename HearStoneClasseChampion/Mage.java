package HearStoneClasseChampion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import IMT_HearStone.*;

import java.util.Scanner;

public class Mage extends Champion {
    private Consumer<Champion> capaciteSpeciale;
    private List<Carte> main = new ArrayList<>();
    private Deck deck;
    

    public static final Mage JAINA = new Mage("Jaina", 30, 1, cible -> {
        cible.subirDegats(5);
    });
    
    public static final Mage MEDIVH;

    static {
        MEDIVH = new Mage("Medivh", 30, 2, null);
        MEDIVH.capaciteSpeciale = cible -> {
            MEDIVH.addArmure(5);
        };
    }

    public static final Mage KHADGAR = new Mage("Khadgar", 30, 1, cible -> {
        cible.subirDegats(2);
    });

    // Constructeur privé pour empêcher la création d'instances en dehors de la classe
    private Mage(String nom, int pointsDeVie, int puissanceAttaque, Consumer<Champion> capaciteSpeciale) {
        super(nom, pointsDeVie, puissanceAttaque, 3); // '3' est un exemple pour le mana initial
        this.capaciteSpeciale = capaciteSpeciale;
        this.deck = new Deck(); // Vous pouvez ajuster cette partie en fonction de la logique de votre jeu
    }

    
    @Override
    public void attaquer(Champion cible) {
        if (cible != null) {
            cible.subirDegats(this.getPuissanceAttaque());
            System.out.println(this.getNom() + " attaque " + cible.getNom() + " infligeant " + this.getPuissanceAttaque() + " dégâts.");
        }
    }

	@Override
	public void special(Champion cible) {
	    if (this == JAINA) {
	        cible.subirDegats(5);
	        System.out.println("Jaina utilise sa capacité spéciale sur " + cible.getNom() + " infligeant 5 dégâts.");
	    } else if (this == MEDIVH) {
	        this.addArmure(5);
	        System.out.println("Medivh utilise sa capacité spéciale et gagne 5 points d'armure.");
	    } else if (this == KHADGAR) {
	        cible.subirDegats(2);
	        System.out.println("Khadgar utilise sa capacité spéciale sur " + cible.getNom() + " infligeant 2 dégâts.");
	    }
	}

}
