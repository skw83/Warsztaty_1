package Zgadywanka;

import java.util.Random;
import java.util.Scanner;

public class Main4a {
	
	public static void main(String[] args) {

		System.out.println(flexyCube());

	}
	
	static String flexyCube(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("POMOC:");
		System.out.println("Symulator rzutu kostki, podaj parametry kostek, liczbę rzutów oraz opcjonalnie ofset");
		System.out.println("xDy+z");
		System.out.println("Gdzie: ");
		System.out.println("x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),");
		System.out.println("y – rodzaj kostek, których należy użyć (np. D6, D10),");
		System.out.println("z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.");
		System.out.println("Typy kostek występujące w grach: D3, D4, D6, D8, D10, D12, D20, D100");
		
		String qube = scan.nextLine();
		scan.close();
		qube.trim();

		String offset = "";
		
		int OffsetNum = 0;
		int occurD = appearanceOfMark(qube, 'D');
		int occurPlus = appearanceOfMark(qube, '+');
		int occurMinus = appearanceOfMark(qube, '-');
		int occurOffset = 0;
		
		if(occurPlus > 0){
			offset = qube.substring(occurPlus, qube.length());
			OffsetNum = Integer.parseInt(offset);
			occurOffset = occurPlus;
		}else if(occurMinus > 0){
			offset = qube.substring(occurMinus, qube.length());
			OffsetNum = Integer.parseInt(offset);
			occurOffset = occurMinus;
		}else {
			occurOffset = 0;
		}
		
		Random r = new Random();
		String wynik = "";
		int temp = 0;
		int numOfDraws = kindOfCube(qube, occurD, occurOffset)-1;
		for(int i = 1; i <= numberofThrows(qube, occurD); i++){
			temp = (r.nextInt(numOfDraws)) + 1;
			wynik += "Rzut nr: " + i + " " + temp + " Offset = " + OffsetNum + " = " + (temp + OffsetNum) + "\n";
		}	
		return wynik;
	}
	
	public static int appearanceOfMark(String qube, char mark){
		char markFromWords;
		int occur = 0;
		int numberOfOccur = 0;
		for(int i = 0; i < qube.length(); i++){
			markFromWords = qube.charAt(i);
			if(markFromWords == mark){
				occur = i;
				numberOfOccur += 1;
			}
			if(numberOfOccur == 1){
				return occur;
			}else if(numberOfOccur > 1){
				return -1;
			}
		}
		return 0;
	}
	
	public static int numberofThrows(String qube, int d){
		String numberTemp = "";
		for(int i = 0; i < d; i++){
			numberTemp += qube.charAt(i);
		}
		if(numberTemp == ""){
			return 1;
		}
		return Integer.parseInt(numberTemp);
	}
	
	public static int kindOfCube(String qube, int d, int occurOffset){
		String numberOfWalls = "";
		if(occurOffset > 0){
			numberOfWalls += qube.substring(d+1, occurOffset);
		}else{
			numberOfWalls += qube.substring(d+1, qube.length());
		}
		return Integer.parseInt(numberOfWalls);
	}

}


/* Kod takiej kostki wygląda następująco:
xDy+z
gdzie:
y – rodzaj kostek, których należy użyć (np. D6, D10),
x – liczba rzutów kośćmi (jeśli rzucamy raz, ten parametr jest pomijalny),
z – (opcjonalnie) liczba, którą należy dodać (lub odjąć) do wyniku rzutów.
Przykłady:
2D10+10 – 2 rzuty D10, do wyniku dodaj 10,
D6 – zwykły rzut kostką sześcienną,
2D3 – rzut dwiema kostkami trójściennymi,
D12-1 – rzut kością D12, od wyniku odejmij 1. */


