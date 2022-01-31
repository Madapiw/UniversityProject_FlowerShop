package com.flowerpost.pack;

import java.sql.Date;
import java.util.Arrays;

public class Order {
    public Date orderSubmitDate;
    public Date orderExecutionDate;
    Flowers[] orderedFlowers = new Flowers[0];
    FlowersBouquet[] orderedBouquets = new FlowersBouquet[0];
    public String id;
    public Address orderExecutionAddress = new Address("", "", "", "");
    public String noteToOrder;
    public String noteToReceiver;
    public float price;

    //Gettery i Settery\\


    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getOrderSubmitDate() {
        return orderSubmitDate;
    }

    //Poprawiona metoda przyjmująca String
    public void setOrderSubmitDate(String orderSubmitDateRRRRMMDD) {
        String date;
        String[] parts = orderSubmitDateRRRRMMDD.split("");
        date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
        orderSubmitDate = Date.valueOf(date);
    }

    public Date getOrderExecutionDate() {
        return orderExecutionDate;
    }

    //Poprawiona metoda przyjmująca String\\
    public void setOrderExecutionDate(String orderExecutionDateRRRRMMDD) {
        String date;
        String[] parts = orderExecutionDateRRRRMMDD.split("");
        date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
        orderExecutionDate = Date.valueOf(date);
    }

    public Flowers[] getOrderedFlowers() {
        return orderedFlowers;
    }

    public void setOrderedFlowers(Flowers[] orderedFlowers) {
        this.orderedFlowers = orderedFlowers;
    }

    public FlowersBouquet[] getOrderedBouquets() {
        return orderedBouquets;
    }

    public void setOrderedBouquets(FlowersBouquet[] orderedBouquets) {
        this.orderedBouquets = orderedBouquets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getOrderExecutionAddress() {
        return orderExecutionAddress;
    }

    //Poprawiona metoda, żeby przyjmowała String\\
    public void setOrderExecutionAddress(String postalCode, String townName, String streetName, String buildingNumber) {
        this.orderExecutionAddress.setAddress(postalCode, townName, streetName, buildingNumber);
    }

    public String getNoteToOrder() {
        return noteToOrder;
    }

    public void setNoteToOrder(String noteToOrder) {
        this.noteToOrder = noteToOrder;
    }

    public String getNoteToReceiver() {
        return noteToReceiver;
    }

    public void setNoteToReceiver(String noteToReceiver) {
        this.noteToReceiver = noteToReceiver;
    }

    //toString wygenerowany automatycznie\\
    @Override
    public String toString() {
        return "Order{" +
                "orderSubmitDate=" + orderSubmitDate +
                ", orderExecutionDate=" + orderExecutionDate +
                ", orderedFlowers=" + Arrays.toString(orderedFlowers) +
                ", orderedBouquets=" + Arrays.toString(orderedBouquets) +
                ", id='" + id + '\'' +
                ", orderExecutionAddress=" + orderExecutionAddress +
                ", noteToOrder='" + noteToOrder + '\'' +
                ", noteToReceiver='" + noteToReceiver + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    //*TODO* [ ] Zrobić działające equals i hashcode\\

    //Konstruktor poprawiony\\
    public Order(String orderSubmitDateRRRRMMDD, String orderExecutionDateRRRRMMDD,String postalCode, String townName, String streetName, String buildingNumber, String noteToOrder, String noteToReceiver) {
        this.setOrderSubmitDate(orderSubmitDateRRRRMMDD);
        this.setOrderExecutionDate(orderExecutionDateRRRRMMDD);
        //Automatycznie wygenerowane "unikatowe" ID\\ *TODO* [ ] zrobić bardziej unikatowe, żeby bazowało na każdej cesze
        String iD;
        String[] parts = orderSubmitDateRRRRMMDD.split("");
        iD = parts[0] + parts[1] + parts[2] + parts[3] + parts[4] + parts[5] + parts[6] + parts[7]
                + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        this.setId(iD);
        this.setOrderExecutionAddress(postalCode,townName,streetName,buildingNumber);
        this.noteToOrder = noteToOrder;
        this.noteToReceiver = noteToReceiver;
        this.price = 0;
    }

    //Metoda dodająca bukiet podany w parametrze do zamówienia\\
    public void addBouquetToOrder(FlowersBouquet bouquet){
        int newArraySize = this.orderedBouquets.length + 1;
        FlowersBouquet[] biggerArray = new FlowersBouquet[newArraySize];
        System.arraycopy(this.orderedBouquets, 0, biggerArray, 0, orderedBouquets.length);
        biggerArray[newArraySize - 1] = bouquet;
        this.orderedBouquets = biggerArray;
        price = price + bouquet.getCena();
    }

    //Metoda dodająca podany w parametrze kwiat do zamówienia\\
    public void addFlowersToOrder(Flowers flowers){
        int newArraySize = this.orderedFlowers.length + 1;
        Flowers[] biggerArray = new Flowers[newArraySize];
        System.arraycopy(this.orderedFlowers, 0, biggerArray, 0, orderedFlowers.length);
        biggerArray[newArraySize - 1] = flowers;
        this.orderedFlowers = biggerArray;
        price = price + (flowers.getPrice() * flowers.getQuantity());
    }

    //Metoda czyszcząca całe zamówienie\\
    public void clearOrder(){
        this.orderExecutionAddress.clearAddress();
        this.price = 0;
        this.noteToOrder = "";
        this.noteToReceiver = "";
        this.id = "";
        Date dateZero = Date.valueOf("1970-01-01");
        this.orderExecutionDate = dateZero;
        this.orderSubmitDate = dateZero;
        this.orderedFlowers = new Flowers[0];
        this.orderedBouquets = new FlowersBouquet[0];
    }

    //*TODO* [ ] Dodać zmienną stan zamówienia i związaną z nią funkcjonalość.\\
    //*TODO* [ ] Dodać metodę zmieniającą stan zamówienia.\\
    //*TODO* [ ] Dodać metodę sprawdzającą najkorzystniejsze miejsce realizacji zamówienia\\
}
