package com.flowerpost.pack;

import java.sql.Date;

public class Delivery {


    public Date deliveryDate;
    Flower[] deliveryItems = new Flower[0];
    //*TODO* [x] Zmienić typ deliveryDestination z String na Objekt nowej klasy\\
    public Address deliveryDestination;
    public String id;

    //Gettery i Settery\\
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    //Poprawione analogicznie do klasy NaturalFlower\\
    //*TODO* [ ] Dodać wyjątek, nie można ustawić daty w przeszłości, ale może być jeśli była ustawiona w momencie kiedy to była przyszłość\\
    public void setDeliveryDate(String deliveryDateRRRRMMDD) {
        String date;
        String[] parts = deliveryDateRRRRMMDD.split("");
        date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
        deliveryDate = Date.valueOf(date);
    }

    public String getDeliveryDestination() {
        return deliveryDestination.toString();
    }

    //Poprawiano setter dla obiektu klasy address\\
    public void setDeliveryDestination(String postalCode, String townName, String streetName, int buildingNumber) {
        this.deliveryDestination.setAddress(postalCode,townName,streetName,buildingNumber);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //Metoda analogiczna do metody z FlowerBouquet\\
    public void addFlower(Flower flower) {
        int newArraySize = this.deliveryItems.length + 1;
        Flower[] biggerArray = new Flower[newArraySize];
        System.arraycopy(this.deliveryItems, 0, biggerArray, 0, deliveryItems.length);
        biggerArray[newArraySize - 1] = flower;
        this.deliveryItems = biggerArray;
    }
    ///////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\

    //*TODO* [ ] Dodać metodę usuwającą pozycję z zamówienia*\\

    public Delivery(String deliveryDateRRRRMMDD, String postalCodeDestination, String townNameDestination, String streetNameDestination, int buildingNumberDestination, String id) {
        this.setDeliveryDate(deliveryDateRRRRMMDD);
        this.setDeliveryDestination(postalCodeDestination, townNameDestination, streetNameDestination, buildingNumberDestination);
        //Automatycznie wygenerowane "unikatowe" ID\\ *TODO* [ ] zrobić bardziej unikatowe, żeby bazowało na każdej cesze
        String iD;
        String[] parts = deliveryDateRRRRMMDD.split("");
        iD = parts[0] + parts[1] + parts[2] + parts[3] + parts[4] + parts[5] + parts[6] + parts[7]
                + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        this.setId(iD);
    }
}
//*TODO* [ ] Dodać cechę cykliczne i związane z nią funkcjonalności
//*TODO* [ ] Dodać metodę zrealizujDostawę(), która: dodaje zawartość zamówienia do określonego magazynu, w odpowiedni sposób przekształca pozycję w bazie danych(koncepcja)