package IMT_HearStone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlateauDeJeu extends Deck{
    private Champion joueur;
    private Champion adversaire;
    private List<Carte> mainJoueur;
    private List<Carte> mainAdversaire;
    private List<Carte> joueurCarteEnJeu;
    private List<Carte> adversaireCarteEnJeu;
    
    private List<Carte> carteSurLePlateau;

    public PlateauDeJeu(Champion joueur, Champion adversaire) {
        this.joueur = joueur;
        this.adversaire = adversaire;
        this.mainJoueur = new ArrayList<>();
        this.mainAdversaire = new ArrayList<>();
        this.joueurCarteEnJeu = new ArrayList<>(); // Initialisation
        this.adversaireCarteEnJeu = new ArrayList<>(); // Initialisation
        this.carteSurLePlateau = new ArrayList<>();
        //initialiserPartie();
    }

//    private void initialiserPartie() {
//        distribuerCartesInitiales(joueur, mainJoueur);
//        distribuerCartesInitiales(adversaire, mainAdversaire);
//    }
//
//    private void distribuerCartesInitiales(Champion champion, List<Carte> main) {
//        List<Carte> deck = mainJoueur;
//        Collections.shuffle(deck);
//        for (int i = 0; i < 5 && i < deck.size(); i++) {
//           main.add(deck.get(i));
//       }
//    }

    public void jouerCarte(Champion champion, Carte carte) {
        //if (champion.utiliserMana(carte.getCoutMana())) {
        	if (champion == joueur) {a
            	

            	if (carte.getType() == "Mascotte"){
            		
            		System.out.println("Une carte de type boost Mascotte a été posée");
            	}
            	else {
            		
                	joueurCarteEnJeu.add(carte);
                	//System.out.println(joueur.getDeck());
 
                	List<Carte> DeckMoinsCarte = joueur.getDeck();
                	DeckMoinsCarte.remove(carte);
                	
                	System.out.println(DeckMoinsCarte);
                	
                	joueur.setDeck(DeckMoinsCarte);

            	}
            	//joueur.getDeck().remove(index)
                carte.action(joueur , adversaire, this , carteSurLePlateau, joueurCarteEnJeu , adversaireCarteEnJeu);

        	}
        	else if(champion == adversaire){
        		//System.out.println(adversaire.getManaActuel());
            	//System.out.println(adversaire.getNom());
        		if (carte.getType() == "Mascotte"){
            		
            		System.out.println("Une carte de type boost Mascotte a été posée");
            	}
            	else {
            		
            		adversaireCarteEnJeu.add(carte);
                	System.out.println(joueur.getDeck());


            	}
                carte.action(adversaire , joueur, this , carteSurLePlateau, adversaireCarteEnJeu , joueurCarteEnJeu);
		
        	}
        	
        	carteSurLePlateau.add(carte);
        	
        }
//        else {
//        	System.out.println("Pas assez de mana");
//        }
    //}

    // Getters et Setters
    public List<Carte> getMainJoueur() {
        return mainJoueur;
    }

    public List<Carte> getMainAdversaire() {
        return mainAdversaire;
    }
    
    
    
    public void ajouterProtecteur(Carte carte)
    {
    	
    }
    // Autres mÃ©thodes utiles
}
