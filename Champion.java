package IMT_HearStone;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite Champion.
 * En faisant de Champion une classe abstraite, une structure solide est Ã©tablie pour le jeu,
 * forÃ§ant les sous-classes (Mage, Paladin, etc.) Ã  implÃ©menter des comportements spÃ©cifiques
 * tout en rÃ©utilisant le code commun. Cela facilite l'ajout de nouveaux types de champions Ã  l'avenir.
 * Les variables sont protÃ©gÃ©es pour des raisons de sÃ©curitÃ© afin d'Ã©viter des modifications non autorisÃ©es.
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
        this.manaActuel = 3; // DÃ©marre avec 3 points de mana 
        this.manaMaximum = 3;
        //je ne fais pas this.mana = mana , pour evitÃ© que qql ne crÃ©Ã© un champion avec mana illimitÃ© lol

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
            System.out.println("La partie est terminÃ©e car " + this.nom + " est maintenant mort.");
            
        }
        System.out.println(this.nom + " a subis " + degats + " points de dÃ©gats, sa vie est  mtn de : " + pointsDeVie );
    }

    public String getNom() {
        return nom;
    }
    
    
    
    
    
    
    public void setDeck(List<Carte> deck) { 
    	this.deck = deck;
    }
    
    
    
    
    
    public List<Carte> getDeck() {
    	
    	List<Carte> liste = new ArrayList();
    	for (Carte carte : deck) {
    		
    		 liste.add(carte);
    		 
    		
    	}
    	
    	return liste;
    
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
