import java.util.Arrays;
import java.util.Scanner;

public class Game {

		
	private Scanner scan = new Scanner(System.in);
	
	char[] motAffiche;
	boolean[] test;

//Transfert du mot en tableau
	
	char[] motVersTab(String mot) {
		
		char[] motATrouver = mot.toCharArray();
		System.out.println(String.valueOf(motATrouver));
		
		return motATrouver;
	}
	
	
	
//Affichage du mot en fonction du tableau de booleans
	
	void afficher(char[] motAffiche, boolean[] test, char c) {

		for(int i=0; i<=motAffiche.length-1; i++) {
			if(test[i] == false) {
				motAffiche[i] = '?';
			}
			else {
				motAffiche[i] = c;
			}
		}
		
		//System.out.println(String.valueOf(motAffiche));
		
	}
	
//Mise à jour du tableau de booleans
	
	boolean[] metAJour(char[] motATrouver, boolean[] test, char c) {
		
		for(int j=0; j<=motATrouver.length-1; j++) {
			if(motATrouver[j] == c) {
				test[j] = true;
			}System.out.println(Arrays.toString(test));
		}
		return test;
	
	}
	
//Fin de partie
	
	boolean partieFinie(boolean[] test) {
		boolean lastTest = true;
		do {
			for(int k=0; k<=test.length-1; k++) {
				if(test[k] == false) {
					lastTest = false;
				}
			}
		}while(lastTest == true);
		
		
		return lastTest;
	}
	
//Lancer partie
	
	void partie(String mot) {
		
		
		System.out.println("Choisissez une lettre:");
		motVersTab(mot);
//Boucle?
		char c = scan.nextLine().charAt(0);
		char[] motATrouver = motVersTab(mot);
		metAJour(motATrouver, test, c);
		System.out.println(Arrays.toString(test));
		afficher(motAffiche, test, c);
		partieFinie(test);
	}
	
}
