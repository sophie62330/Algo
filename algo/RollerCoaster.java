package intro;

import java.util.ArrayList;
import java.util.List;

import intro.Tools;

public class RollerCoaster {
	/**
	 * Lance une partie de RollerCoaster
	 */
	public static void jouerAuRollerCoaster() {
		//initialsiation des places, tours, nombre de groupes et création file d'attente
		int places=Tools.randomint(10);
		int nbTours=Tools.randomint(10);
		int nbGroupes=-1;
		while (nbGroupes<=0) {
			 nbGroupes=Tools.randomint(10);
		}
		int nbGroupesQuiRentrent;
		int profit=0;
		String chainePourAfficherGoupesQuiRentrent;
		String chaineFinaleAAfficher="";
		ArrayList<Integer> fileAttente=remplirFile(nbGroupes,places);
		
		afficherEtatDesParametres(places,nbTours,fileAttente);
		
		for (int i=0;i<nbTours;i++) {
			nbGroupesQuiRentrent=definirCombienDeGroupesRentrent(fileAttente,places);
			profit=profit+definirCombienDeVisiteursRentrent(fileAttente, places);
			chainePourAfficherGoupesQuiRentrent="";
			for (int j=0;j<nbGroupesQuiRentrent;j++) {
				if (!chainePourAfficherGoupesQuiRentrent.isEmpty()) {
					chainePourAfficherGoupesQuiRentrent=chainePourAfficherGoupesQuiRentrent+",groupe "+(j+1)+" rentre";
				} else {
					chainePourAfficherGoupesQuiRentrent="Tour "+(i+1)+" : groupe "+(j+1)+" rentre";
				}
				mettrePremierElementListeAuBout(fileAttente);
			}
			chaineFinaleAAfficher=chainePourAfficherGoupesQuiRentrent+" (état de la file : "+getChaineDAffichageListe(fileAttente);
			System.out.println(chaineFinaleAAfficher);
		}
		
		System.out.println("Profit de "+profit+"€ !");
	}
	
	/**
	 * définit combien de groupes rentrent
	 * @param file la file
	 * @param nbPlaces le nb de places
	 * @return le nombre de groupes qui peuvent rentrer
	 */
	public static int definirCombienDeGroupesRentrent(ArrayList<Integer> file,int nbPlaces){
		int nb=0;
		int nbVisiteursQuiRentrent=0;
		int i=0;
		while (file.get(i)+nbVisiteursQuiRentrent<=nbPlaces) {
			nb++;
			nbVisiteursQuiRentrent=nbVisiteursQuiRentrent+file.get(i);
			i++;
		}
				
		return nb;
	}
	
	/**
	 * définit combien de visiteurs rentrent
	 * @param file la file
	 * @param nbPlaces le nb de places
	 * @return le nombre de visiteurs rentrent
	 */
	public static int definirCombienDeVisiteursRentrent(ArrayList<Integer> file,int nbPlaces){
		int nbVisiteursQuiRentrent=0;
		
		for (int groupe : file) {
			if (groupe+nbVisiteursQuiRentrent<=nbPlaces) {
				nbVisiteursQuiRentrent=nbVisiteursQuiRentrent+groupe;
			}
		}
		
		return nbVisiteursQuiRentrent;
	}
	
	
	/**
	 * Crée et retourne la file d'attente avec un nombre aléatoire de visiteurs par groupe
	 * @param nbGroupes le nombre de groupes = nb éléments de la liste
	 * @param nbPlaces = nombre max de visiteurs par groupe
	 * @return la file d'attente
	 */
	public static ArrayList<Integer> remplirFile(int nbGroupes,int nbPlaces){
		ArrayList<Integer> maFile=new ArrayList<Integer>();
		int nbVisiteurs=0;
		for (int i = 0; i < nbGroupes; i++) {
			nbVisiteurs=Tools.randomint(nbPlaces);
			while (nbVisiteurs<=0) {
				nbVisiteurs=Tools.randomint(nbPlaces);
				System.out.println(nbVisiteurs);
			}
			maFile.add(nbVisiteurs);
		}
		
		return maFile;
	}
	
	/**
	 * Affiche la première ligne du jeu avec les infos des paramétres
	 * @param nbPlaces le nb de places
	 * @param nbTours le nb de tours
	 * @param fileAttente la file
	 */
	public static void afficherEtatDesParametres(int nbPlaces,int nbTours,ArrayList<Integer> fileAttente) {
		String file="["+Tools.retourneChaineCorrespondantAListeIntegerSeparesParSeparateur(fileAttente,',')+"]";
		System.out.println("Places : "+nbPlaces+" , tours : "+nbTours+" , file : "+file);
	}
	
	/**
	 * permet de transformer une liste en chaine de caractéres séparé par des ,
	 * @param file la liste 
	 * @return la chaine de caractére correspondante
	 */
	public static String getChaineDAffichageListe(ArrayList<Integer> file) {
		return "["+Tools.retourneChaineCorrespondantAListeIntegerSeparesParSeparateur(file,',')+"]";
	}
	
	/**
	 * enléve le premier élément de la liste pour le remettre au bout
	 * @param liste la liste à traiter
	 */
	public static void mettrePremierElementListeAuBout(ArrayList<Integer> liste) {
		int nb;
		if (!liste.isEmpty()) {
			nb=liste.get(0);
			liste.remove(0);
			liste.add(nb);
		}
	}
		
}
