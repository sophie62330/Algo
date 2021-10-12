package intro;

import intro.Tools;

public class FizzBuzz {
	/**
	 * permet de savoir si un nombre est un multiple de 3 (=Fizz)
	 * @param nb le nombre à tester
	 * @return vrai si c'est un fizz, false sinon
	 */
	public static boolean estUnFizz(int nb) {
		return Tools.estUnMultipleDe(nb, 3);
	}
	
	/**
	 * permet de savoir si un nombre est un multiple de 5 (=buzz)
	 * @param nb le nombre à tester
	 * @return vrai si c'est un buzz, false sinon
	 */
	public static boolean estUnBuzz(int nb) {
		return Tools.estUnMultipleDe(nb, 5);
	}
	
	/**
	 * permet de savoir si un nombre est un multiple de 3 et de 5 (=fizzbuzz)
	 * @param nb le nombre à tester
	 * @return vrai si c'est un fizzbuzz, false sinon
	 */
	public static boolean estUnFizzBuzz(int nb) {
		return ((estUnFizz(nb)) && (estUnBuzz(nb)));
	}
	
	/**
	 * affiche fizz, buzz, fizzbuzz ou le nombre suivant la nature de nb
	 * @param nb
	 */
	public static void afficherFizzBuzzOuNombre(int nb) {
		if (estUnFizzBuzz(nb)) {
			System.out.println("FIZZBUZZ");
		} else if (estUnBuzz(nb)) {
			System.out.println("BUZZ");
		} else if (estUnFizz(nb)) {
			System.out.println("FIZZ");	
		} else {
			System.out.println(nb);
		}
	}
	
	/**
	 * Lance une partie de FizzBuzz
	 */
	public static void jouerAuFizzBuzz(){
		int nb = Tools.inputInt("Tapez un nombre : ");
		int i=0;
		
		while (i<=nb) {
			afficherFizzBuzzOuNombre(i);
			i++;
		}
	}
}
