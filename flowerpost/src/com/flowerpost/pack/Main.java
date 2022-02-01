package com.flowerpost.pack;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public void running(){
        boolean running = true;
        Date today = new Date();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj! Dzisiejszy dzień: " + today);
        int option = 1;
        while(running){
            switch (option + 1){
                case 1:
                    System.out.println("Wybierz kwiaciarnie: ");

                    FlowerShop runningFlowerShop = (//WCZYTANIE Z PLIKU KWIACIARNI\\);
                    break;
                case 2:
                    //ZAPISANIE DO PLIKU AKTUALNEGO\\
                    System.out.println("Wybierz kwiaciarnie: ");

                    FlowerShop runningFlowerShop = (//WCZYTANIE Z PLIKU KWIACIARNI\\);
                    break;
                case 3:
                    System.out.println("Magazyn kwiatów:");
                    for()


            }
            System.out.println("Wybierz opcję:");
            System.out.println("1. Wybierz inną kwiaciarnię.");
            System.out.println("2. Wyświetl stan magazynu.");
            System.out.println("3. Dodaj przewidywaną dostawę.");
            System.out.println("4. Dodaj zamówienie i zarezerwuj kwiaty.");
            System.out.println("5. Zakończ działanie programu.");
            option = Integer.parseInt(scanner.nextLine());
        }
    }
}
