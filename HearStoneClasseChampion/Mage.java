package HearStoneClasseChampion;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import IMT_HearStone.*;

import java.util.Scanner;
/**
 * Classe permettant de creer les mages et leurs methodes
 */
public class Mage extends Champion {
    private Consumer<Champion> capaciteSpeciale;
    private List<Carte> main = new ArrayList<>();
    private Deck deck;
    
/**
 * creer un mage JAINA
 */
    public static final Mage JAINA = new Mage("Jaina", 30, 1, cible -> {
        cible.subirDegats(5);
    });
    /**
     * Creer un mage MEDIVH
     */
    public static final Mage MEDIVH;

    static {
        MEDIVH = new Mage("Medivh", 30, 1, null);
        MEDIVH.capaciteSpeciale = cible -> {
            MEDIVH.addArmure(5);
        };
    }
    /**
     * Creer un mage KHADGAR
     */
    public static final Mage KHADGAR = new Mage("Khadgar", 30, 1, cible -> {
        cible.subirDegats(2);
    });
    

    // Constructeur privÃ© pour empÃªcher la crÃ©ation d'instances en dehors de la classe
    public Mage(String nom, int pointsDeVie, int puissanceAttaque, Consumer<Champion> capaciteSpeciale) {
        super(nom, pointsDeVie, puissanceAttaque, 3); // '3' est un exemple pour le mana initial
        this.capaciteSpeciale = capaciteSpeciale;
        this.deck = new Deck(); // Vous pouvez ajuster cette partie en fonction de la logique de votre jeu
    }

    
    /**
     * Ici on defini tous les attaques spéciales de chaques personnages
     */
	@Override
	public void special(Champion cible) {
	    if (this == JAINA) {
	        cible.subirDegats(5);
	        Logger.log("Jaina utilise sa capacitÃ© spÃ©ciale sur " + cible.getNom() + " infligeant 5 dÃ©gÃ¢ts.");
	    } else if (this == MEDIVH) {
	        this.addArmure(5);
	        Logger.log("Medivh utilise sa capacitÃ© spÃ©ciale et gagne 5 points d'armure.");
	    } else if (this == KHADGAR) {
	        cible.subirDegats(2);
	        Logger.log("Khadgar utilise sa capacitÃ© spÃ©ciale sur " + cible.getNom() + " infligeant 2 dÃ©gÃ¢ts.");
	    }
	}

}
