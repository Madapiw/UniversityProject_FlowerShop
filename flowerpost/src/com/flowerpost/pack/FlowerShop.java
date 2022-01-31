package com.flowerpost.pack;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class FlowerShop {
    //Atrybuty Klasy\\
    public final Address flowerShopAddress;
    public final int phoneNumber;
    Flowers[] stock = new Flowers[0];

    //Gettery i Settery\\
    public Address getFlowerShopAddress() {
        return flowerShopAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public Flowers[] getStock() {
        return stock;
    }

    //Konstruktor\\\
    public FlowerShop(Address flowerShopAddress, int phoneNumber) {
        this.flowerShopAddress = flowerShopAddress;
        this.phoneNumber = phoneNumber;
    }

    //Metoda dodająca pozycję do magazynu\\
    public void addFlowerToStock(Flowers flowersObject) {
        int newArraySize = this.stock.length + 1;
        Flowers[] biggerArray = new Flowers[newArraySize];
        System.arraycopy(this.stock, 0, biggerArray, 0, stock.length);
        biggerArray[newArraySize - 1] = flowersObject;
        this.stock = biggerArray;
    }

    //Metoda usuwająca pozycję z magazynu o określonym id\\
    public void removeFlowerObjectFromStock(String id) {
        for (int i = 0; i < this.stock.length; i++) {
            if (Objects.equals(stock[i].id, id)) {
                stock[i] = null;
            }
        }
    }

    //Metoda usuwająca kawiaty z obiektu zawartego w liście, spełniającego minimum zawarte w opisie\\
    public void removeFlowerFromAvailableStockObject(Flowers flowers) {
        for (Flowers flowersStocked : this.stock) {
            if (Objects.equals(flowersStocked.name, flowers.name)
                    && Objects.equals(flowersStocked.colour, flowers.colour)
                    && Objects.equals(flowersStocked.availability, flowers.availability)
                    && Objects.equals(flowersStocked.availability, true)
                    && (flowersStocked.quantity >= flowers.quantity)) {
                flowersStocked.quantity = flowersStocked.quantity - flowers.quantity;
                break;
            }
        }
    }

    //Metoda sprawdzająca czy jest na stanie Obiekt kwiat spełniający założenia\\
    public boolean checkFlowerFromStockObject(Flowers flowers) {
        for (Flowers flowersStocked : this.stock) {
            if (Objects.equals(flowersStocked.name, flowers.name)
                    && Objects.equals(flowersStocked.colour, flowers.colour)
                    && Objects.equals(flowersStocked.availability, flowers.availability)
                    && Objects.equals(flowersStocked.availability, true)
                    && (flowersStocked.quantity >= flowers.quantity)) {
                return true;
            }
        }
        return false;
    }

    //Metoda utylizująca przeterminowane kwiaty\\
    public String utilize(){
        Date today = new Date();
        Flowers[] utilizedFlowers = new NaturalFlower[0];
        Flower dateFlower = new Flower("date", "date", 0,"20200202");
        for (Flowers flowers : stock) {
            if (!Objects.equals(flowers.disposalDate.toString(), dateFlower.disposalDate.toString())) {
                if ((flowers).getDisposalDate().before(today)) {
                    int newArraySize = utilizedFlowers.length + 1;
                    Flowers[] biggerUtylizedFlowers = new NaturalFlower[newArraySize];
                    System.arraycopy(utilizedFlowers, 0, biggerUtylizedFlowers, 0, utilizedFlowers.length);
                    biggerUtylizedFlowers[newArraySize - 1] = (flowers);
                    utilizedFlowers = biggerUtylizedFlowers;

                    flowers.setAvailability(false);
                }
            }
        }
        return (Arrays.toString(utilizedFlowers));
    }

    //Metoda "realizująca dostawę" czyli przenosząca obiekty Flower z deliveryItems do stock i zmieniająca avalibility na true.
    //*TODO* [ ]  Dodać błąd kiedy próbuje się zrealizować dostawę nie w tej kwiacierni.
    //*TODO* [X]  Zmienić działanie funkcji, aby jedynie zmieniała dostępność anego obiektu Flower w magazynie, zmieana do późniejszej implementacji raport\\
    public void addDelivery(Delivery delivery){
        int ammountOfItems = delivery.deliveryItems.length;
        for(Flowers item : delivery.deliveryItems){
            this.addFlowerToStock(item);
        }
    }

    //Metoda zmieniająca dostępność kwiatów z dzisiejszych dostaw\\//*TODO* [X] Nie działa, naprawić trzebas
    public String checkDelivery(){
        Date today = new Date();
        Flowers[] deliveredFlowers = new Flowers[0];
        for (Flowers flowers : stock) {
            if ((flowers).getDeliveryDate().before(today) || (flowers).getDeliveryDate().equals(today)) {
                int newArraySize = deliveredFlowers.length + 1;
                Flowers[] biggerDeliveredFlowers = new Flowers[newArraySize];
                System.arraycopy(deliveredFlowers, 0, biggerDeliveredFlowers, 0, deliveredFlowers.length);
                biggerDeliveredFlowers[newArraySize - 1] = ((Flowers) flowers);
                deliveredFlowers = biggerDeliveredFlowers;

                flowers.setAvailability(true);
            }
        }
        return (Arrays.toString(deliveredFlowers));
    }

    //*TODO* [ ] Metoda "realizująca zamówienie\\ czyli na podstawie parametrów tworząca obiekt zamówienia i usuwająca kwiaty z magazynu.\\
    //*TODO* [ ] Jeśli nie ma wystarczającej ilości, zwracany jest błąd.\\

    public void createOrder(){
        Date orderSubmitDateUtil = new Date();
        java.sql.Date orderSubmitDateSql = new java.sql.Date(orderSubmitDateUtil.getTime());
        String orderExecutionDate;
        String postalCode;
        String townName;
        String streetName;
        String buildingNumber;
        String noteToOrder;
        String noteToReceiver;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPodaj date wykonania zamówienia w formacie RRRRMMDD:\t");
        orderExecutionDate = scanner.nextLine();
        System.out.println("\nPodaj kod pocztowy do zamówienia:\t");
        postalCode = scanner.nextLine();
        System.out.println("\nPodaj nazwę miasta do zamówienia:\t");
        townName = scanner.nextLine();
        System.out.println("\nPodaj nazwę ulicy do zamówienia:\t");
        streetName = scanner.nextLine();
        System.out.println("\nPodaj numer budynku do zamówienia:\t");
        buildingNumber = scanner.nextLine();
        System.out.println("\nPodaj notę dla dostawcy(zostaw puste jeśli bez):\t");
        noteToOrder = scanner.nextLine();
        System.out.println("\nPodaj notę dla odbiorcy(zostaw puste jeśli bez):\t");
        noteToReceiver = scanner.nextLine();
        Order order = new Order("20201212", orderExecutionDate, postalCode, townName, streetName, buildingNumber, noteToOrder, noteToReceiver);
        order.orderSubmitDate = orderSubmitDateSql;


    }


    //TEST
    public  static void main(String[] args){
        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, 222123456);
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20211212", "20211220");
        Rose19122021.setAvailability(true);
        Rose12122021.setAvailability(true);
        PlasticRose.setAvailability(true);
        GunNRoses.addFlowerToStock(Rose12122021);
        GunNRoses.addFlowerToStock(Rose19122021);
        GunNRoses.addFlowerToStock(PlasticRose);

        System.out.println(GunNRoses.utilize());
        System.out.println(Arrays.toString(GunNRoses.stock));

        GunNRoses.createOrder();

//        System.out.println("=======================================================================");
//
//        Delivery delivery = new Delivery("20211224","98101", "Seattle", "Cobain", "27");
//        NaturalFlower RosePink = new NaturalFlower("rose", "pink", 30, 12.50F, "", "20220119");
//        SyntheticFlower PlasticRoseBlue = new SyntheticFlower("rose", "blue", "plastic", 15, 7.50F,"");
//        delivery.addFlower(RosePink);
//        delivery.addFlower(PlasticRoseBlue);
//        delivery.setDeliveryDateForAllItems();
//        System.out.println(Arrays.toString(delivery.deliveryItems));
//        GunNRoses.addDelivery(delivery);
//        GunNRoses.checkDelivery();
//        System.out.println(Arrays.toString(GunNRoses.stock));

    }
}

