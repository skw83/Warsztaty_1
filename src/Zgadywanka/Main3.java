package Zgadywanka;

import java.util.Scanner;

public class Main3 {
	
	public static void main(String[] args) {
		
		guessNumbers();

    }
	
	static void guessNumbers(){
		System.out.println("Pomyśl liczbę od zera do 1000");
		System.out.println("postaram się odgadnąć ją w max 10 ruchach");
		
		int min = 0;
		int max = 1000;
		int guess = 0;
		
		Scanner odp = new Scanner(System.in);
		
		for(int i = 0; i <= 9; i++){
			guess = ((max-min)/2) + min;
			System.out.println("Zgaduję :" + guess);
			System.out.println("Czy wyświetlona wartość jest: (za duża), (za mała), a może (zgadłem)?");
			
			String sOdp = odp.nextLine();
			
			if(sOdp.equals("za duża")){
				max = guess;
			}else if(sOdp.equals("za mała")){
				min = guess;
			}else if(sOdp.equals("zgadłem")){
				System.out.println("Wygrałem!!!");
				break;
			}else{
				System.out.println("Oszukujesz");
			}
			System.out.println("iteracja: " + i);
		}
	}

}

/* Problem z maksymalnymi i minimalnymi wartościami - 1 i 1000 */
