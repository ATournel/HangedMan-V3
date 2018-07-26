import java.util.Arrays;
import java.util.Scanner;

public class Game2 {
	int essais =10;
//Transfert du mot en tableau
	
	char[] motVersTab(String s) {
		char[] motATrouver = new char[s.length()];
		
		for(int i=0; i<=s.length()-1; i++) {
			motATrouver[i] = s.charAt(i);
		}
		//System.out.println(Arrays.toString(motATrouver));
		return motATrouver;
	}
//Affichage du mot en fonction du tableau de booleans

	void afficher(char[] motAffiche, boolean[] test, char[] motATrouver) {

		for(int i=0; i<=motAffiche.length-1; i++) {
			if(test[i] == false) {
				motAffiche[i] = '?';
			}
			else {
				motAffiche[i] = motATrouver[i];
			}
		}//System.out.println(Arrays.toString(test));
	}
//Mise à jour du tableau de booleans	
	
	boolean[] metAJour(char[] motATrouver, boolean[] test, char c) {
		
		for(int i=0; i<=motATrouver.length-1; i++) {
			if(motATrouver[i] == c) {
				test[i] = true;
			}
				
		}
		
		return test;
	}
	
//Mise à jour nb d'essais
	
	int checkEssais(char[] motATrouver, char[] motAffiche) {
		
		if(motATrouver != motAffiche) {
			essais -= 1;
		}
		
		return essais;
	}
	
//Fin de partie
	boolean partieFinie(boolean[] test, char[] motATrouver) {
		boolean lastTest = false;
		for(int i=0; i<=motATrouver.length-1; i++) {

			if(test[i]==false) {
				lastTest=false;
				break;
			}else {
				lastTest=true;
			}
		}

		return lastTest;
	}
	
//lancer partie
	
	void partie(String s) {
		Scanner scan = new Scanner(System.in);
		
		motVersTab(s);
		char[] motATrouver = motVersTab(s);
		char[] motAffiche = new char[s.length()];
		boolean[] test = new boolean[s.length()];
		boolean lastTest = false;
		do {
			System.out.println("Choisissez une lettre:");
			char c = scan.nextLine().charAt(0);
			metAJour(motATrouver, test, c);
			afficher(motAffiche, test, motATrouver);
			checkEssais(motATrouver, motAffiche);
			System.out.println("Il vous reste " + essais + " essais.");
			System.out.println(String.valueOf(motAffiche));
			partieFinie(test, motATrouver);
			lastTest=partieFinie(test, motATrouver);
		}while( essais>0 && lastTest==false);
		
		System.out.print("Partie terminée, vous avez ");
		if(essais<1) {
			System.out.print("perdu!");
		}else {
			System.out.print("gagné!");
		}
	}
}
