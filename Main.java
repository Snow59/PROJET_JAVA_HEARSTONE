public class Main {
    public static void main(String[] args) {
        // Création des Mages
        Mage jaina = Mage.JAINA;
        Mage medivh = Mage.MEDIVH;

        jaina.setDeck(Deck.creerDeck());
        medivh.setDeck(Deck.creerDeck());

        PlateauDeJeu plateau = new PlateauDeJeu(jaina, medivh);

        while (jaina.getPointsDeVie() > 0 && medivh.getPointsDeVie() > 0) {
            // Tour de Jaina
            jaina.jouerTour();
            jaina.special(medivh); 

            if (medivh.getPointsDeVie() <= 0) break;

            medivh.jouerTour();
            medivh.special(jaina); 

            if (jaina.getPointsDeVie() <= 0) break;
        }

        if (jaina.getPointsDeVie() > 0) {
            System.out.println("Jaina gagne !");
        } else {
            System.out.println("Medivh gagne !");
        }
    }
}
