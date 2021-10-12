package intro;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
	/**
	 * Lance une partie de TicTacToe
	 */
	public static void jouerAuTicTacToe() {
		afficherGrilleVide();
		String gagnant="";
		List<String> jeuEnCours=initialiserListe();
		
		while (!morpionFini(jeuEnCours)) {
			jouerUnTour("Joueur1", "O", jeuEnCours);
			
			if (!morpionFini(jeuEnCours)) {
				jouerUnTour("Joueur2", "X", jeuEnCours);
			} else {
				gagnant="Joueur1";
			}
		}
		if (gagnant!="Joueur1") {
			gagnant="Joueur2";
		}
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println("------------------------------------");
		System.out.println(gagnant+" a gagné ! -----------------");
		
	}
	
	/**
	 * Permet de jouer un tour
	 * @param joueur le joueur qui joue
	 * @param typeCase O ou X
	 * @param jeuEnCours la liste du jeu en cours
	 */
	public static void jouerUnTour(String joueur,String typeCase, List<String> jeuEnCours) {
		int caseChoisie=Tools.inputInt(joueur+" : à vous de jouer. Utilisez les touches du clavier numérique pour jouer et appuyez sur entrée.");
		while (laCaseEstDejaPrise(caseChoisie, jeuEnCours)) {
			caseChoisie=Tools.inputInt(joueur+" / Cette case est déjà prise, veuillez en choisir une autre.");
		}
		
		jeuEnCours.set(caseChoisie-1, typeCase);
		afficherGrilleDuJeuEnCours(jeuEnCours);	
	}
	
	/**
	 * Pour savoir si la case est déja prise
	 * @param caseGrille numéro de la case (identique à l'emplacement sur un clavier numérique)
	 * @param jeuEnCours la liste du jeu en cours 
	 * @return vrai si la case est occupée, false sinon
	 */
	public static boolean laCaseEstDejaPrise(int caseGrille,List<String> jeuEnCours) {
		boolean res;
		if ((jeuEnCours.get(caseGrille-1)=="O") || (jeuEnCours.get(caseGrille-1)=="X")) {
			res=true;
		} else {
			res=false;
		}
		
		return res;
	}
	
	/**
	 * affiche la ggrille en cours
	 * @param jeuEnCours la liste modélisant le jeu en cours
	 */
	public static void afficherGrilleDuJeuEnCours(List<String> jeuEnCours) {
		afficherGrille(jeuEnCours.get(0), jeuEnCours.get(1), jeuEnCours.get(2), jeuEnCours.get(3), jeuEnCours.get(4),
				jeuEnCours.get(5), jeuEnCours.get(6), jeuEnCours.get(7), jeuEnCours.get(8));
	}
	
	/**
	 * affiche grille 
	 * @param case1 O  X ou "rien" de la case 1
	 * @param case2 O  X ou "rien" de la case 2
	 * @param case3 O  X ou "rien" de la case 3
	 * @param case4 O  X ou "rien" de la case 4
	 * @param case5 O  X ou "rien" de la case 5
	 * @param case6 O  X ou "rien" de la case 6
	 * @param case7 O  X ou "rien" de la case 7
	 * @param case8 O  X ou "rien" de la case 8
	 * @param case9 O  X ou "rien" de la case 9
	 */
	public static void afficherGrille(String case1,String case2,String case3,
			String case4,String case5,String case6,String case7,String case8,String case9) {
		System.out.println("________________________");
		System.out.println("|       |       |       |");
		System.out.println("|   "+case7+"   |   "+case8+"   |   "+case9+"   |");
		System.out.println("|_______|_______|_______|");
		System.out.println("|       |       |       |");
		System.out.println("|   "+case4+"   |   "+case5+"   |   "+case6+"   |");
		System.out.println("|_______|_______|_______|");
		System.out.println("|       |       |       |");
		System.out.println("|   "+case1+"   |   "+case2+"   |   "+case3+"   |");
		System.out.println("|_______|_______|_______|");
	}
	
	/**
	 * Pour savoir si le jeu est fini
	 * @param jeuEnCours la liste du jeu en cours
	 * @return vrai si le jeu est fini
	 */
	public static boolean morpionFini(List<String> jeuEnCours) {
		boolean result=false;
		
		if ((((jeuEnCours.get(0)=="O") && (jeuEnCours.get(1)=="O") && (jeuEnCours.get(2)=="O"))
		 || ((jeuEnCours.get(3)=="O") && (jeuEnCours.get(4)=="O") && (jeuEnCours.get(5)=="O"))
		 || ((jeuEnCours.get(6)=="O") && (jeuEnCours.get(7)=="O") && (jeuEnCours.get(8)=="O"))
		 || ((jeuEnCours.get(0)=="O") && (jeuEnCours.get(3)=="O") && (jeuEnCours.get(6)=="O"))
		 || ((jeuEnCours.get(1)=="O") && (jeuEnCours.get(4)=="O") && (jeuEnCours.get(7)=="O"))
		 || ((jeuEnCours.get(2)=="O") && (jeuEnCours.get(5)=="O") && (jeuEnCours.get(8)=="O"))
		 || ((jeuEnCours.get(0)=="O") && (jeuEnCours.get(4)=="O") && (jeuEnCours.get(8)=="O"))
		 || ((jeuEnCours.get(2)=="O") && (jeuEnCours.get(4)=="O") && (jeuEnCours.get(6)=="O"))) 
		|| 
		   ((((jeuEnCours.get(0)=="X") && (jeuEnCours.get(1)=="X") && (jeuEnCours.get(2)=="X"))
		 || ((jeuEnCours.get(3)=="X") && (jeuEnCours.get(4)=="X") && (jeuEnCours.get(5)=="X"))
		 || ((jeuEnCours.get(6)=="X") && (jeuEnCours.get(7)=="X") && (jeuEnCours.get(8)=="X"))
		 || ((jeuEnCours.get(0)=="X") && (jeuEnCours.get(3)=="X") && (jeuEnCours.get(6)=="X"))
		 || ((jeuEnCours.get(1)=="X") && (jeuEnCours.get(4)=="X") && (jeuEnCours.get(7)=="X"))
		 || ((jeuEnCours.get(2)=="X") && (jeuEnCours.get(5)=="X") && (jeuEnCours.get(8)=="X"))
		 || ((jeuEnCours.get(0)=="X") && (jeuEnCours.get(4)=="X") && (jeuEnCours.get(8)=="X"))
		 || ((jeuEnCours.get(2)=="X") && (jeuEnCours.get(4)=="X") && (jeuEnCours.get(6)=="X"))
		)))
		
		{
			result=true;
		}
		
		return result;
	}
	
	/**
	 * Crée une liste de 9 éléments vide
	 * @return la liste vide
	 */
	public static List<String> initialiserListe(){
		List<String> liste=new ArrayList<String>();
		int i=1;
		while (i<=9) {
			liste.add(" ");
			i++;
		}	
		return liste;
	}
	
	/**
	 * affichage de la grille vide
	 */
	public static void afficherGrilleVide() {
		afficherGrille(" ", " ", " ", " ", " ", " ", " ", " ", " ");
	}
}
