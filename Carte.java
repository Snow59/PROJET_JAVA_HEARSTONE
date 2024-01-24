package IMT_HearStone;


public class Carte {
    private static int compteurId = 0; 

    private final int id;
    private final String nom;
    private final int coutMana;
    private final int degatsAttaque;
    private final int addArmure;
    private final int restoreHealth;
    
    public Carte(String nom, int coutMana, int degatsAttaque,int addArmure, int restoreHealth) {
        this.id = compteurId++;
        this.nom = nom;
        this.coutMana = coutMana;
        this.degatsAttaque = degatsAttaque;
        this.addArmure = addArmure;
        this.restoreHealth = restoreHealth;
    }

    
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getCoutMana() {
        return coutMana;
    }

    
    public int getaddArmure() {
		return addArmure;
	}


	public int getrestoreHealth() {
		return restoreHealth;
	}


	public int getDegatsAttaque() {
        return degatsAttaque;
    }

    @Override
    public String toString() {
        return "Carte{" +
               "id=" + id +
               ", nom='" + nom + '\'' +
               ", coutMana=" + coutMana +
               ", degatsAttaque=" + degatsAttaque +
               ", armureAjoutee=" + addArmure +
               ", santeRestauree=" + restoreHealth +
               '}';
    }
}

