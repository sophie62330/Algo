package intro;

import java.util.ArrayList;
import java.util.List;

public class Pendu {
	/**
	 * Lance une partie de pendu
	 */
	public static void jouerAuPendu() {
		//initialisation
		String motEnCours;
		String motATrouver=Tools.inputString("Tapez le mot à trouver ! ");
		int nbVies=Tools.inputInt("Tapez le nombre de vies !");
		String lettreTapee;
		List<String> listeLettresTrouvees=new ArrayList<String>();
		boolean iFini=false;
		
		while (!iFini) {
			//affichage du mot à trouver avec des _ a la place des lettres non trouvées
			motEnCours=espacerCaracteresDeChaine(getMotCacheAvecLettresDecouvertes(motATrouver, listeLettresTrouvees));
			System.out.println(motEnCours);
			
			//si le mot n'est pas entièrement trouvé
			if (motEnCours.contains("_")) {
				lettreTapee=Tools.inputString("Tapez une lettre : ");
				//on regarde si la lettre tapée appartient au mot
				if (!motATrouver.contains(lettreTapee)) {
					//si elle ne lui appartient pas on enléve une vie et on regarde sil reste des vies, si il ny en a plus => on sort de la boucle et game over
					nbVies=nbVies-1;
					if (nbVies==0) {
						iFini=true;
					}
				} else { //la lettre tapée est contenue dans le mot a trouver
					if (listeLettresTrouvees.indexOf(lettreTapee)==-1)
						listeLettresTrouvees.add(lettreTapee); //on ajoute la lettre a la liste des lettres trouvées
				}
			} else {
				iFini=true;
			}
		}
		
		if ((iFini) && (nbVies>0)) {
			System.out.println("Bravo vous avez trouvé le mot '"+motATrouver+"' !");
		} else {
			System.out.println("Game over !");
		}
		
	}
	
	/**
	 * permet de récupérer la chaine correspondant au mot en cours, avec des _ pour les lettres non découvertes
	 * @param mot le mot à trouver
	 * @param listeLettresTrouvees la liste des lettres trouvées
	 * @return
	 */
	public static String getMotCacheAvecLettresDecouvertes(String mot,List<String> listeLettresTrouvees) {
		String chaineAAfficher="";
		boolean iLettreTrouvee;
		for (int i=0;i<=mot.length()-1;i++) {
			char caractereCourant=mot.charAt(i);
			iLettreTrouvee=false;
			for (String s : listeLettresTrouvees) {
				if (s.charAt(0)==caractereCourant) {
					chaineAAfficher=chaineAAfficher+caractereCourant;
					iLettreTrouvee=true;
				}
			}
			if (!iLettreTrouvee)
				chaineAAfficher=chaineAAfficher+"_";
		}
		
		return chaineAAfficher;
	}
	
	/**
	 * retourne une chaine avec des espaces entre chaque caractére de la chaine en paramétre
	 * @param s la chaine a espacer
	 * @return la chaine s avec des espaces
	 */
	public static String espacerCaracteresDeChaine(String s) {
		String res="";
		for (int i=0;i<s.length();i++) {
			res=res+s.charAt(i)+" ";
		}
		return res;
	}
}
