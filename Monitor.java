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
	/**
	 * Mais en place le systeme de jeu.
	 * Tour par tour.
	 * En prenant ce que l'utilisateur saisi sur la console
	 * @param player
	 */
	public void jouerTour(Champion player) {
		
		if (player == adversaire) {
			
			player = adversaire;
		}
		else {
			player = joueur;

		}
		
		player.afficherDeck();
		
		boolean jeuEnCours = true;
		while (jeuEnCours) {
			
		
				afficherMenu();
				
				infoPlayer(player);
			    
				System.out.println("\n Faites un choix : ");
			    Scanner scanner = new Scanner(System.in);
		
			    int choix = scanner.nextInt();
			    
			    switch (choix) {
			    
			    	
			        case 1:
			        	
			        	System.out.println(" Faites un choix  : ");
			        	System.out.println("1) Pour utiliser une carte que vous avez posé sur le plateau"
			        			+ "\n2) Poser une nouvelle carte ");
			        	
		
			        	int choix1 = scanner.nextInt();
			        	
			        	
			        	switch(choix1) {
			        		
						        		case 1 :
						        			
						        			
						        			
						        			
						        			if (isCartePlateauPlayer(player)) { //verifie si le player a des cartes sur le plateau
						        	    		
						        	    		System.out.println("Tu n'as aucune carte sur le plateau désolé , ");
						        	    	}
						        			else {
						        				
						        				
						        				
						        				List<Carte> PlateauJoueur = PlateauPlayer(player);
						        				System.out.println(PlateauJoueur);
						        				System.out.println("Entrez l'id de la carte que vous voulez mettre : ");
						        				int result = scanner.nextInt();
						        				
						        				//System.out.println(PlateauJoueur.get(result));
						        				if (getCartePlateau(PlateauJoueur, result) != null) {
						        					
						        					jouerCarte(player, getCartePlateau(PlateauJoueur, result));
							        				jeuEnCours = false;
						        				}
						        				else {
						        					
						        					System.out.println("L'adversaire n'a pas de carte è attaquer");
						        				}
						        				break;
						        				
						        				
						        				
						        				
						        			}
						        							        			
						        		case 2 :
						        							        			
						        			System.out.println("Entrez l'id de la carte que vous voulez utiliser : ");
						        			boolean test = false;
						        			while (test != true) {
						        				
						     
						        			
							        			try {
							        				
							        				
								        			int result = scanner.nextInt();
								        			if(Deck.checkmana(player, Deck.getCarte(player, result))) {
								        				jouerCarte(player, Deck.getCarte(player, result));
									        			System.out.println("Votre mana  pour ce tour est de :"+player.getManaActuel());
									        			test = true;
									        			jeuEnCours = false;
									        			
								        			}			        			
								        			else {
								        				System.out.println("Vous n'avez pas assez de mana pour cette carte "+player.getManaActuel());
								        				System.out.println("Choisissez une autre option : ");
								        				
								        				break;
								        			}
								        			
							        			}
							        			catch(Exception e) {
							        				System.out.println("l'ID n'existe pas choisi en un autre :");
							        			}
							        			//Jouer carte de ton deck 
			        						}
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
			    				break;
			    			}
			    			
			    			else {
			    				
			    			player.special(joueur); 
			    			adversaireSpecialUsed = true;
		        			jeuEnCours = false;

			    			break;
			    			}
			    			
			    		}
			    		else {
			    			player = joueur;
			    			if (joueurSpecialUsed == true) {
			    				
			    				System.out.println("Vous avez déja utilisé votre Spécial dans cette partie.");
			    				break;
			    			}
			    			else {
			    				
			    			
				    			player.special(adversaire); 
				    			joueurSpecialUsed = true;
			        			jeuEnCours = false;

				    			break;
			    			}
			    		}
			         
			            
			        case 3:
			        	if (isCartePlateauPlayer(player)) {
			        		
			        		System.out.println("Vous n'avez aucune carte sur votre plateau."
			        				+ "Nous allons utilisé une carte de votre main actuelle"
			        				+ "Retourn au menu principal");
		        			jeuEnCours = false;

			        		
			        	}
			        	if (isCartePlateauPlayer(adversaire)) {
			        		
			        		System.out.println("Vous n'avez aucune carte sur votre plateau."
			        				+ "Nous allons utiliser une carte de votre main actuelle"
			        				+ "Retour au menu principal");
		        			jeuEnCours = false;

			        	}
			            break;
			        	
			        	
			        	
			        case 4:
			            if (player == adversaire) {
			    			
			            	adversaire.attaquer(joueur);
		        			jeuEnCours = false;

			    		}
			    		else {
			            	joueur.attaquer(adversaire);
		        			jeuEnCours = false;

		
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
		            	jeuEnCours = false;
		            	
		            	
			            break;
			        default:
			            System.out.println("Choix invalide");
			            break;
			    }
		}
	    
	}
	    /**
		 * Methode qui affiche le menu sur la console
		 */
	    private void afficherMenu() {
	    	
	    	System.out.println("\nVous voulez faire quoi ? \n"
		            + "[1] : jouer une carte ?\n"
		            + "[2] : jouer votre spécial\n"
		            + "[3] : attaquer une cible ennemie avec une carte\n"
		            + "[4] : attaquer avec votre puissance d'attaque\n"
		            + "[5] : piocher une carte");
	    }
	    /**
		 * Methode qui affiche les informations du Champion
		 * @param player
		 */
	    private void infoPlayer(Champion player) {
	    	
	    	System.out.println("\n"+player.getNom()+  " je t'ai remis ton Deck au dessus c'est ton tour , pour rappel tu as : "
					+ "\n Vie : "+player.getPointsDeVie()+
					 "\n Mana Actuel : "+player.getManaActuel()+
					 "\n Puissance d'attaque : "+player.getPuissanceAttaque()+
					 "\n Armure : "+player.getArmure());
	    	
	    	
	    	
	    }
	    
	    
	    /**
		 * Methode qui retourne la carte se trouvant sur le plateau
		 * @param cartes
		 * @param id
		 * @return carte
		 */
	    public static Carte getCartePlateau(List<Carte> cartes, int id) {
	    	
	    	//System.out.println("GET CARTE : "+cartes);
	    	for(Carte carte : cartes ) {
	    		
	    		if (carte.getId() == id){
	    			return carte;
	    		}
	    	}
	    		
			return null;
	    }
		/**
		 * Methode qui retourne la carte qui attaque
		 * @param cartes
		 * @param index
		 * @return carte
		 */
	    public static Carte getCartePlateauAtt(List<Carte> cartes, int index) {
	        if (index >= 0 && index < cartes.size()) {
	            return cartes.get(index);
	        }
	        return null; // Or throw an exception
	    }
}
