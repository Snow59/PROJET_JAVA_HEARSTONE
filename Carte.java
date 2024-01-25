package IMT_HearStone;

import java.util.Random;
import java.util.List;

public class Carte {

	
    private static int compteurId = 0;

    private final int id;
    private final String nom;
    private final int coutMana;
    private final int degatsAttaque;
    private final int addArmure;
    private final int restoreHealth;
    private final String type; // "Classique", "Protecteur", "Soigneur", "Mascotte"

    public Carte(String nom, int coutMana, int degatsAttaque, int addArmure, int restoreHealth, String type) {
        this.id = compteurId++;
        this.nom = nom;
        this.coutMana = coutMana;
        this.degatsAttaque = degatsAttaque;
        this.addArmure = addArmure;
        this.restoreHealth = restoreHealth;
        this.type = type;
    }

    public void action(Champion cible, PlateauDeJeu plateau, List<Carte> cartesEnJeu, Carte prochaineCarte) {
        Random random = new Random();

        switch (type) {
            case "Classique":
                // Les monstres classiques attaquent directement l'ennemi pas les cartes 
                cible.subirDegats(degatsAttaque);
                break;
            case "Protecteur":
                // Les protecteurs offrent une protection font office de tank ( comme Cho'Gath ) ils vont tank les degats dans leur armures 
		// Ils seront biensur élevé en mana car très utile.
                plateau.ajouterProtecteur(this);
                break;
            case "Soigneur":
                // Les soigneurs peuvent soigner un allié ou un ennemi.
                if (!cartesEnJeu.isEmpty()) {
                    Carte carteCiblee = cartesEnJeu.get(random.nextInt(cartesEnJeu.size()));
                    carteCiblee.soigner(restoreHealth);
                } else {
                    cible.soigner(restoreHealth);
                }
		
                break;
            case "Mascotte":
                int effet = random.nextInt(3); // 0 pour Attaque, 1 pour Armure, 2 pour Soins
                int cibleEffet = random.nextInt(2); // 0 pour Champion, 1 pour Carte Posée
		/**
		*La mascotte a été complexe et long à faire mais le principe c'est  quand on invoque cette carte 
  		* qui ne coutera que 1 de mana , elle fait qql chose de totalement aléatoire !
    		* elle choisit entre notre champion , l'une de nos carte déja posés
      		* Ensuite elle choisit soit de mettre de +1 d'armure , soit +1 de vie , soit +1 d'attaque 
		*/

		
                Carte carteCiblee;
                if (cibleEffet == 0) { // Effet sur le Champion
                    appliquerEffetMascotte(champion, effet);
                } else if (cibleEffet == 1 && !cartesEnJeu.isEmpty()) { // Effet sur une Carte Posée
                    carteCiblee = cartesEnJeu.get(random.nextInt(cartesEnJeu.size()));
                    appliquerEffetMascotte(carteCiblee, effet);
                }
                break;
        }
    }

   private void appliquerEffetMascotte(Carte carte, int effet) {
        switch (effet) {
            case 0: // Boost Attaque
                if (carte.peutRecevoirAttaque()) {
                    carte.boostAttaque(1);
                }
                break;
            case 1: // Boost Armure
                // Supposons que toutes les cartes peuvent recevoir de l'armure
                carte.boostArmure(1);
                break;
            case 2: // Boost Soins
                // Supposons que toutes les cartes peuvent être soignées
                carte.soigner(1);
                break;
        }
    }

	
    public boolean peutRecevoirAttaque() {
	// je verifie car si j'ai posé une carte de protection qui elle n'a pas pour but d'attaquer je ne vais pas lui donner 1 d'attaque
        return this.degatsAttaque > 0 || this.type.equals("Classique");
    }
	

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCoutMana() {
        return coutMana;
    }

    public int getAddArmure() {
        return addArmure;
    }

    public int getRestoreHealth() {
        return restoreHealth;
    }

    public int getDegatsAttaque() {
        return degatsAttaque;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Carte{" +
               "id=" + id +
               ", nom='" + nom + '\'' +
               ", coutMana=" + coutMana +
               ", degatsAttaque=" + degatsAttaque +
               ", armureAjoutee=" + addArmure +
               ", santeRestauree=" + restoreHealth +
               ", type='" + type + '\'' +
               '}';
    }
}
