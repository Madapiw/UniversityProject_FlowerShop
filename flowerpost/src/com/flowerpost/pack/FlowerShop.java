package com.flowerpost.pack;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class FlowerShop {
    //Atrybuty Klasy\\
    public Address flowerShopAddress = new Address("", "", "", "");
    public int phoneNumber;
    Flower[] stock = new Flower[0];

    //Gettery i Settery\\
    public Address getFlowerShopAddress() {
        return flowerShopAddress;
    }

    public void setFlowerShopAddress(Address flowerShopAddress) {
        this.flowerShopAddress = flowerShopAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Flower[] getStock() {
        return stock;
    }

    public void setStock(Flower[] stock) {
        this.stock = stock;
    }

    //Konstruktor\\\
    public FlowerShop(Address flowerShopAddress, int phoneNumber) {
        this.flowerShopAddress = flowerShopAddress;
        this.phoneNumber = phoneNumber;
    }

    //Metoda dodająca pozycję do magazynu\\
    public void addFlowerToStock(Flower flowerObject) {
        int newArraySize = this.stock.length + 1;
        Flower[] biggerArray = new Flower[newArraySize];
        System.arraycopy(this.stock, 0, biggerArray, 0, stock.length);
        biggerArray[newArraySize - 1] = flowerObject;
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
    public void removeFlowerFromAvailableStockObject(Flower flower) {
        for (Flower flowerStocked : this.stock) {
            if (Objects.equals(flowerStocked.name, flower.name)
                    && Objects.equals(flowerStocked.colour, flower.colour)
                    && Objects.equals(flowerStocked.availability, flower.availability)
                    && Objects.equals(flowerStocked.availability, true)
                    && (flowerStocked.quantity >= flower.quantity)) {
                flowerStocked.quantity = flowerStocked.quantity - flower.quantity;
                break;
            }
        }
    }

    //Metoda sprawdzająca czy jest na stanie Obiekt kwiat spełniający założenia\\
    public boolean checkFlowerFromStockObject(Flower flower) {
        for (Flower flowerStocked : this.stock) {
            if (Objects.equals(flowerStocked.name, flower.name)
                    && Objects.equals(flowerStocked.colour, flower.colour)
                    && Objects.equals(flowerStocked.availability, flower.availability)
                    && Objects.equals(flowerStocked.availability, true)
                    && (flowerStocked.quantity >= flower.quantity)) {
                return true;
            }
        }
        return false;
    }

    //Metoda utylizująca przeterminowane kwiaty\\
    public String utilize(){
        Date today = new Date();
        NaturalFlower[] utilizedFlowers = new NaturalFlower[0];
        try{
            for (Flower flower : stock) {
//                System.out.println(((NaturalFlower) flower).getDisposalDate() + " ||| " + today);
                if (((NaturalFlower) flower).getDisposalDate().before(today)) {
                    int newArraySize = utilizedFlowers.length + 1;
                    NaturalFlower[] biggerUtylizedFlowers = new NaturalFlower[newArraySize];
                    System.arraycopy(utilizedFlowers, 0, biggerUtylizedFlowers, 0, utilizedFlowers.length);
                    biggerUtylizedFlowers[newArraySize - 1] = ((NaturalFlower) flower);
                    utilizedFlowers = biggerUtylizedFlowers;

                    flower.setAvailability(false);
                }
            }
        } catch (Exception ignore) { } //Funkcja zwraca wyjątki ponieważ możemy starać sie wywołać getUtilizeDate dla SynthethicFlower
        return (Arrays.toString(utilizedFlowers));
    }

    //Metoda "realizująca dostawę" czyli przenosząca obiekty Flower z deliveryItems do stock i zmieniająca avalibility na true.
    //*TODO* [ ]  Dodać błąd kiedy próbuje się zrealizować dostawę nie w tej kwiacierni.
    //*TODO* [X]  Zmienić działanie funkcji, aby jedynie zmieniała dostępność anego obiektu Flower w magazynie, zmieana do późniejszej implementacji raport\\
    public void addDelivery(Delivery delivery){
        int ammountOfItems = delivery.deliveryItems.length;
        for(Flower item : delivery.deliveryItems){
            this.addFlowerToStock(item);
        }
    }

    //Metoda zmieniająca dostępność kwiatów z dzisiejszych dostaw\\//*TODO* [X] Nie działa, naprawić trzebas
    public String checkDelivery(){
        Date today = new Date();
        Flower[] deliveredFlowers = new Flower[0];
        for (Flower flower : stock) {
//            System.out.println(flower.getDeliveryDate() + "   |||    " + today);
            if ((flower).getDeliveryDate().before(today) || (flower).getDeliveryDate().equals(today)) {
                int newArraySize = deliveredFlowers.length + 1;
                Flower[] biggerDeliveredFlowers = new Flower[newArraySize];
                System.arraycopy(deliveredFlowers, 0, biggerDeliveredFlowers, 0, deliveredFlowers.length);
                biggerDeliveredFlowers[newArraySize - 1] = ((Flower) flower);
                deliveredFlowers = biggerDeliveredFlowers;

                flower.setAvailability(true);
            }
        }
        return (Arrays.toString(deliveredFlowers));
    }
    //Metoda "realizująca zamówienie\\ czyli na podstawie parametrów tworząca obiekt zamówienia i usuwająca kwiaty z magazynu.\\
    //Jeśli nie ma wystarczającej ilości, zwracany jest błąd.\\
    //*TODO*^^^^^

    //TEST\\
//    public  static void main(String[] args){
//        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
//        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, 222123456);
//        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
//        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
//        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20211212", "20211220");
//        Rose19122021.setAvailability(true);
//        Rose12122021.setAvailability(true);
//        PlasticRose.setAvailability(true);
//        GunNRoses.addFlowerToStock(Rose12122021);
//        GunNRoses.addFlowerToStock(Rose19122021);
//        GunNRoses.addFlowerToStock(PlasticRose);
//
//        System.out.println(GunNRoses.utilize());
//        System.out.println(Arrays.toString(GunNRoses.stock));
//
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
//
//    }
}

