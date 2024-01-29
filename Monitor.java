package IMT_HearStone;

import HearStoneClasseChampion.*;

import java.util.List;
import java.util.Scanner;

public class Monitor extends PlateauDeJeu{
	
	private Champion joueur;
	private Champion adversaire;
	private boolean joueurSpecialUsed;
	private boolean adversaireSpecialUsed;
    private static Scanner scanner; // Scanner global

	
	
	public Monitor(Scanner scanner, Champion joueur, Champion adversaire) {
		super(joueur, adversaire);
		this.joueur = joueur;
		this.adversaire = adversaire;
		this.scanner = scanner;
		
	}
	
	public void jouerTour(Champion player) {
		
		if (player == adversaire) {
			
			player = adversaire;
		}
		else {
			player = joueur;

		}
		
		player.afficherDeck();
		
		System.out.println("\n"+player.getNom()+  " je t'ai remis ton Deck au dessus c'est ton tour , pour rappel tu as : "
				+ "\n Vie : "+player.getPointsDeVie()+
				 "\n Mana Actuel : "+player.getManaActuel()+
				 "\n Puissance d'attaque : "+player.getPuissanceAttaque());
		
	    
	   
		
		
	    System.out.println("\nVous voulez faire quoi ? \n"
	            + "1 : jouer une carte ?\n"
	            + "2 : Jouer votre spÃ©cial\n"
	            + "3 : attaquer une cible ennemie avec une carte\n"
	            + "4 : attaquer avec votre puissance d'attaque\n"
	            + "5 : piocher une carte");

	    Scanner scanner = new Scanner(System.in);

	    int choix = scanner.nextInt();
	    
	    switch (choix) {
	    
	    	
	        case 1:
	        	
	        	System.out.println(" Faites un choix  : ");
	        	System.out.println("1) Pour utiliser une carte que vous avez poser sur le plateau"
	        			+ "\n2) Poser une nouvelle carte ");
	        	

	        	int choix1 = scanner.nextInt();
	        	
	        	
	        	switch(choix1) {
	        		
				        		case 1 :
				        			if (isCartePlateauPlayer(player)) {
				        	    		
				        	    		System.out.println("Tu n'as aucune carte sur le plateau désolé , ");
				        	    	}
				        			else {
				        				
				        			}
				        			
				        			
				        		case 2 :
				        			
				        			
				        			System.out.println("Entrez l'id de la carte que vous voulez mettre : ");
				        			
				        		    	
				        			int result = scanner.nextInt();
				        			
				        			
				        			jouerCarte(player, Deck.getCarte(player, result));
				        			//Jouer carte de ton deck 
				        			break;	 
				        			
				        			
				        		default:
				    	            System.out.println("Choix invalide");
				    	            break;
	        			}

	            
	        	break;
	            
	        case 2:
	        		            
	            if (player == adversaire) {
	    			
	            	
	    			player = adversaire;
	    			if (adversaireSpecialUsed == true) {
	    				
	    				System.out.println("Vous avez déja utilisé votre Spécial dans cette partie.");
	    			}
	    			else {
	    				
	    			player.special(joueur); 
	    			adversaireSpecialUsed = true;
	    			break;
	    			}
	    			
	    		}
	    		else {
	    			player = joueur;
	    			if (joueurSpecialUsed == true) {
	    				
	    				System.out.println("Vous avez déja utilisé votre Spécial dans cette partie.");
	    			}
	    			else {
	    				
	    			
		    			player.special(adversaire); 
		    			joueurSpecialUsed = true;
		    			break;
	    			}
	    		}
	         
	            
	        case 3:
	        	if (isCartePlateauPlayer(player)) {
	        		
	        		
	        		System.out.println("Vous n'avez aucune carte sur votre plateau."
	        				+ "Nous allons utilisé une carte de votre main actuelle");
	        	}
	        	if (isCartePlateauPlayer(adversaire))
	            break;
	        case 4:
	            if (player == adversaire) {
	    			
	            	adversaire.attaquer(joueur);
	    		}
	    		else {
	            	joueur.attaquer(adversaire);

	    		}
	            break;
	        	
	        case 5:
	        	        	
            	
            	Carte carte = Deck.piocherCarte();
            	//System.out.println(" carte : "+carte);
            	List<Carte> DeckMoinsCarte = player.getDeck();
            	DeckMoinsCarte.add(carte);
            	player.setDeck(DeckMoinsCarte);
            	player.afficherDeck();
	            //player.setDeck(getMainAdversaire())
	        	//Deck.piocherCarte(player);
            	System.out.println("J'ai bien ajouté une carte à ton deck !");
	        	
	            break;
	        default:
	            System.out.println("Choix invalide");
	            break;
	    }
	    
	    
	}


}
