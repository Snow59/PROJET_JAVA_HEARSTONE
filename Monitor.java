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
	
	public void jouerTour(Champion joueur) {
		joueur.attaquer(adversaire);   //jaina.attaquer(medivh);
		
	    joueur.recupererMana();
	    System.out.println("Vous voulez faire quoi ? \n"
	            + "1 : jouer une carte ?\n"
	            + "2 : Jouer votre spécial\n"
	            + "3 : attaquer une cible ennemie avec une carte\n"
	            + "4 : attaquer avec votre puissance d'attaque\n"
	            + "5 : piocher une carte");

	    System.out.println(joueur.getNom());
	    Scanner scanner = new Scanner(System.in);
	    int choix = scanner.nextInt();

	    switch (choix) {
	        case 1:
	            // Logique pour jouer une carte
	            break;
	        case 2:
	            joueur.special(adversaire); // Vous devez définir comment obtenir la cible
	            specialUsed +=1 ; 
	            break;
	        case 3:
	            // Logique pour attaquer une cible ennemie avec une carte
	            break;
	        case 4:
	            joueur.attaquer(adversaire); // Vous devez définir comment obtenir la cible
	            break;
	        case 5:
	            // Logique pour piocher une carte
	            break;
	        default:
	            System.out.println("Choix invalide");
	            break;
	    }
	    scanner.close(); // Fermer le scanner après utilisation
	}


}
