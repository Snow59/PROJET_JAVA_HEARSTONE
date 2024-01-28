package IMT_HearStone;

import java.util.List;

/**
 * Classe abstraite Champion.
 * En faisant de Champion une classe abstraite, une structure solide est établie pour le jeu,
 * forçant les sous-classes (Mage, Paladin, etc.) à implémenter des comportements spécifiques
 * tout en réutilisant le code commun. Cela facilite l'ajout de nouveaux types de champions à l'avenir.
 * Les variables sont protégées pour des raisons de sécurité afin d'éviter des modifications non autorisées.
 */
public abstract class Champion implements ActionDeJeu {
    protected String nom;
    protected int pointsDeVie;
    protected int puissanceAttaque;
    protected int manaActuel;
    protected int manaMaximum;
    protected int armure;
    
    private List<Carte> deck;

    
    public Champion(String nom, int pointsDeVie, int puissanceAttaque, int mana) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.puissanceAttaque = puissanceAttaque;
        this.manaActuel = 3; // Démarre avec 3 points de mana 
        this.manaMaximum = 3;
        //je ne fais pas this.mana = mana , pour evité que qql ne créé un champion avec mana illimité lol

    }


    @Override
    public void attaquer(Champion cible) {
        cible.subirDegats(puissanceAttaque);
    }

    
    
    public void soigner(int i) {
    	
    	this.pointsDeVie += i;
    }
    
    
    public void subirDegats(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
            System.out.println("La partie est terminée car " + this.nom + " est maintenant mort.");
            
        }
        System.out.println(this.nom + " a subis " + degats + " points de dégats, sa vie est  mtn de : " + pointsDeVie );
    }

    public String getNom() {
        return nom;
    }
    
    
    public void setDeck(List<Carte> deck) {
        this.deck = deck;
    }
    
    public void getDeck() {
    	
    	System.out.println("Deck de "+this.getNom());
    	for (Carte carte : deck) {
            System.out.println(carte);
        }
    	System.out.println("\n");
        
    }
    
    
    
    
    public void recupererMana() {
        this.manaMaximum += 1; 
        this.manaActuel = this.manaMaximum; 
    }

    public boolean utiliserMana(int quantite) {
        if (this.manaActuel >= quantite) {
            this.manaActuel -= quantite;
            return true;
        } 
        return false;
    }
    public int getManaActuel() {
        return manaActuel;
    }

    public void addArmure(int armureAjoutee) {
        this.armure += armureAjoutee;
    }

    public int getManaMaximum() {
        return manaMaximum;
    }
    public int getPointsDeVie() {
        return pointsDeVie;
    }
    
    public void setPointsDeVie(int pointsDeVie) {
        if (pointsDeVie >= 0) {
            this.pointsDeVie = pointsDeVie;
        }
    }

    public void setPuissanceAttaque(int i) {
    	this.puissanceAttaque  += i ;
    }
    
    public int getPuissanceAttaque() {
        return puissanceAttaque;
    }
}
