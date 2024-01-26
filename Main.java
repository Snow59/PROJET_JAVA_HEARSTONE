public class Main {
    public static void main(String[] args) {
        // Création des champions
        Mage jaina = Mage.JAINA;
        Mage medivh = Mage.MEDIVH;

        // Attribuer des decks aléatoires
        jaina.setDeck(Deck.creerDeck());
        medivh.setDeck(Deck.creerDeck());

        // Mélanger les decks
        jaina.getDeck().melangerDeck();
        medivh.getDeck().melangerDeck();

        // Création du plateau de jeu
        PlateauDeJeu plateau = new PlateauDeJeu(jaina, medivh);

        // Simulation de la partie (simplifiée)
        while (jaina.getPointsDeVie() > 0 && medivh.getPointsDeVie() > 0) {
            // Tour de Jaina
            jouerTour(jaina, plateau);

            // Vérifier si Medivh est KO
            if (medivh.getPointsDeVie() <= 0) break;

            // Tour de Medivh
            jouerTour(medivh, plateau);

            // Vérifier si Jaina est KO
            if (jaina.getPointsDeVie() <= 0) break;
        }

        // Affichage du résultat
        if (jaina.getPointsDeVie() > 0) {
            System.out.println("Jaina gagne !");
        } else {
            System.out.println("Medivh gagne !");
        }
    }

    private static void jouerTour(Mage mage, PlateauDeJeu plateau) {
        mage.recupererMana();
        Carte cartePiochee = mage.getDeck().piocherCarte();
        if (cartePiochee != null) {
            plateau.jouerCarte(mage, cartePiochee);
        }
    }
}
