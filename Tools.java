package intro;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tools {
	/**
	 * demande à l'utilisateur dentrer un string
	 * @param message de demande
	 * @return un string
	 */
	public static String inputString(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		return scan.next();	
	}

	/**
	 * demande à l'utilisateur dentrer un string avec espaces possibles
	 * @param message de demande
	 * @return un string
	 */
	public static String inputStringAvecEspaces(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		return scan.nextLine();
	}
	
	/**
	 * demande à l'utilisateur dentrer un float
	 * @param message de demande
	 * @return un string
	 */
	public static Float inputFloat(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		return scan.nextFloat();
	}
	
	/**
	 * demande à l'utilisateur dentrer un int
	 * @param message de demande
	 * @return un int
	 */
	public static int inputInt(String message) {
		System.out.println(message);
		Scanner scan=new Scanner(System.in);
		return scan.nextInt();
	}
	
	/**
	 * Retourne le plus grand nombre de ceux passés en paramétres
	 * @param nombres les nombres à tester
	 * @return le plus grand en int
	 */
	public static int retourneLePlusGrand(int...nombres) {
		int plusGrand=nombres[0];
		for (int nombreCourant : nombres) {
			if (nombreCourant>plusGrand) {
				plusGrand=nombreCourant;
			}
		}
		return plusGrand;
	}
	
	/**
	 * calcule la somme de tous les nombres qui précédent le nb en param
	 * @param nombre la borne
	 * @return la somme en int
	 */
	public static int calculerSommeSuiteNombresPrecedents(int nombre) {
		int resultat=0;
		
		for (int i = 1;i<=nombre;i++) {
			resultat+=i;
		}
		return resultat;
	}
	
	/**
	 * calcule la différence nb1-nb2
	 * @param nb1 le premier nombre
	 * @param nb2 le deuxiéme nombre
	 * @return le résultat
	 */
	public static int calculerDifference(int nb1,int nb2) {
		int resultat=nb1-nb2;
		if (resultat<0) {
			resultat=resultat*(-1);
		}
		return resultat;
	}
	
	/**
	 * Opération arithmétique somme basique
	 * @param nb1 premier nombre à ajouter
	 * @param nb2 2éme nombre à ajouter
	 * @return la somme en int
	 */
	public static int somme(int nb1,int nb2) {
		return nb1+nb2;
	}
	
	public static int randomint(int limite) {
		int nombre=new Random().nextInt(limite);
		return nombre;
	}
	
	/**
	 * Opération arithmétique soustraction 
	 * @param nb1 1er opérande
	 * @param nb2 2éme opérande
	 * @return nb1-nb2
	 */
	public static int soustraction(int nb1,int nb2) {
		return nb1-nb2;
	}
	
	/**
	 * Opération arithmétique multiplication 
	 * @param nb1 1er opérande
	 * @param nb2 2éme opérande
	 * @return nb1*nb2
	 */
	public static int multiplication(int nb1,int nb2) {
		return nb1*nb2;
	}
	
	/**
	 * Opération arithmétique division
	 * @param nb1 1er opérande
	 * @param nb2 2éme opérande
	 * @return nb1/nb2 en int
	 */
	public static int division(int nb1,int nb2) {
		return nb1/nb2;
	}
	
	/**
	 * exemple : liste composée de 1 5 8 3 avec separateur ';' doit retourner 1;5;8;3
	 * @param liste
	 * @param separateur
	 */
	public static String retourneChaineCorrespondantAListeSeparesParSeparateur(ArrayList<String> maListe,char separateur) {
		String resultat="";

		for (int i=0;i<maListe.size();i++){
			if (i==0) {
				resultat=maListe.get(i);
			} else {
				resultat=resultat+separateur+maListe.get(i);
			}
		}
		return resultat;
	}
	
	/**
	 * exemple : liste composée de 1 5 8 3 avec separateur ';' doit retourner 1;5;8;3
	 * @param liste
	 * @param separateur
	 */
	public static String retourneChaineCorrespondantAListeIntegerSeparesParSeparateur(ArrayList<Integer> maListe,char separateur) {
		String resultat="";

		for (int i=0;i<maListe.size();i++){
			if (i==0) {
				resultat=maListe.get(i).toString();
			} else {
				resultat=resultat+separateur+maListe.get(i).toString();
			}
		}
		return resultat;
	}
	
	/**
	 * permet de savoir si un nombre est un multiple d'un autre nombre
	 * @param nb le nombre a tester
	 * @param multiple le multiple testé
	 * @return vrai si nb est multiple de multiple, fase sinon
	 */
	public static boolean estUnMultipleDe(int nb, int multiple) {
		return (nb%multiple==0);
	}
	
	//double entre deux valeurs
	public static double randomDouble(double borneInf,Double borneSup) {
		Random randomValue=new Random(); 
		return borneInf+(borneSup-borneInf)*randomValue.nextDouble();
	}
	
	/**
	 * permet de récupérer la niéme valeur dans une chaine séparé par des séparateurs (ex : getValeur("Bonjour le monde",3," ")=>monde
	 * @param chaine la chaine
	 * @param index le numéro de l'élement quon veut
	 * @param separateur le séparateur a prendre en comte
	 * @return le nieme élement de ma chaine en fonction des séparateurs
	 */
	public static String getValeur(String chaine,int index, String separateur) { //index commence à 1
		int indexDepart=0;
		String res="";
		int cpt=1;
		int indexSeparateur;
		while (cpt<index) {
			indexSeparateur=chaine.indexOf(separateur);
			if (indexSeparateur!=-1) {
				chaine=chaine.substring(indexSeparateur+1);
			} 
			cpt++;
		}
		
		if (chaine.indexOf(separateur)!=-1) {
			return chaine.substring(0,chaine.indexOf(separateur));
		} else {
			return chaine;
		}
	}

}
