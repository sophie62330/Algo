package intro;

import java.util.ArrayList;
import java.util.List;

public class Roulette {
	/**
	 * Lance une partie de roulette
	 */
	public static void jouerALaRoulette() {
		double cagnotte=Tools.inputInt("De quelle somme disposez-vous ?");
		
		while (cagnotte>0) {
			int choixTypeJeu=Tools.inputInt(choixTypeJeu());
			int mise=Tools.inputInt("Quelle mise voulez vous jouer ?");
			if (mise>cagnotte) {
				System.out.println("Vous êtes exclu du casino en raison de la détection d'une escroquerie ! Au revoir.");
				break;
			}
			
			switch (choixTypeJeu) {
				case 1 : cagnotte+=jouerPlein(mise);break;
				case 2 : cagnotte+=jouerTransversale(mise);break;
				case 3 : cagnotte+=jouerCheval(mise);break;
				case 4 : cagnotte+=jouerSixain(mise);break;
				case 5 : cagnotte+=jouerCarre(mise);break;
				case 6 : cagnotte+=jouerDouzaine(mise);break;
				case 7 : cagnotte+=jouerDouzaineACheval(mise);break;
				case 8 : cagnotte+=jouerColonne(mise);break;
				case 9 : cagnotte+=jouerColonneACheval(mise);break;
			}
			
			System.out.println("Cagnotte : "+cagnotte);
		}
	}
		
	/**
	 * pour savoir si le numéro en param est dans la liste
	 * @param listeNumeros la liste de integer
	 * @param numero le numero a regarder
	 * @return true s'il y est , faux sinon
	 */
	public static boolean leNumeroEstDansLaListe(List<String> listeNumeros,int numero) {
		return listeNumeros.indexOf(String.valueOf(numero))!=-1;
	}
	
	/**
	 * tourne la roulette
	 * @return le numéro qui est sorti
	 */
	public static int tournerRoulette() {
		Tools.inputString("Appuyez sur n'importe quoi puis entrée pour tourner la roulette !");
		int res= Tools.randomint(36);
		System.out.println("La roulette s'est arrêtée sur le numéro "+res+" ! ");
		return res;
	}
	
	/**
	 * afichage du menu du type de mise
	 * @return le menu
	 */
	public static String choixTypeJeu() {
		return "Faites votre choix :\n1 - PLEIN\n2 - TRANSVERSALE\n3 - CHEVAL\n4 - SIXAIN\n5 - CARRE\n6 - DOUZAINE\n"+
	"7 - DOUZAINE A CHEVAL\n8 - COLONNE\n9 - COLONNE A CHEVAL";
	}
	
