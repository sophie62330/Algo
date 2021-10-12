package intro;

import java.util.ArrayList;
import java.util.Scanner;
import intro.Tools;

public class ExercicesAlgo {
	/**
	 * Ecrire un programme qui demande à l'utilisateur de saisir son nom et de lui afficher son nom avec le
	 * message de bienvenue.
	 * @param message de demande
	 */
	public static void exo1(String message) {
		String retour=Tools.inputString(message);
		System.out.println("Bienvenu "+retour);
	}
	

	/**
	 * Écrivez un programme pour saisir deux nombres de l'utilisateur et calculer leur somme. L'utilisateur
	 * doit donc entrer deux valeurs, puis le programme calcule leur somme.
	 */
	public static void exo2() {
		int nb1=Tools.inputInt("Entrez un nombre : ");
		int nb2=Tools.inputInt("Entrez un deuxième nombre : ");
		
		int somme=nb1+nb2;
		
		System.out.println(nb1+"+"+nb2+"="+somme);
	}
	
	/**
	 * Écrivez un programme qui demande à l'utilisateur de saisir le prix de fabrication et le prix de vente
d'un produit et vérifiez le profit ou la perte.
Si le prix de fabrication est supérieur au prix de vente, il y a perte sinon profit.
	 */
	public static void exo3() {
		int prixVente=Tools.inputInt("Tapez le prix de vente : ");
		int prixFabrication=Tools.inputInt("Tapez le prix de fabrication : ");
		
		int difference=Tools.calculerDifference(prixFabrication, prixVente);
		
		if (prixVente>prixFabrication) {
			System.out.println("Profit de "+difference);
		} else if (prixFabrication>prixVente) {
			System.out.println("Perte de "+difference);
		} else {
			System.out.println("Pas de perte, pas de profit !");
		}
	}	

	/**
	 * Écrivez un programme qui demande à l'utilisateur de saisir 3 nombres puis trouver le plus grand.
	 */
	public static void exo4() {
		int nb1=Tools.inputInt("Entrez un nombre : ");
		int nb2=Tools.inputInt("Entrez un deuxième nombre : ");	
		int nb3=Tools.inputInt("Entrez un troisième nombre : ");	
		
		int plusGrand=Tools.retourneLePlusGrand(nb1,nb2,nb3);
	
		System.out.println("["+nb1+","+nb2+","+nb3+"]-->"+plusGrand);
	}
	
	/**
	 * Écrivez un programme pour un professeur flemmard.
Vous disposez d'une liste de notes comprises entre 0 et 20
Écrivez un commentaire pour chacune de ces copies d'élève
	 * @param args
	 */
	public static void exo5(int...args) {
		for (int nbCourant : args) {
			afficheCommentaireNote(nbCourant);
		}
	}
	
	/**
	 * affiche le commentaire correspondant à la note
	 * @param note 
	 */
	public static void afficheCommentaireNote(int note) {
		if (note<=4) {
			System.out.println("Note "+note+" --> Catastrophique,il faut tout revoir!");
		} else if (note<=10) {
			System.out.println("Note "+note+" --> Insuffisant");
		} else if (note<=14) {
			System.out.println("Note "+note+" --> Peut mieux faire");
		} else if (note<=17) {
			System.out.println("Note "+note+" --> Bien");
		} else {
			System.out.println("Note "+note+" --> Excellent, bon travail !");
		}
	}

	/**
	 * Permet d'afficher un résultat d'opération
	 * @param nb1 opérande 1
	 * @param nb2 opérande 2
	 * @param operateur opérateur + - * ou /
	 * @param resultat résultat de l'opération
	 */
	public static void afficheOperation(int nb1,int nb2,String operateur,int resultat) {
		System.out.println("["+nb1+",\""+operateur+"\","+nb2+"] = "+resultat);
	}
	
