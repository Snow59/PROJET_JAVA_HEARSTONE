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
    }



    public void jouerCarte(Champion champion, Carte carte) {
    	
        //if (champion.utiliserMana(carte.getCoutMana())) {
        	if (champion == joueur) {
            	
            	if (carte.getType() == "Mascotte"){
            		
            		System.out.println("Une carte de type boost Mascotte a été posée");
            	}
            	else {
            		
            			
            			joueurCarteEnJeu.add(carte);

                    	List<Carte> DeckMoinsCarte = joueur.getDeck();
                    	DeckMoinsCarte.remove(carte);
                    	
                    	joueur.setDeck(DeckMoinsCarte);
                    	joueur.afficherDeck();
         
            			}
      			carte.action(joueur , adversaire, this , carteSurLePlateau, joueurCarteEnJeu , adversaireCarteEnJeu);

        	}
            	//joueur.getDeck().remove(index)
                //carte.action(joueur , adversaire, this , carteSurLePlateau, joueurCarteEnJeu , adversaireCarteEnJeu);
                
        	
        	else if(champion == adversaire){
        		//System.out.println(adversaire.getManaActuel());
            	//System.out.println(adversaire.getNom());
        		if (carte.getType() == "Mascotte"){
            		
            		System.out.println("Une carte de type boost Mascotte a été posée");
            		adversaireCarteEnJeu.add(carte);

            	}
            	else {
            		
            		adversaireCarteEnJeu.add(carte);
            		List<Carte> DeckMoinsCarte = adversaire.getDeck();
                	DeckMoinsCarte.remove(carte);
                	
                	adversaire.setDeck(DeckMoinsCarte);
                	adversaire.afficherDeck();

            	}
                carte.action(adversaire , joueur, this , carteSurLePlateau, adversaireCarteEnJeu , joueurCarteEnJeu);
		
        	}
			
        	
        	//carteSurLePlateau.add(carte);
        	
        }
//        else {
//        	System.out.println("Pas assez de mana");
//        }
    //}

    
    
    
    public boolean isCartePlateauPlayer(Champion player){
    	
    	
    	
    	if(player == joueur) {
    		
    		if (joueurCarteEnJeu.isEmpty()) {
    			return true;
    		}
    		else {
    			return false;
    		}
    		
    	}
    	else {
    		
    		if (adversaireCarteEnJeu.isEmpty()) {
    			return true;
    		}
    		else {
    			return false;
    		}
    		
    	}
    }
    
    
    
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
