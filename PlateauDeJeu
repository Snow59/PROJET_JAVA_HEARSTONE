package IMT_HearStone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlateauDeJeu {
    private Champion joueur;
    private Champion adversaire;
    private List<Carte> mainJoueur;
    private List<Carte> mainAdversaire;

    public PlateauDeJeu(Champion joueur, Champion adversaire) {
        this.joueur = joueur;
        this.adversaire = adversaire;
        this.mainJoueur = new ArrayList<>();
        this.mainAdversaire = new ArrayList<>();
        initialiserPartie();
    }

    private void initialiserPartie() {
        distribuerCartesInitiales(joueur, mainJoueur);
        distribuerCartesInitiales(adversaire, mainAdversaire);
    }

    private void distribuerCartesInitiales(Champion champion, List<Carte> main) {
        List<Carte> deck = champion.getDeck().getCartes();
        Collections.shuffle(deck);
        for (int i = 0; i < 5 && i < deck.size(); i++) {
            main.add(deck.get(i));
        }
    }

    public void jouerCarte(Champion champion, Carte carte) {
        if (champion.utiliserMana(carte.getCoutMana())) {
            carte.action(adversaire, this, mainAdversaire, null); // Exemple d'utilisation
        }
    }

    // Getters et Setters
    public List<Carte> getMainJoueur() {
        return mainJoueur;
    }

    public List<Carte> getMainAdversaire() {
        return mainAdversaire;
    }

    // Autres méthodes utiles
}
