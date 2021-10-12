package intro;

import intro.Tools;

public class JustePrix {
	/**
	 * Lance une partie du juste prix
	 */
	public static void jouerAuJustePrix() {
		int nbVies=Tools.inputInt("Combien de tentatives voulez-vous ? ");
		int limite=Tools.inputInt("Quel est le nombre maximum à prendre en compte?");
		int nbATrouver=Tools.randomint(limite);
		int nbPropose;
		
		while (nbVies>0){
			nbPropose=Tools.inputInt("Saisissez un nombre : ");
			if (afficherResultatProposition(nbPropose, nbATrouver)) {
				break;
			};
			nbVies=nbVies-1;
		}
		
		if (nbVies==0) {
			System.out.println("Game Over");
		}
	}

	/**
	 * permet de savoir si le nombre proposé est plus grnd que le nombre à trouver
	 * @param nbPropose nombre proposé
	 * @param nbAtrouver nombre à trouver
	 * @return vrai si le nombre proposé est plus grand que le nombre à trouver, faux sinon
	 */
	public static boolean nbProposeEstPlusGrand(int nbPropose,int nbAtrouver) {
		return (nbPropose>nbAtrouver);
	}
	
	/**
	 * permet de savoir si le nombre proposé est plus petit que le nombre à trouver
	 * @param nbPropose nombre proposé
	 * @param nbAtrouver nombre à trouver
	 * @return vrai si le nombre proposé est plus petit que le nombre à trouver, faux sinon
	 */
	public static boolean nbProposeEstPlusPetit(int nbPropose,int nbAtrouver) {
		return (nbPropose<nbAtrouver);
	}
	
	/**
	 * fonction d'affichage du résultat pour savoir si le nombre proposé est plus grand ou plus petit
	 * @param nbPropose le nombre proposé
	 * @param nbATrouver le nombre à trouver
	 * @return true si le nombre a été trouvé
	 */
	public static boolean afficherResultatProposition(int nbPropose,int nbATrouver) {
		boolean res=false;
		if (nbProposeEstPlusGrand(nbPropose, nbATrouver)) {
			System.out.println("C'est moins !");
		} else if (nbProposeEstPlusPetit(nbPropose, nbATrouver)) {
			System.out.println("C'est plus !");
		} else {
			System.out.println("Bravo ! Vous avez trouvé le nombre "+nbATrouver);
			res=true;
		}
		
		return res;
	}
}