	/**
	 * Écrivez un programme qui simulera une calculatrice et demande à l'utilisateur de saisir un premier
opérande, un opérateur et un second opérande.
Ce programme exécutera des opérations arithmétiques de base (addition, soustraction, multiplication
et division selon l'opérateur saisi
	 */
	public static void exo6() {		
		String operateur=Tools.inputString("Entrez un opérateur : ");
		int nb1=Tools.inputInt("Entrez un premier nombre : ");
		int nb2=Tools.inputInt("Entrez un deuxième nombre : ");		
		int resultat=0;
		
		switch (operateur) {
			case "+" : 
				resultat=Tools.somme(nb1,nb2);
				break;
			case "-" :
				resultat=Tools.soustraction(nb1, nb2);
				break;
			case "/" :
				resultat=Tools.division(nb1, nb2);
				break;
			case "*" :
				resultat=Tools.multiplication(nb1, nb2);
				break;
			default :
				System.out.println("Vous n'avez pas saisi un opérateur valide !");			
		}
		
		afficheOperation(nb1, nb2, operateur, resultat);
	}
	

	/**
	 * Écrivez un programme qui demande à l'utilisateur de saisir un nombre "N".
Calculer la somme de tous les nombres entre 1 et N
	 */
	public static void exo7() {
		String chaine="";
		ArrayList<String> listeNbPrecedents=new ArrayList<String>();
		int nb = Tools.inputInt("Tapez un nombre :");
		int resultat=Tools.calculerSommeSuiteNombresPrecedents(nb);
		int i =1;
		
		//je crée ma liste de nombre pour pouvoir m'en servir dans la fonction en dessous
		for (i=1;i<=nb;i++) {
			listeNbPrecedents.add(String.valueOf(i));
		}
		
		//on crée la chaine a afficher
		chaine=chaine+Tools.retourneChaineCorrespondantAListeSeparesParSeparateur(listeNbPrecedents, '+');

		//ajout du résultat au bout
		chaine=chaine+" = "+resultat;
		
		System.out.println(chaine);
	}	
	
	/**
	 * Écrivez un programme qui demande à un utilisateur un nombre puis qui génère un escalier d'étoiles.
	 */
	public static int exo8() {
		int nb=Tools.inputInt("Tapez un nombre : ");
		String chaine="";
		for (int i=1;i<=nb;i++) {
			chaine=chaine+"*";
			System.out.println(chaine);
		}

		return nb;
	}
	
	/**
	 * Adaptez l'exercice 8 pour faire descendre l'escalier dans l'autre sens afin de former une pyramide
	 */
	public static void exo9() {
		int nb=exo8();
		int j=1;
		for (int i=nb-1;i>0;i--) {
			while (j<=i) {
				System.out.print("*");
				j++;
			}
			j=1;
			System.out.println();
		}
	}
	
	/**
	 * Adaptez l'exercice 9 pour que la pyramide soit dans le bon sens (^)
	 */
	public static void exo10() {
		int nb=Tools.inputInt("Tapez un nombre : ");
		int nbCaracteresSurUneLigne=nb*2-1;
		int nbEtoilesDeLaLigne;
		int nbLignes=nb;
		int ligneCourante;
		int nbEspacesTotal;
		int nbEspacesGaucheEtDroite;
		
		for (int i=0;i<nbLignes;i++) {
			ligneCourante=i;
			nbEtoilesDeLaLigne=1+2*ligneCourante;
			nbEspacesTotal=nbCaracteresSurUneLigne-nbEtoilesDeLaLigne;
			nbEspacesGaucheEtDroite=nbEspacesTotal/2;
			
			for (int k=1;k<=nbEspacesGaucheEtDroite;k++) {
				System.out.print(" ");
			}
					
			//affichage des étoiles
			for (int l=1;l<=nbEtoilesDeLaLigne;l++) {
				System.out.print("*");
			}
			
			//affichage des espaces droit
			for (int m=1;m<=nbEspacesGaucheEtDroite;m++) {
				System.out.print(" ");
			}
			
			System.out.println();
		}
	}
	
	/**
	 * Écrivez un programme qui demande à l'utilisateur de saisir un nombre décimal.
Le programme doit renvoyer exactement le nombre de billets et de pièces qu'il faut pour obtenir ce
nombre
	 */
	public static void exo11() {
		double nb=Tools.inputFloat("Tapez un nombre décimal : ");
		decouperSomme(nb,500,200,100,50,20,10,5,2,1,0.5,0.2,0.1,0.05,0.02,0.01);	
	}
	
	/**
	 * decoupe la somme avec les coupures désignées en param
	 * @param somme
	 * @param valeursBilletsOuPieces
	 */
	public static void decouperSomme(double somme,double...valeursBilletsOuPieces) {
		double nb;
		nb=somme;
		for (double valCourante : valeursBilletsOuPieces) {
			nb=afficheNbBilletsOuPiece(nb,valCourante);
		}
	}
	
