package IMT_HearStone;

/**
 * Interface permettant de definir les 2 fonctions principales d'un champion
 * qui sont :Attaquer et utiliser le Special
 */
public interface ActionDeJeu {
    void attaquer(Champion cible); // Utiliser Champion ou un autre type approprié
	void special(Champion cible);  
}