	/**
	 * pour savoir si on a gagné et combien (nb négatif si perdu, positif sinon
	 * @param listeNumerosJoues la liste des numéros joués
	 * @param numeroRoulette le numéro sorti
	 * @param mise la mise jouée
	 * @param coefficientGain le coefficient multiplicateur de mise en cas de gain
	 * @return la somme gagnée ou perdue (négatif si perte, positif sigain)
	 */
	public static double gainOuPerte(List<Integer> listeNumerosJoues,int numeroRoulette,int mise,double coefficientGain) {
		double gainOuPerte=0;
		if (listeNumerosJoues.indexOf(numeroRoulette)!=-1) {
			gainOuPerte=coefficientGain*mise;
			System.out.println("Bravo ! Vous avez gagné "+gainOuPerte+"€");
		} else {
			gainOuPerte=-mise;
			System.out.println("Perdu ! ");
		}
		
		return gainOuPerte;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    COLONNE A CHEVAL   //////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * joue une mise sur colonne cheval
	 * @param mise mise engagée
	 * @return le gain ou la perte suite à la mise
	 */
	public static double jouerColonneACheval(int mise) {
		String question="Choisissez 2 colonnes :\n1 : [1...34]+[2...35]\n2 : [1...34]+[3...36]\n3 : [2...35]+[3...36]";
		String reponse=Tools.inputString(question);
		int numeroRoulette=tournerRoulette();
		List<Integer> listeNumerosJoues=getListeNumerosColonneACheval(reponse);
		return gainOuPerte(listeNumerosJoues, numeroRoulette, mise, 0.5);
	}
	
	/**
	 * suivant la réponse de l'utilisateur , renvoie la liste des numéros joués
	 * @param reponse 1 (1ére et 2éme colonne), 2 (1ere et 3eme) ou 3 (2eme et 3eme)
	 * @return la liste des numéros joués
	 */
	public static List<Integer> getListeNumerosColonneACheval(String reponse) {
		List<Integer> liste=new ArrayList<Integer>();
		if (reponse.equals("1")) {
			liste.addAll(getListeNumerosColonne("1"));
			liste.addAll(getListeNumerosColonne("2"));
		} else if (reponse.equals("2")) {
			liste.addAll(getListeNumerosColonne("1"));
			liste.addAll(getListeNumerosColonne("3"));
		} else if (reponse.equals("3")) {
			liste.addAll(getListeNumerosColonne("2"));
			liste.addAll(getListeNumerosColonne("3"));
		}
		
		return liste;		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    COLONNE    //////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * pemret de jouer sur colonne
	 * @param mise la mise engagée
	 * @return le gain ou la perte
	 */
	public static double jouerColonne(int mise) {
		String question="Choisissez une colonne :\n1 : [1,4,7,10,13,16,19,22,25,28,31,34]\n"+
						"2 : [2,5,8,11,14,17,20,23,26,29,32,35]\n3 : [3,6,9,12,15,18,21,24,27,30,33,36]";
		String reponse=Tools.inputString(question);
		int numeroRoulette=tournerRoulette();
		List<Integer> listeNumerosJoues=getListeNumerosColonne(reponse);
		return gainOuPerte(listeNumerosJoues, numeroRoulette, mise, 2);
	}
	
	/**
	 * indique la liste des numéros joués en fonction de la réponse de l'utilisateur
	 * @param reponse 1 : 1ere colonne choisie - 2 : 2éme - 3 : 3éme
	 * @return la liste des numéros joués
	 */
	public static List<Integer> getListeNumerosColonne(String reponse){
		List<Integer> liste=new ArrayList<Integer>();
		int i =Integer.valueOf(reponse);
		while (i<=36) {
			liste.add(i);
			i+=3;
		}
		
		return liste;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    DOUZAINE A CHEVAL    //////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * permet de jouer une douzaine cheval
	 * @param mise la mise engagée
	 * @return gain ou perte suite a cette mise
	 */
	public static double jouerDouzaineACheval(int mise) {
		String question="Choisissez un couplé de 2 douzaines :\n1 : [12P-12M]\n2 : [12P-12D]\n3 : [12M-12D]";
		String reponse=Tools.inputString(question);
		List<Integer> listeNumerosJoues=getListeNumerosDouzaineACheval(reponse);
		int numRoulette=tournerRoulette();
		return gainOuPerte(listeNumerosJoues,numRoulette,mise,0.5);
	}
	
	/**
	 * retourne la liste des numéros joués en fonction de la réponse utilisateur
	 * @param reponse 1 2 ou 3 (1=1..24 - 2=1..12+25..36 - 3=16..36
	 * @return la liste des numéros joués
	 */
	public static List<Integer> getListeNumerosDouzaineACheval(String reponse){
		int i;
		List<Integer> liste = new ArrayList<Integer>();
		if (reponse.equals("1")) {
			for (i=1;i<=24;i++) {
				liste.add(i);
			}
		} else if (reponse.equals("2")) {
			for (i=1;i<=12;i++) {
				liste.add(i);
			}	
			for (i=25;i<=36;i++) {
				liste.add(i);
			}
		} else if (reponse.equals("3")) {
			for (i=13;i<=36;i++) {
				liste.add(i);
			}
		}
		
		return liste;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    DOUZAINE    ///////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * permet de jouer une douazine
	 * @param mise la mise engagée
	 * @return gain ou perte suite a cette mise sur la douezaine
	 */
	public static double jouerDouzaine(int mise) {
		String reponse=Tools.inputString("Que voulez vous jouer ? 12P , 12M ou 12D ? Tapez votre réponse et appuyez sur entrée.");
		List<Integer> listeNumerosJoues=getListeNumerosDouzaine(reponse);
		int numRoulette=tournerRoulette();
		return gainOuPerte(listeNumerosJoues, numRoulette, mise,2);
	}
	
	/**
	 * donne la liste des numéros joués en fonction de la reponse utilisareur
	 * @param reponse (12P=1...12 - 12P=13-24 - 12D : 25-36)
	 * @return la liste des numéros joués
	 */
	public static List<Integer> getListeNumerosDouzaine(String reponse) {
		List<Integer> liste=new ArrayList<Integer>();
		int i;
		if (reponse.equals("12P")) { //1 à 12
			liste=getListeDouzaine12P();
		} else if (reponse.equals("12M")) {
			liste=getListeDouzaine12M();
		} else if (reponse.equals("12D")) {
			liste=getListeDouzaine12D();
		}
		
		return liste;
	}
	
	/**
	 * retourne la liste des 12 premiers éléments
	 * @return liste de 1..12
	 */
	public static List<Integer> getListeDouzaine12P(){
		List<Integer> liste=new ArrayList<Integer>();
		for (int i=1;i<=12;i++) {
			liste.add(i);
		}
		return liste;
	}
	
	/**
	 * retourne la deuxiéme douzaine
	 * @return 13--24
	 */
	public static List<Integer> getListeDouzaine12M(){
		List<Integer> liste=new ArrayList<Integer>();
		for (int i=13;i<=24;i++) {
			liste.add(i);
		}
		return liste;
	}
	
	/**
	 * retourne la 3eme douzaine
	 * @return 25--36
	 */
	public static List<Integer> getListeDouzaine12D(){
		List<Integer> liste=new ArrayList<Integer>();
		for (int i=25;i<=36;i++) {
			liste.add(i);
		}
		return liste;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    CARRE    ///////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * joue une mise sur le carré
	 * @param mise la mise engagée
	 * @return gain ou perte
	 */
	public static double jouerCarre(int mise) {
		String numCarre=Tools.inputString(getQuestionCarre());
		List<Integer> listeNumerosJoues=getListeNumeroCarre(Integer.valueOf(numCarre));
		int numRoulette=tournerRoulette();
		return gainOuPerte(listeNumerosJoues, numRoulette, mise,8);
	}
	
	/**
	 * donne la liste des numéros joués en carré
	 * @param numCarre le numéro du carré 
	 * @return la liste des numéros
	 */
	public static List<Integer> getListeNumeroCarre(int numCarre){
		List<Integer> liste=new ArrayList<Integer>();
		int debutCarre;
		//si le numcarre est un nombre impair, ça correspond au carre qui commence par (numcarre-1)/2+numcarre
		if (numCarre%2==1) {
			debutCarre=(numCarre-1)/2+numCarre;
		} else {
			debutCarre=(numCarre-2)/2+numCarre;
		}
		
		liste.add(debutCarre);
		liste.add(debutCarre+1);
		liste.add(debutCarre+3);
		liste.add(debutCarre+4);
		
		return liste;
	}
	
	/**
	 * Pour avoir la question quand le carré est choisi
	 * @return la question
	 */
	public static String getQuestionCarre() {
		String res="Sur quel carré voulez-vous miser ?\n";
		int i=1;
		int compteur=1;
		while (i<33) {
			if (i%3!=0) {
				res=res+compteur+" : ["+i+","+(i+1)+","+(i+3)+","+(i+4)+"]\n";
				compteur++;
			}
			i++;
		}
		
		return res;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    SIXAIN    //////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * question sixtain
	 * @return la question
	 */
	public static String getQuestionSixain() {
		String res="Sur quelle sixain voulez vous miser ?\n";
		int i = 1;		
		int cpt=1;
		while (i<35) {
			res=res+cpt+" : ["+i+","+(i+1)+","+(i+2)+","+(i+3)+","+(i+4)+","+(i+5)+"]\n";
			i+=3;
			cpt++;
		}
		return res;
	}
	
	/**
	 * permet de jouer un tour de sixain
	 * @param mise la mise engagée
	 * @return gain ou perte
	 */
	public static double jouerSixain(int mise) {
		String numSixain=Tools.inputString(getQuestionSixain());
		List<Integer> listeNumerosJoues=getListeNumeroSixain(Integer.valueOf(numSixain));
		int numRoulette=tournerRoulette();
		return gainOuPerte(listeNumerosJoues, numRoulette, mise,5);
	}
	
	/**
	 * donne la liste des numéros joués en sixain
	 * @param numSixain le numéro du sixain dans a numérotation du menu
	 * @return la liste des numéros joués
	 */
	public static List<Integer> getListeNumeroSixain(int numSixain){
		//a un numsixain correspond le sixain qui commence par 2*(numsixain-1)+sixain
		List<Integer> liste=new ArrayList<Integer>();
		int debutSixain=2*(numSixain-1)+numSixain;
		int i=0;
		while (i<=5) {
			liste.add(debutSixain+i);
			i++;
		}
		return liste;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    CHEVAL     /////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * permet de jouer cheval
	 * @param mise la mise engagée
	 * @return gain ou perte
	 */
	public static double jouerCheval(int mise) {
		List<Integer> listeNumerosJoues=new ArrayList<Integer>();
		int num1=Tools.inputInt("Entrez un premier numéro sur lequel vous voulez jouer.");
		listeNumerosJoues.add(num1);
		listeNumerosJoues.add(getDeuxiemeNumeroCheval(num1));
		int numeroRoulette=tournerRoulette();		

		return gainOuPerte(listeNumerosJoues, numeroRoulette,mise,17);
	}

	/**
	 * demande le numéro du deuxiéme cheval en fonction du premier
	 * @param numero le numéro du premier
	 * @return le numéro du deuxiém
	 */
	public static int getDeuxiemeNumeroCheval(int numero) {
		List<Integer> listeCorrespondances=getCorrespondancesCheval(numero);
		int num2=-1;
		while (listeCorrespondances.indexOf(num2)==-1) {
			num2=Tools.inputInt("Entrez le deuxième numéro parmi "+listeCorrespondances.toString());
		}	
		return num2;
	}
	
	/**
	 * donne les numéros adjacents au numéro en paramétre
	 * @param numero numéro de référence
	 * @return les numéros qui sont a coté (horizontal et vertical pas diagnonale)
	 */
	public static List<Integer> getCorrespondancesCheval(int numero){
		List<Integer> listeCorrespondances=new ArrayList<Integer>();
		
		//un multiple de 3 ne peut pas étre associé au nombre qui lui succède
		if (numero%3!=0) 
			listeCorrespondances.add(numero+1);
		
		if (numero%3!=1) 
			listeCorrespondances.add(numero-1);
		
		if (numero<=33) 
			listeCorrespondances.add(numero+3);
		
		if (numero>=4)
			listeCorrespondances.add(numero-3);
		
		return listeCorrespondances;
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////    TRANSVERSALE    ////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * permet de poser question transversale
	 * @param listeChoixTransversale liste des possibilités opur ce jeu
	 * @return la question
	 */
	public static String getQuestionTransversale(List<String> listeChoixTransversale) {
		String res="Sur quelle tranche voulez vous miser ? \n";
		
		for (int i=1;i<=listeChoixTransversale.size();i++) {
			res+=i+" : ("+listeChoixTransversale.get(i-1)+")\n";
		}
		
		return res;
	}
	
	/**
	 * donne les possivilités du jeu transversale
	 * @return la liste des jeu
	 */
	public static List<String> getListeChoixPossiblesTransversale() {
		int i = 1;
		List<String> listeChoixTransversale=new ArrayList<String>();
		while (i<=34) {
			listeChoixTransversale.add(i+"-"+(i+1)+"-"+(i+2));
			i=i+3;
		}
		
		return listeChoixTransversale;
	}
	
	/**
	 * permet de jouer en transversale
	 * @param mise la mise engagée
	 * @return gain ou perte
	 */
	public static int jouerTransversale(int mise) {
		List<String> listeChoix=getListeChoixPossiblesTransversale();

		int gainOuPerte=0;
		String question=getQuestionTransversale(listeChoix);
		int choixRangee=Tools.inputInt(question); //le choix de la rangée correspond a l'élément de la liste à l'index choixrangee-1
		int numeroRoulette=tournerRoulette();
		if (leNumeroEstDansLaListe(getListeElementCorrespondantARangee(choixRangee, listeChoix), numeroRoulette)) {
			gainOuPerte=11*mise;
			System.out.println("Bravo ! Vous gagnez "+(11*mise)+"€ !!!");
		} else {
			gainOuPerte=-mise;
			System.out.println("Perdu !");
		}
		
		return gainOuPerte;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////     PLEIN     ///////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * permet de jouer plein
	 * @param mise la mise engagée
	 * @return gain ou perte
	 */
	public static int jouerPlein(int mise) {
		int gainOuPerte=0;
		int numero=Tools.inputInt("Sur quel numéro voulez vous jouer ?");
		int numeroRoulette=tournerRoulette();		
		
		if (numero==numeroRoulette) {
			gainOuPerte=35*mise;
		} else {
			gainOuPerte=-mise;
		}
		System.out.println("gain ou perte : "+gainOuPerte);
		return gainOuPerte;
	}
	
	/**
	 * donne la liste des éléments qui correspondent  a a rangée choisie
	 * @param rangee numéro de rangée
	 * @param listeChoix la liste de choix
	 * @return la liste des éléments joués
	 */
	public static List<String> getListeElementCorrespondantARangee(int rangee,List<String> listeChoix) {
		List<String> listeNumerosJoues=new ArrayList<String>();
		String elementListe=listeChoix.get(rangee-1); //3 numéros séparés par des -
		int i=1;
		while (i<=3) {
			listeNumerosJoues.add(Tools.getValeur(elementListe,i,"-"));
			i++;
		}
		System.out.println("liste numéros joués : "+listeNumerosJoues.toString());
		return listeNumerosJoues;
	}
}
