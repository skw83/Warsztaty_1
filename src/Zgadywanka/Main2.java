package Zgadywanka;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
	
	public static void main(String[] args) {
		
		System.out.println(lotto());

    }
	
	static String lotto(){
		
		Scanner scan = new Scanner(System.in);
		
		int[] typowaneLiczby = new int[6];

		System.out.println("Podaj liczbę całkowitą z zakresu 1-49");
		for(int i = 0; i < typowaneLiczby.length; i++){
			while(!scan.hasNextInt()){
				System.out.println("Podaj liczbę całkowitą z zakresu 1-49");
				scan.next();
			}
			int iTemp = scan.nextInt();
			int iTemp2 = 0;
			if(iTemp >= 1 && iTemp <= 49 && iTemp != 0){
//				System.out.println("Liczba nr " + i + " z zakresu 1-49 równa = " + iTemp);
				iTemp2 = iTemp;
				boolean powtorzenie = false;
				for(int j = 0; j < i; j++){
					if(typowaneLiczby[j] == iTemp2){
						System.out.println("Podana liczba już wystąpiła podaj ją jeszcze raz!");
						i--;
						powtorzenie = true; 
						break;
					}
				}
				if(!powtorzenie){
					typowaneLiczby[i] = iTemp2;
				}
			}else{
				System.out.println("Podana liczba jest z poza zakresu, podaj jeszcze raz. Licznik i " + i);
				i--;
			}
		}
		scan.close();
		
		int[] losowaneLiczby = new int[6];
		Random r = new Random();
		
		for(int i = 0; i < losowaneLiczby.length; i++){
			int iTemp3 = r.nextInt(48) + 1;
			boolean powtorzenie2 = false;
			for(int j = 0; j < i; j++){
				if(losowaneLiczby[j] == iTemp3){
					System.out.println("Wylosowana liczba już wystąpiła losuję ją jeszcze raz!");
					i--;
					powtorzenie2 = true; 
					break;
				}	
			}
			if(!powtorzenie2){
				losowaneLiczby[i] = iTemp3;
			}
		}
		
		Arrays.sort(losowaneLiczby);
		System.out.println("Wylosowane liczby " + Arrays.toString(losowaneLiczby));
		Arrays.sort(typowaneLiczby);
		System.out.println("Wytypowane liczby " + Arrays.toString(typowaneLiczby));
		
		// Sprawdzenie czy podane liczby są równe wylosowanym
		int zgodneLiczby = 0;
		
		for(int i = 0; i < losowaneLiczby.length; i++){
			for(int j = 0; j < typowaneLiczby.length; j++){
				if(losowaneLiczby[i] == typowaneLiczby[j]){
					zgodneLiczby += 1;
				}
			}
		}
		
		String wynik = "";
		switch(zgodneLiczby){
		case 3:
			wynik = "Udało Ci się trafić 3 spośród wylosowanych liczb";
			break;
			
		case 4:
			wynik = "Udało Ci się trafić 4 spośród wylosowanych liczb";
			break;
			
		case 5:
			wynik = "Udało Ci się trafić 5 spośród wylosowanych liczb";
			break;
			
		case 6:
			wynik = "Udało Ci się trafić 6 spośród wylosowanych liczb. Brawo główna wygrana";
			break;
		default: wynik = "Niestety nie udało się Tobie trafić przynajmniej 3 trzech liczb spośród losowanych";
		}	
		
		return wynik;	
	}
}

/* 
Symulator LOTTO

Jak wszystkim wiadomo, LOTTO to gra liczbowa polegająca na losowaniu 6 liczb z zakresu od 1 do 49. Zadaniem gracza jest poprawne wytypowanie losowanych liczb. 
Nagradzane jest trafienie 3, 4, 5 lub 6 poprawnych liczb.

Napisz program, który:

    zapyta o typowane liczby, przy okazji sprawdzi następujące warunki:
        czy wprowadzony ciąg znaków jest poprawną liczbą,
        czy użytkownik nie wpisał tej liczby już poprzednio,
        czy liczba należy do zakresu 1-49,
    po wprowadzeniu 6 liczb, posortuje je rosnąco i wyświetli na ekranie,
    wylosuje 6 liczb z zakresu i wyświetli je na ekranie,
    poinformuje gracza, czy trafił przynajmniej "trójkę".

 */