package intro;

import java.util.ArrayList;
import java.util.List;

public class Cesar {
	/**
	 * Crypte le message tapé par l'utilisateur suivant une clé de chiffrage (ex : 
	 * "Bonjour tout le monde | clé=3  donne Cpokpvs upvu mfnpoef
	 */
	public static void crypter() {
		String chaine=Tools.inputStringAvecEspaces("Saisissez le mot à crypter : ");
		int cleChiffrage=Tools.inputInt("Saisissez une clé de chiffrage : ");
		
		afficheMessageIntro(chaine, cleChiffrage);
		
		System.out.println("-> "+crypterChaine(chaine,cleChiffrage));
	}
	
	/**
	 * affiche le message d'intro 
	 * @param chaine chaine entrée par user, à crypter
	 * @param cleChiffrage clé chiffrage entrée par user
	 */
	public static void afficheMessageIntro(String chaine,int cleChiffrage) {
		System.out.println("message = \""+chaine+"\" | cle = "+cleChiffrage);
	}
	
	/**
	 * Crypte la chain
	 * @param chaine chaine  a crypter
	 * @param cleChiffrage clé de chiffrage 
	 * @return message crypté
	 */
	public static String crypterChaine(String chaine,int cleChiffrage) {
		List<Integer> listeIndexMinuscule=getIndexDesLettresEnMinuscule(chaine);
		chaine=chaine.toUpperCase();
		String chaineCrypteeMaj=crypterMajEnMaj(chaine,cleChiffrage);
		return mettreEnMinLettresDesIndexEnParam(chaineCrypteeMaj, listeIndexMinuscule);
	}
	
	/**
	 * Crypte message en majuscule en majuscule car je ne dispose que d'un alphabet en maj
	 * @param chaine chaine à crypter
	 * @param cleChiffrage la clé de chiffrage
	 * @return
	 */
	public static String crypterMajEnMaj(String chaine,int cleChiffrage) {
		int index=-1;
		String chaineCryptee="";
		String caractere="";
		
		ArrayList<String> alphabet=construireAlphabet();
		ArrayList<String> alphabetCrypte=crypterAlphabet(alphabet,cleChiffrage);
		
		for (int i=0;i<=chaine.length()-1;i++) {
			caractere="";
			caractere=caractere+chaine.charAt(i);
			if (caractere.equals(" ")) {
				chaineCryptee=chaineCryptee+" ";
			} else {
				index=alphabet.indexOf(caractere);
				chaineCryptee=chaineCryptee+alphabetCrypte.get(index);
			}
		}
		
		return chaineCryptee;
	}
	
	/**
	 * Crypte alphabet entier suivant clé de chiffrage
	 * @param alphabet alphabet en majuscule
	 * @param cleChiffrage clé chiffrage a utiliser
	 * @return une liste correspondant a l'alphabet crypté suivant clé de chiffrage
	 */
	public static ArrayList<String> crypterAlphabet(ArrayList<String> alphabet,int cleChiffrage){
		String premiereValDeListe;
		ArrayList<String> alphabetCrypte=(ArrayList<String>) alphabet.clone();
		int i=1;
		while (i<=cleChiffrage) {
			premiereValDeListe=alphabetCrypte.get(0);
			alphabetCrypte.remove(0);
			alphabetCrypte.add(premiereValDeListe);
			i++;
		}
		return alphabetCrypte;
	}
	
	/**
	 * construction de l'alphabet
	 * @return l'alphabet
	 */
	public static ArrayList<String> construireAlphabet(){
		ArrayList<String> alphabet= new ArrayList<String>();
		alphabet.add("A");
		alphabet.add("B");
		alphabet.add("C");
		alphabet.add("D");
		alphabet.add("E");
		alphabet.add("F");
		alphabet.add("G");
		alphabet.add("H");
		alphabet.add("I");
		alphabet.add("J");
		alphabet.add("K");
		alphabet.add("L");
		alphabet.add("M");
		alphabet.add("N");
		alphabet.add("O");
		alphabet.add("P");
		alphabet.add("Q");
		alphabet.add("R");
		alphabet.add("S");
		alphabet.add("T");
		alphabet.add("U");
		alphabet.add("V");
		alphabet.add("W");
		alphabet.add("X");
		alphabet.add("Y");
		alphabet.add("Z");
		
		return alphabet;
	}
	
	/**
	 * permet de mettre dans une liste tous les index des lettres en minuscule d'une chaine
	 * @param chaine la chaine a utiliser
	 * @return liste des index des lettres en minuscule
	 */
	public static List<Integer> getIndexDesLettresEnMinuscule(String chaine){
		List<Integer> listeIndex=new ArrayList<Integer>();
		for (int i=0;i<=chaine.length()-1;i++) {
			if (Character.isLowerCase(chaine.charAt(i))) {
				listeIndex.add(i);
			}
		}
		return listeIndex;
	}
	
	/**
	 * remet en minuscule les lettres aux index indiqués dans la liste
	 * @param chaine la chaine a modifier
	 * @param listeIndex les index a mettre en minuscule
	 * @return la chaine avec ses maj et ses min
	 */
	public static String mettreEnMinLettresDesIndexEnParam(String chaine,List<Integer> listeIndex) {
		for (int i=0;i<=listeIndex.size()-1;i++) {
			if (i!=chaine.length()-1) {
				chaine=chaine.substring(0, listeIndex.get(i))+chaine.substring(listeIndex.get(i),listeIndex.get(i)+1).toLowerCase()+chaine.substring(listeIndex.get(i)+1);
			} else {
				chaine=chaine.substring(0, listeIndex.get(i))+chaine.substring(listeIndex.get(i),listeIndex.get(i)+1).toLowerCase();
			}
		}
		return chaine;
	}
}
