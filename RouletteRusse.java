package intro;

import java.util.ArrayList;
import java.util.List;
import intro.Tools;

public class RouletteRusse {
	public static void jouerALaRouletteRusse() {
		int nbBalles=Tools.inputInt("Combien de balles voulez vous mettre dans le barillet?");
		String joueur1=Tools.inputString("Comment s'appelle le joueur 1?");
		String joueur2=Tools.inputString("Comment s'appelle le joueur 2?");
		String reponse="";
		
		boolean j1estMort=false;
		boolean j2estMort=false;
		
		//initialisation du barillet du joueur 1
		int[] barilletJ1=initialiserBarillet();
		int[] barilletChargeJ1=remplirBarillet(barilletJ1,nbBalles);
		
		System.out.println("Voici ton barillet "+joueur1+" : "+afficherBarillet(barilletChargeJ1));
		
		//initialisation du barillet du joueur 2
		int[] barilletJ2=initialiserBarillet();
		int[] barilletChargeJ2=remplirBarillet(barilletJ2,nbBalles);
		
		System.out.println("Voici ton barillet "+joueur2+" : "+afficherBarillet(barilletChargeJ2));
		
		while ((!j1estMort) && (!j2estMort)) {
			Tools.inputString(joueur1+" : tire en écrivant O et en appuyant sur entrée quand tu es prêt(e) !");
			j1estMort=tirer(barilletChargeJ1);
			
			if (!j1estMort) {
				System.out.println(joueur1 +" a survécu. A toi "+joueur2+" ! ");
				Tools.inputString("A toi "+joueur2+" ! ");
				j2estMort=tirer(barilletChargeJ2);
				if (!j2estMort) {
					System.out.println(joueur2+" a survécu ! A toi "+joueur1+" ! ");
				}
			}
		}
		
		if (j1estMort) {
			System.out.println("RIP "+joueur1+"...");
		} else if (j2estMort) {
			System.out.println("RIP "+joueur2+"...");
		} else {
			System.out.println("Personne n'est mort ! ya un bug dans le programme :D");
		}
			
	}
	
	
	public static boolean tirer(int[] barillet) {
		boolean ilEstMort=false;;
		
		int indexBarilleAleatoire=Tools.randomint(7);
		System.out.println("Position du barillet : "+(indexBarilleAleatoire+1));
		if (barillet[indexBarilleAleatoire]==1) {
			ilEstMort=true;
			System.out.println("Oups !");
		}
		
		return ilEstMort;
	}
	
	public static String afficherBarillet(int[] barillet) {
		return barillet[0]+","+barillet[1]+","+barillet[2]+","+barillet[3]+","+barillet[4]+","+barillet[5]+","+barillet[6]+","+barillet[7];
	}
	
	public static int[] initialiserBarillet() {
		int[] barillet= {0,0,0,0,0,0,0,0};
		return barillet;
	};
	
	public static int[] remplirBarillet(int[] barillet, int nbBalles) {
		int nbBallesPlaceesDansBarillet=0;
		int nb=-1;
		//remplit le barillet
		while (nbBallesPlaceesDansBarillet<nbBalles) {
			nb=Tools.randomint(7);
			while (barillet[nb]==1) {
				nb=Tools.randomint(7);
			}
			System.out.println(nb);
			barillet[nb]=1;
			nbBallesPlaceesDansBarillet=nbBallesPlaceesDansBarillet+1;
		}
		
		return barillet;
	}
}
