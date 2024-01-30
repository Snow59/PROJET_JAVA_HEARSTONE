package IMT_HearStone;


import java.util.Random;
import java.util.List;
/**
 * Ici nous définissons ce qu'est une carte
 */
public class Carte {

	
    private static int compteurId = 0;

    private final int id;
    private final String nom;
    private final int coutMana;
    private int degatsAttaque;
    private int addArmure;
    private int restoreHealth;
    private final String type; // "Classique", "Protecteur", "Soigneur", "Mascotte"
    private int vie;

    public Carte(String nom, int vie, int coutMana, int degatsAttaque, int addArmure, int restoreHealth, String type) {
        this.id = compteurId++;
        this.nom = nom;
        this.coutMana = coutMana;
        this.degatsAttaque = degatsAttaque;
        this.addArmure = addArmure;
        this.restoreHealth = restoreHealth;
        this.type = type;
        this.vie = vie;
    }
    /**
     * Cette fonction attribut les capacités à chacune des cartes
     * 
     * @param invocateur
     * @param cible
     * @param plateau
     * @param cartesEnJeu
     * @param carteEnJeuJoueur
     * @param cartesEnJeuAdversaire
     */
    public void action(Champion invocateur , Champion cible, PlateauDeJeu plateau , List<Carte> cartesEnJeu , List<Carte> carteEnJeuJoueur, List<Carte> cartesEnJeuAdversaire) {
        Random random = new Random();
        System.out.println("\nCarte sur le plateau du joueur "+invocateur.getNom()+" :  "+carteEnJeuJoueur);
//        System.out.println("\nCarte sur le plateau du cible "+cible.getNom()+" :  "+cartesEnJeuAdversaire);

        switch (type) {
            case "Classique":
                // Les monstres classiques attaquent directement l'ennemi pas les cartes 
                cible.subirDegats(this.getDegatsAttaque());
                invocateur.utiliserMana(this.coutMana);
                break;
            case "Protecteur":
            	
                // Les protecteurs offrent une protection, Il font office de tank ( comme Cho'Gath ) ils vont tank les degats dans leur armures 
            	// Ils seront bien sur élevé en mana car très utile.
                plateau.ajouterProtecteur(this);
                break;
            case "Soigneur":
            		
                	invocateur.soigner(this.getRestoreHealth());
                	System.out.println("La vie de "+invocateur.getPointsDeVie());
               
                break;
            case "Mascotte":
            	
            	
                break;
        }
    
    } 
    
    
    
    public void carteMascotte(Carte carte, Champion champion) {
    	
    
        Random random = new Random();
		
    	System.out.println("Je suis une mascotte");
        int effet = random.nextInt(3); // 0 pour Attaque, 1 pour Armure, 2 pour Soins
        int cibleEffet = random.nextInt(2); // 0 pour Champion, 1 pour Carte PosÃ©e
/**		
 * 
*La mascotte a été complexe et long Ã  faire mais le principe c'est  quand on invoque cette carte 
	* qui ne coutera que 1 de mana , elle fait qql chose de totalement alÃ©atoire !
* elle choisit entre notre champion , l'une de nos cartes dÃ©ja posÃ©s
	* Ensuite elle choisit, soit de mettre de +1 d'armure , soit +1 de vie , soit +1 d'attaque 
*/

        
        Carte carteCiblee;
        if (cibleEffet == 0) { // Effet sur le Champion
        	
            appliquerEffetMascotteChampion(champion); // Je boost lattaque de +1
            
        } else if (cibleEffet == 1) { // Effet sur une Carte PosÃ©e
        	
            carteCiblee = carte;
            appliquerEffetMascotte(carteCiblee, effet);
        }
    }
    
    	
    
    
    /**
     * Cette methode fait attaquer 2 cartes entre elles
     * 
     * @param carteQuiAttaque
     * @param cartesEnJeuAdversaire
     */  
    public void actionClassique(Carte carteQuiAttaque, Carte cartesEnJeuAdversaire) {
        Random random = new Random();
        
    //    System.out.println("\nCarte sur le plateau du joueur "+invocateur.getNom()+" :  "+carteEnJeuJoueur);
    //    System.out.println("\nCarte sur le plateau adverse "+cartesEnJeuAdversaire.getNom()+" a subi  "+carteQuiAttaque.getDegatsAttaque());
        
        
        if (type == "Classique") {
        	
        	System.out.println("PUISSANCE DATTAQUE CARTE QUI ATTAQUE : "+carteQuiAttaque.getDegatsAttaque());
        	cartesEnJeuAdversaire.subirDegatsCarte(cartesEnJeuAdversaire, carteQuiAttaque.getDegatsAttaque());
        	System.out.println("\nCarte sur le plateau adverse "+cartesEnJeuAdversaire.getNom()+" a subi  "+carteQuiAttaque.getDegatsAttaque()+" de dégat d'attaque");
            
        	
        }
        else {
        	
        	System.out.println("Je ne peux pas utiliser cette carte sur une cible ennemi");
        }
        
    }
    
    
    /**
     * cette methode permet de réduire les pv d'une carte une fois qu'elle
     * s'est faite attaquer
     * @param cible
     * @param degats
     */
    public void subirDegatsCarte(Carte cible ,int degats) {
    	
    	cible.vie -=degats;
    	
    }
    
    
    
    /**
     * permet d'augmenter la puissance d'attaque de 1
     * @param champion
     */
   private void appliquerEffetMascotteChampion(Champion champion) {
	   
	   champion.setPuissanceAttaque(1);
   }
   
   
    /**
     * Permet de gerer les effets boost des differentes mascotte
     * @param carte
     * @param effet
     */
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
                // Supposons que toutes les cartes peuvent Ãªtre soignÃ©es
                carte.soigner(1);
                break;
        }
    }
    /**
     * Permet de booster l'attaque de la carte
     */
    private void boostAttaque(int i) {
    	
    	this.degatsAttaque += i;
    	
    }
    
    
    public void LifeProtecteur(Carte carte) {
    	
    	carte.getAddArmure() ;
    	
    	
    }
    
    

    
    public void setAddArmure(int degat) {
    	
		this.addArmure -= degat;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
    /**
     * Permet de booster l'armure de la carte
     */
	private void boostArmure(int i) {
    	
    	this.addArmure += i;
    }
    /**
     * Permet d'augmenter la vie de la carte de 1
     */
    private void soigner(int i) {
    	
    	this.restoreHealth += i;
    }
    /**
     * Permet de faire en sorte que les cartes qui ne peuvent pas attaquer,
     * elles n'ont pas la possibilité de recevoir des points d'attaque
     * @return
     */
    public boolean peutRecevoirAttaque() {
	// je verifie car si j'ai posÃ© une carte de protection qui elle n'a pas pour but d'attaquer je ne vais pas lui donner 1 d'attaque
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
               " id=" + id +
               " vie="+vie+
               ", nom='" + nom + '\'' +
               ", coutMana=" + coutMana +
               ", degatsAttaque=" + degatsAttaque +
               ", armureAjoutee=" + addArmure +
               ", santeRestauree=" + restoreHealth +
               ", type='" + type + '\'' +
               '}';
    }
}
