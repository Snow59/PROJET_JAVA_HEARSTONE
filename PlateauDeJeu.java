package IMT_HearStone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    	
        	
        	//System.out.println("CARTE PLATEAU ALLIEE"+carte);
        	
        	CheckChampion(champion);
        	
        	if((isCartePlateauPlayer(champion)|| (carte.getType() != ("Classique") ))){
        			
        			
		        	if (champion == joueur) {
		            	
		        		
		        		
			            	if (carte.getType() == "Mascotte"){
			            		
			            		System.out.println("Une carte de type boost Mascotte a été posée");
			            		
			            		List<Carte> plateauAllie = PlateauPlayer(joueur); // Je recupere le plateau adverse et je prend une carte au hasard dedans
				        		
				        		Random random = new Random();
				        	    int alea = random.nextInt(plateauAllie.size()); // Cho

				        	    Carte carteAdv  = Monitor.getCartePlateauAtt(plateauAllie, alea);
			            		carte.carteMascotte(carte, joueur);
			            	}
			            	
			            	else if(carte.getType() == "Soigneur")
			            	{
			            		List<Carte> DeckMoinsCarte = joueur.getDeck();
		                    	DeckMoinsCarte.remove(carte);
		                    	
		                    	joueur.setDeck(DeckMoinsCarte);
		                    	//joueur.afficherDeck();
		         
		            			
			            		carte.action(joueur , adversaire, this , carteSurLePlateau, joueurCarteEnJeu , adversaireCarteEnJeu);
			            		System.out.println("Carte pas add sur mon plateau psk "+carte.getType());
			            	}
			            	
			            	else if(carte.getType() == "Protecteur") {
			            		
			            		List<Carte> DeckMoinsCarte = joueur.getDeck();
		                    	DeckMoinsCarte.remove(carte);
		                    	
		                    	joueur.setDeck(DeckMoinsCarte);
		                    	//joueur.afficherDeck();
		         
		            			
			            		//carte.action(joueur , adversaire, this , carteSurLePlateau, joueurCarteEnJeu , adversaireCarteEnJeu);
			            		//joueurCarteEnJeu.add(carte);
			            		
			            	}
			            	else {
			            		
			            			
			            			joueurCarteEnJeu.add(carte);
			
			                    	List<Carte> DeckMoinsCarte = joueur.getDeck();
			                    	DeckMoinsCarte.remove(carte);
			                    	
			                    	joueur.setDeck(DeckMoinsCarte);
			                    	//joueur.afficherDeck();
			         
			            			}
			      				carte.action(joueur , adversaire, this , carteSurLePlateau, joueurCarteEnJeu , adversaireCarteEnJeu);
		
		        	}
		        	
		        	else if(champion == adversaire){
		  
			        		if (carte.getType() == "Mascotte"){
			            		
			            		System.out.println("Une carte de type boost Mascotte a été posée");
			            		List<Carte> plateauAdversaire = PlateauPlayer(adversaire); // Je recupere le plateau adverse et je prend une carte au hasard dedans
				        		
				        		Random random = new Random();
				        	    int alea = random.nextInt(plateauAdversaire.size()); // Cho

				        	    Carte carteAdv  = Monitor.getCartePlateauAtt(plateauAdversaire, alea);
			            		carte.carteMascotte(carte, adversaire);
			
			            	}
			        		else if(carte.getType() == "Soigneur")
			            	{
			            		List<Carte> DeckMoinsCarte = adversaire.getDeck();
		                    	DeckMoinsCarte.remove(carte);
		                    	
			                	adversaire.setDeck(DeckMoinsCarte);
		                    	//joueur.afficherDeck();
		         
		            			
				                carte.action(adversaire , joueur, this , carteSurLePlateau, adversaireCarteEnJeu , joueurCarteEnJeu);
			            		System.out.println("Carte pas add sur mon plateau psk "+carte.getType());
			            	}
			        		else if(carte.getType() == "Protecteur")
			            	{
			            		List<Carte> DeckMoinsCarte = adversaire.getDeck();
		                    	DeckMoinsCarte.remove(carte);
		                    	
			                	adversaire.setDeck(DeckMoinsCarte);
		                    	//joueur.afficherDeck();
		         
		            			
				                //carte.action(adversaire , joueur, this , carteSurLePlateau, adversaireCarteEnJeu , joueurCarteEnJeu);

			            	}

			            	else {
			            		
			            		adversaireCarteEnJeu.add(carte);
			            		List<Carte> DeckMoinsCarte = adversaire.getDeck();
			                	DeckMoinsCarte.remove(carte);
			                	
			                	adversaire.setDeck(DeckMoinsCarte);
			                	//adversaire.afficherDeck();
			
			            	}
			                carte.action(adversaire , joueur, this , carteSurLePlateau, adversaireCarteEnJeu , joueurCarteEnJeu);
				
		        	}

        	}
        	
        	else{
        		if (champion == joueur)
        		{
        			
        			//Si le champion est allié on recup le plateau adverse
	        		List<Carte> plateauAdversaire = PlateauPlayer(adversaire); // Je recupere le plateau adverse et je prend une carte au hasard dedans
	        		
	        		Random random = new Random();
	        	    int alea = random.nextInt(plateauAdversaire.size()); // Cho

	        	    Carte carteAdv  = Monitor.getCartePlateauAtt(plateauAdversaire, alea);
	        		carte.actionClassique(carte, carteAdv);
                	joueurCarteEnJeu.add(carte);

	        		if (carteAdv.getVie() <= 0) {
	        			
	        			
	        			
	        			List<Carte> DeckMoinsCarte = PlateauPlayer(adversaire); 
                    	DeckMoinsCarte.remove(carteAdv);
                    	adversaireCarteEnJeu = DeckMoinsCarte;
                    	//System.out.println(adversaireCarteEnJeu);
                    	System.out.println("LES NOUVELLES CARTES EN JEUX DE : " + adversaire.getNom()+" -> " +adversaireCarteEnJeu);

	        		}
	        		
	        		
        		}
	        		
        		else if(champion == adversaire) 
        		{
        			List<Carte> plateauAllie1 = PlateauPlayer(joueur); // Je recupere le plateau adverse et je prend une carte au hasard dedans
	        		//System.out.println("Plateau alliée : "+plateauAllie);
	        		
	        		
	        		Random random1 = new Random();
	        		int alea1 = random1.nextInt(plateauAllie1.size()); // Cho

	        		//carte.actionClassique(carte,Monitor.getCartePlateauAtt(plateauAllie, alea1));
	        		Carte carteAdv1  = Monitor.getCartePlateauAtt(plateauAllie1, alea1);
	        		
	        		carte.actionClassique(carte, carteAdv1);
	        		adversaireCarteEnJeu.add(carte);
	        		if (carteAdv1.getVie() <= 0) {
	        			
	        			List<Carte> DeckMoinsCarte1 = PlateauPlayer(joueur); 
                    	DeckMoinsCarte1.remove(carteAdv1);
                    	joueurCarteEnJeu = DeckMoinsCarte1;
                    	System.out.println("LES NOUVELLES CARTES EN JEUX DE : " +joueur.getNom()+" ->" +joueurCarteEnJeu);
	        		}
	        		
	        		
        		}
        	}
        	
        	
        	carteSurLePlateau.add(carte);

		        	
        }
    
    
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
    
   
    

    
    
    public List<Carte>  PlateauPlayer(Champion player){
    	
    	if (player ==joueur) {
    		
    		return joueurCarteEnJeu;
    	}
    	else {
    		
    		return adversaireCarteEnJeu;
    	}
     
    }
    
    
    public void CheckChampion(Champion champion) {
    	
    	if (champion == joueur) {
    		
    		this.joueur = joueur;
    	}
    	else {
    		
    		this.adversaire = adversaire;
    	}
    }
    
    
    
    public List<Carte> getMainJoueur() {
        return mainJoueur;
    }
    
    

    public List<Carte> getMainAdversaire() {
        return mainAdversaire;
    }
    
    
    
    
    public boolean isProtected() {
    	if (protecteur == true) {
    		
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    boolean protecteur = false;
    
    
    public void ajouterProtecteur(Carte carte) 
    {
    	if (carte.getAddArmure() > 0){
    		
    		protecteur = true;
    	}
    	else {
    		protecteur = false;
    	}
    }
    // Autres mÃ©thodes utiles
}
