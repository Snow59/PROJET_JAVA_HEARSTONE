package IMT_HearStone;

import HearStoneClasseChampion.*;

import java.util.Scanner;

public class Monitor extends PlateauDeJeu{
	
	private Champion joueur;
	private Champion adversaire;
	private int specialUsed;
	
	
	public Monitor(Champion joueur, Champion adversaire) {
		super(joueur, adversaire);
		this.joueur = joueur;
		this.adversaire = adversaire;
		
		// TODO Auto-generated constructor stub
	}
	
	public void jouerTour(Champion player) {
		   //jaina.attaquer(medivh);
//		if (player == adversaire) {
//			
//			player.attaquer(joueur);
//		}
//		else {
//			player.attaquer(adversaire);
//		}
//	    joueur.recupererMana();
		System.out.println(player.getNom()+  "je t'ai remis ton Deck au dessus c'est ton tour , pour rappel tu as : "
				+ "\n Vie : "+player.getPointsDeVie()+
				 "\n Mana Actuel : "+player.getManaActuel()+
				 "\n Puissance d'attaque : "+player.getPuissanceAttaque());
	    Scanner scanner = new Scanner(System.in);
	    
	    int result = scanner.nextInt();
    	System.out.println(player.getNom());
		//System.out.println();
	    if (player == adversaire) {
			
	    	jouerCarte(adversaire, Deck.getCarte(adversaire, result));
		}
		else {
	    	jouerCarte(joueur, Deck.getCarte(joueur, result));

		}
		
		
	    System.out.println("Vous voulez faire quoi ? \n"
	            + "1 : jouer une carte ?\n"
	            + "2 : Jouer votre spÃ©cial\n"
	            + "3 : attaquer une cible ennemie avec une carte\n"
	            + "4 : attaquer avec votre puissance d'attaque\n"
	            + "5 : piocher une carte");

	    System.out.println(joueur.getNom());
	    int choix = scanner.nextInt();

	    switch (choix) {
	        case 1:
	        	
	        	System.out.println("Type de Jeu : ");
	        	switch(scanner.nextInt()) {
	        	
	        	
	        	
	        		case 1 :
	        			
	        			//Jouer carte qui est sur ton plateau
	        			
	        			break;
	        		case 2 :
	        			
	        			jouerCarte(adversaire, Deck.getCarte(adversaire, result));
	        			//Jouer carte de ton deck 
	        			
	        			
	        			
	        		default:
	    	            System.out.println("Choix invalide");
	    	            break;
	        			

	        	}
	            // Logique pour jouer une carte
	            break;
	        case 2:
	            joueur.special(adversaire); // Vous devez dÃ©finir comment obtenir la cible
	            specialUsed +=1 ; 
	            break;
	        case 3:
	            // Logique pour attaquer une cible ennemie avec une carte
	            break;
	        case 4:
	            joueur.attaquer(adversaire); // Vous devez dÃ©finir comment obtenir la cible
	            break;
	        case 5:
	            // Logique pour piocher une carte
	            break;
	        default:
	            System.out.println("Choix invalide");
	            break;
	    }
	    scanner.close(); // Fermer le scanner aprÃ¨s utilisation
	}


}
