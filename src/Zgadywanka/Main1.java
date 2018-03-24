package Zgadywanka;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
	
public static void main(String[] args) {
		
		guessNumber();

    }
    
    public static int guessNumber(){
    	Random generator = new Random();
    	int iNumberForGuess = generator.nextInt(99) +1;			// Wylosowanie liczby z zakresu od 1 - 100 -> dodajemy 1 żeby obejść losowanie od 0
    	System.out.println(iNumberForGuess);
    	
		System.out.println("Zgadnij liczbę :");
		Scanner scan = new Scanner(System.in);
//		int iNumber = scan.nextInt();
		while(!scan.hasNextInt()){
			System.out.println("Podaj liczbę całkowitą");
			scan.next();
		}
		
		int iGuessNumber = scan.nextInt();
		while(iGuessNumber != iNumberForGuess){
			if(iGuessNumber < iNumberForGuess){
				System.out.println("Za mało, podaj jeszcze raz");
			}
			if(iGuessNumber > iNumberForGuess){
				System.out.println("Za dużo, podaj jeszcze raz");
			}
			iGuessNumber = scan.nextInt();
		}
		
		System.out.println("Zgadłeś!!");
		scan.close();

		int iExitNumber = iGuessNumber;
		return iExitNumber ;
	}

}


/* 
Gra w zgadywanie liczb

Napisz prostą grę w zgadywanie liczb. Komputer ma wylosować liczbę w zakresie od 1 do 100. Następnie:

    wypisać: "Zgadnij liczbę" i pobrać liczbę z klawiatury;
    sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat: "To nie jest liczba", po czym wrócić do pkt. 1;
    jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat: "Za mało!", po czym wrócić do pkt. 1;
    jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat: "Za dużo!", po czym wrócić do pkt. 1;
    jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat: "Zgadłeś!", po czym zakończyć działanie programu.

 */