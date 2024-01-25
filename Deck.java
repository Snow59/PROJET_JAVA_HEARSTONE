package IMT_HearStone;

import java.util.ArrayList;
import java.util.List;

// Donc dans cette classe Deck j'ai voulu sur les centaines de cartes que possède le jeux , en y ajouter 20.
// Elles seront distribuées aléatoirement aux champions en début de game.
// Biensur ce sont des cartes qui existent vraiment

//Pour rappel le constructeur Carte se construit comme ça : Carte(Nom, CoûtMana, Dégatattaque , Armure, VieRendu, TypeDeCarte)

public class Deck {
    public static List<Carte> creerDeck() {
        List<Carte> deck = new ArrayList<>();

        // Ajout de 30 cartes avec une variété de types et de capacités
        deck.add(new Carte("Explosion de Lave", 2, 3, 0, 0, "Classique"));
        deck.add(new Carte("Gardien Protecteur", 4, 0, 6, 0, "Protecteur"));
        deck.add(new Carte("Soigneur Mystique", 3, 0, 0, 4, "Soigneur"));
        deck.add(new Carte("Mascotte Enjouée", 1, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Guerrier Agile", 3, 4, 0, 0, "Classique"));
        deck.add(new Carte("Mage du Feu", 5, 5, 0, 0, "Classique"));
        deck.add(new Carte("Bouclier de Fer", 2, 0, 5, 0, "Protecteur"));
        deck.add(new Carte("Prêtre de la Vie", 4, 0, 0, 5, "Soigneur"));
        deck.add(new Carte("Mascotte Féroce", 2, 1, 1, 1, "Mascotte"));
        deck.add(new Carte("Archer Élite", 4, 5, 0, 0, "Classique"));
        deck.add(new Carte("Chevalier Protecteur", 6, 2, 7, 0, "Protecteur"));
        deck.add(new Carte("Chaman Guérisseur", 5, 0, 0, 6, "Soigneur"));
        deck.add(new Carte("Dragon Enchanteur", 8, 8, 0, 0, "Classique"));
        deck.add(new Carte("Gardien de l'Ordre", 7, 0, 8, 0, "Protecteur"));
        deck.add(new Carte("Mascotte Magique", 3, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Nécromancien", 6, 6, 0, 0, "Classique"));
        deck.add(new Carte("Paladin de la Lumière", 7, 3, 4, 0, "Protecteur"));
        deck.add(new Carte("Mascotte de la Chance", 2, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Soldat Endurci", 5, 4, 2, 0, "Classique"));
        deck.add(new Carte("Élémentaire de Glace", 6, 0, 7, 0, "Protecteur"));
        deck.add(new Carte("Druide de la Forêt", 4, 0, 0, 3, "Soigneur"));
        deck.add(new Carte("Mascotte Mystérieuse", 1, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Sorcier Noir", 8, 7, 0, 0, "Classique"));
        deck.add(new Carte("Protecteur Ancien", 9, 0, 9, 0, "Protecteur"));
        deck.add(new Carte("Soigneur Ancien", 7, 0, 0, 7, "Soigneur"));
        deck.add(new Carte("Mascotte Héroïque", 4, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Guerrier Berserker", 3, 5, 0, 0, "Classique"));
        deck.add(new Carte("Sentinelle Inébranlable", 8, 0, 8, 0, "Protecteur"));
        deck.add(new Carte("Mage Guérisseur", 6, 0, 0, 6, "Soigneur"));
        deck.add(new Carte("Mascotte du Destin", 2, 0, 0, 0, "Mascotte"));
        deck.add(new Carte("Assassin Furtif", 5, 5, 0, 0, "Classique"));

        return deck;
    }
}