	/**
	 * affiche le nombre de billets ou pièces nécéssaires
	 * @param nb la somme 
	 * @param valeurBilletOuPiece valeur du billet ou pièce
	 * @return le reste
	 */
	public static double afficheNbBilletsOuPiece(double nb,double valeurBilletOuPiece) {
		int nbBillets=calculerNombreDeBilletsOuPiece(nb, valeurBilletOuPiece);
		System.out.println("Billets de "+valeurBilletOuPiece+"€ : "+nbBillets);
		double resultat= nb-valeurBilletOuPiece*nbBillets;
		resultat=Math.round(resultat*100d)*0.01d;
		return resultat;
	}
	
	/**
	 * 
	 * @param somme la somme
	 * @param valeurBilletOuPiece valeur du billet ou picec
	 * @return nb de billets ou pièce de la valeur en paramétres nécessaire
	 */
	public static int calculerNombreDeBilletsOuPiece(double somme,double valeurBilletOuPiece) {
		double resultat=somme/valeurBilletOuPiece;
		int valeurEntiere=(int) resultat;
		return valeurEntiere;
	}
	
	/**
	 * Vous disposez d'une liste de températures (
C).
Parcourez cette liste et affichez la température la plus proche de 0
C.
Si une température négative est aussi proche de 0 qu'une température positive, la valeur négative
prend le dessus.
	 */
	public static void exo12() {
		ArrayList<Integer> listeTemp=new ArrayList<Integer>();
		listeTemp.add(50);
		listeTemp.add(-3);
		listeTemp.add(8000);
		listeTemp.add(1);
		listeTemp.add(-1);
		listeTemp.add(3);
		
		int resultat = trouverPlusProcheDeZero(listeTemp);
		
		System.out.println(listeTemp.toString()+" : "+resultat);
	}
	
	/**
	 * Trouve la valeur la plus proche de 0, si une valeur positive et négative le sont, la négative l'emporte
	 * @param maListe la liste à regarder
	 * @return le plus proche de 0
	 */
	public static int trouverPlusProcheDeZero(ArrayList<Integer> maListe) {
		int res;
		int PlusPetiteDifference=Tools.calculerDifference(0, maListe.get(0));
		int plusProche=maListe.get(0);

		for (int element : maListe) {
			res=Tools.calculerDifference(0,element);
			if (res<PlusPetiteDifference) {
				PlusPetiteDifference=res;
				plusProche=element;
			} else if (res==PlusPetiteDifference) {
				if ((plusProche>0) &&(element<=0)) {
					plusProche=element;
				}
			}
		}
		
		return plusProche;
	}
	
	public static void exo13() {
		ArrayList<Integer> listeTemp=new ArrayList<Integer>();
		listeTemp.add(50);
		listeTemp.add(-3);
		listeTemp.add(8000);
		listeTemp.add(1);
		listeTemp.add(-1);
		listeTemp.add(3);
		
		trierListe(listeTemp);
	}
	
	/**
	 * Tri liste et l'affiche dans la console
	 * @param maListe la liste à trier
	 */
	public static void trierListe(ArrayList<Integer> maListe) {
		ArrayList<Integer> maListeResultat=new ArrayList<Integer>();
		int indexplusPetit=-1;
		int tailleListe=maListe.size();
		while (maListeResultat.size()!=tailleListe) {
			indexplusPetit=trouverIndexDuPlusPetit(maListe);
			maListeResultat.add(maListe.get(indexplusPetit));
			maListe.remove(indexplusPetit);
		}
		
		System.out.println(maListeResultat.toString());
	}
	
	/**
	 * trouve l'index du nombre le plus petit
	 * @param maListe la liste à regarder 
	 * @return l'index du plus petit élément de la liste
	 */
	public static int trouverIndexDuPlusPetit(ArrayList<Integer> maListe) {
		int plusPetit=maListe.get(0);
		int indexPlusPetit=0;
		for (int i=0;i<maListe.size();i++) {
			if (maListe.get(i)<=plusPetit) {
				plusPetit=maListe.get(i);
				indexPlusPetit=i;			
			}
		}
		return indexPlusPetit;
	}
}

