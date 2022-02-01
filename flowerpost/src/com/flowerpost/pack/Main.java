package com.flowerpost.pack;

import java.io.File;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public void printFilesInWorkingDir(){
        String workingPath = Paths.get("").toAbsolutePath().toString();
        File dir = new File(workingPath);
        File[] listOfFIles = dir.listFiles();
        for (File file: listOfFIles) {
            if(file.isFile()){
                System.out.println(file.getName());
            }
        }
    }

    public void running(){
        boolean running = true;
        Date today = new Date();
        String fileName = "";
        SaveToFile saveToFile = new SaveToFile();
        Scanner scanner = new Scanner(System.in);
        Flower dateFlower = new Flower("", "", 0, "19970101");
        FlowerShop runningFlowerShop = null;
        System.out.println("Witaj! Dzisiejszy dzień: " + new java.sql.Date(today.getTime()));
        int option = 0;
        while(running){
            switch (option + 1) {
                case 1 -> {
                    System.out.println("Wybierz plik kwiaciarni ( bez .json ): ");
                    //*TODO[x] wypisać pliki z folderu
                    printFilesInWorkingDir();
                    fileName = scanner.nextLine();
                    runningFlowerShop = saveToFile.readFromFile(fileName);
//                    runningFlowerShop.utilize();
//                    runningFlowerShop.checkDelivery();
                }
                case 2 -> {
                    //ZAPISANIE DO PLIKU AKTUALNEGO\\
                    System.out.println("Wybierz inną kwiaciarnie: ");
                    printFilesInWorkingDir();
                    String fileNameToRead = scanner.nextLine();
                    saveToFile.saveToFile(runningFlowerShop, fileName);
                    runningFlowerShop = saveToFile.readFromFile(fileNameToRead);
                    System.out.println("Wczytano " + fileNameToRead);
//                    runningFlowerShop.utilize();
//                    runningFlowerShop.checkDelivery();
                }
                case 3 -> {
                    System.out.println("Magazyn kwiatów:");
                    System.out.println("||=======================================================================||");
                    for (Flowers item : runningFlowerShop.stock) {
                        if (Objects.equals(item.disposalDate.toString(), dateFlower.disposalDate.toString())) {
                            Flower tempSynthethicFlower =  item.clone();
                            System.out.println(tempSynthethicFlower.toString());
                        } else {
                            Flower tempNaturalFlower = item.clone();
                            System.out.println(tempNaturalFlower);
                        }
                        System.out.println("||=======================================================================||");
                    }
                    System.out.println("\n\n||=======================================================================||");
                    System.out.println("Magazyn zamówień: ");
                    System.out.println("||=======================================================================||");
                    for (Order order : runningFlowerShop.stockOrders) {
                        System.out.println("Data złożenia zamówienia: " + order.orderSubmitDate + "\t" + "Data wykonania zamówienia: " + order.orderSubmitDate + "\t" + "Identyfikaor zamówienia: " + order.id);
                        System.out.println(order.orderExecutionAddress.toString() + "\tCena: " + order.price);
                        System.out.println("Nota dla dostawcy: " + order.noteToOrder);
                        System.out.println("Nota dla odbiorcy: " + order.noteToReceiver);
                        System.out.println("Zawartość zamówienia: ");
                        for (Flowers flowers : order.orderedFlowers) {
                            System.out.println(flowers.toString());
                        }
                        for (FlowersBouquet bouquet : order.orderedBouquets) {
                            System.out.println(bouquet.toString());
                        }
                        System.out.println("Czy zrealizowany: " + order.completed);
                        System.out.println("||=======================================================================||");
                    }
                }
                case 4 -> {
                    System.out.println("Kreator dostaw: ");
                    runningFlowerShop.createDelivery();
                }
                case 5 -> {
                    System.out.println("Kreator zamówień: ");
                    runningFlowerShop.createOrder();
                }
                case 6 -> {
                    running = false;
                    //ZAPISANIE DO PLIKU//
                    System.out.println("Koniec działania programu. Zapisano stan do plików.");
                }
                default -> throw new IllegalStateException("Unexpected value: " + option + 1);
            }
            if(option != 5) {
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

    public static void main(String[] args) {
        Main main = new Main();
        main.running();
    }
}
