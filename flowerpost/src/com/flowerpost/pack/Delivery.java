package com.flowerpost.pack;

import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Delivery {


    public Date deliveryDate;
    Flowers[] deliveryItems = new Flowers[0];
    //*TODO* [x] Zmienić typ deliveryDestination z String na Objekt nowej klasy\\
    public Address deliveryDestination = new Address("", "", "", "");
    public final String id;

    //Gettery i Settery\\
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    //Poprawione analogicznie do klasy NaturalFlower\\
    //*TODO* [ ] Dodać wyjątek, nie można ustawić daty w przeszłości, ale może być jeśli była ustawiona w momencie kiedy to była przyszłość\\
    public void setDeliveryDate(String deliveryDateRRRRMMDD) throws ParseException {
        String[] parts = deliveryDateRRRRMMDD.split("");
        String date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateGetTime = new Date(Calendar.getInstance().getTime().getTime());

        java.util.Date dateOfDelivery = format.parse(date);
        java.util.Date dateOfNow = format.parse(String.valueOf(dateGetTime));

        if (dateOfNow.compareTo(dateOfDelivery) > 0 ){
            throw new ParseException("Delivery date is in the past",69420);
        }
        System.out.println(date);
        deliveryDate = Date.valueOf(date);

    }

    public String getDeliveryDestination() {
        return deliveryDestination.toString();
    }

    //Poprawiano setter dla obiektu klasy address\\
    public void setDeliveryDestination(String postalCode, String townName, String streetName, String buildingNumber) {
        this.deliveryDestination = new Address(postalCode,townName,streetName,buildingNumber);
    }

    public String getId() {
        return id;
    }

    //Metoda analogiczna do metody z FlowerBouquet\\
    public void addFlower(Flowers flowers) {
        int newArraySize = this.deliveryItems.length + 1;
        Flowers[] biggerArray = new Flowers[newArraySize];
        System.arraycopy(this.deliveryItems, 0, biggerArray, 0, deliveryItems.length);
        biggerArray[newArraySize - 1] = flowers;
        this.deliveryItems = biggerArray;
    }
    ///////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\

    //Metoda nadająca deliveryDate każdemu z obiektów w deliveryItems\\
    public void setDeliveryDateForAllItems(){
        String[] parts = deliveryDate.toString().split("-");
        for(Flowers item : deliveryItems){
            item.setDeliveryDate(parts[0] + parts[1] + parts[2]);
        }
    }
    //*TODO* [ ] Dodać metodę usuwającą pozycję z zamówienia*\\

    public Delivery(String deliveryDateRRRRMMDD, String postalCodeDestination, String townNameDestination, String streetNameDestination, String buildingNumberDestination) {
        try {
            this.setDeliveryDate(deliveryDateRRRRMMDD);
        } catch (ParseException err) {
            err.printStackTrace();
        }
        this.setDeliveryDestination(postalCodeDestination, townNameDestination, streetNameDestination, buildingNumberDestination);
        //Automatycznie wygenerowane "unikatowe" ID\\ *TODO* [ ] zrobić bardziej unikatowe, żeby bazowało na każdej cesze
        String iD;
        String[] parts = deliveryDateRRRRMMDD.split("");
        iD = parts[0] + parts[1] + parts[2] + parts[3] + parts[4] + parts[5] + parts[6] + parts[7]
                + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        this.id = iD;
    }

    public static void main(String[] args) {
        Delivery delivery = new Delivery("20220101","34543","wwa","grzybowa","5e");
    }
}
//*TODO* [ ] Dodać cechę cykliczne i związane z nią funkcjonalności
//*TODO* [X] Dodać metodę zrealizujDostawę(), która: dodaje zawartość zamówienia do określonego magazynu, w odpowiedni sposób przekształca pozycję w bazie danych(koncepcja)