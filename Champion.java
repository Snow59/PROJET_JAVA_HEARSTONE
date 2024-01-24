package IMT_HearStone;

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

    public Champion(String nom, int pointsDeVie, int puissanceAttaque) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.puissanceAttaque = puissanceAttaque;
    }

    @Override
    public abstract void jouerTour();

    @Override
    public void attaquer(Attaquable cible) {
        cible.subirDegats(puissanceAttaque);
    }

    @Override
    public abstract void special();
    
    public void subirDegats(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie < 0) {
            this.pointsDeVie = 0;
            System.out.println("La partie est terminée car " + this.nom + " est maintenant mort.");
        }
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        if (pointsDeVie >= 0) {
            this.pointsDeVie = pointsDeVie;
        }
    }

    public int getPuissanceAttaque() {
        return puissanceAttaque;
    }
}
