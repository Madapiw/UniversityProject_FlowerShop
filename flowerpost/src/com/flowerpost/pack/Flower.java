package com.flowerpost.pack;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

class Flower {

    //Atrybuty klasy\\

    public final String name;
    public final String colour;
    public boolean availability = false;
    public float price;
    public Date deliveryDate;
    public final String id;
    public Date disposalDate;
    public String materialType = null;

    /////////////\\\\\\\\\\\\\

    //Automatycznie wygenerowane gettery i setttery\\
    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    //Poprawiona metoda setDeliveryDate, żeby parametrem był String, a nie Date Object\\
    public void setDeliveryDate(String deliveryDateRRRRMMDD) {
        String[] parts = deliveryDateRRRRMMDD.split("");
        if(parts.length == 8){
            String date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
            deliveryDate = Date.valueOf(date);
        }else {
            deliveryDate = Date.valueOf("1970-01-01");
        }

    }

    public Date getDisposalDate() {
        return disposalDate;
    }

    //Metoda poprawiona analogicznie jak w klasie Flower\\
    //*TODO*Dodać assert, nie można ustawić daty utylizacji w przeszłości\\
    public void setDisposalDate(String disposalDateRRRRMMDD) {
        String date;
        String[] parts = disposalDateRRRRMMDD.split("");
        date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
        String today = String.valueOf(LocalDateTime.now()).split("T")[0];
        if(!Objects.equals(today, date)){
            disposalDate = Date.valueOf(date);
        }
        else{
            System.out.println(today);
        }
    }

    public String getId() {
        return id;
    }

    ///////////////////////\\\\\\\\\\\\\\\\\\\\
    //Konstruktor\\
    public Flower(String name,
                  String colour,
                  float price,
                  String deliveryDateRRRRMMDD){
        //Domyślne ustawienie dostępności na "false". *TODO* [X] Czy da się w parametrach?
        //////////////\\\\\\\\\\\\\\\\\
        this.name = name;
        this.colour = colour;
        ////////\\\\\\\\
        this.setPrice(price);
        this.setDeliveryDate(deliveryDateRRRRMMDD);
        //Automatycznie wygenerowane "unikatowe" ID\\ *TODO* [ ]zrobić bardziej unikatowe, żeby bazowało na każdej cesze
        //Bardzo złe ID poniżej !!POPRAWIC!!\\
        String iD;
        String[] parts = deliveryDateRRRRMMDD.split("");
        if(parts.length == 8){
            iD = parts[4] + parts[5] + parts[6] + parts[7]
                    + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        }else {
            iD = "01" + "01" + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        }
        this.id = iD;
        this.setDisposalDate("19970101");
        ///////////////\\\\\\\\\\\\\\\\\
    }

    //Automatycznie wygenerowane toString()\\
    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", id='" + id + '\'' +
                '}';
    }
    /////////////////////\\\\\\\\\\\\\\\\\\\\

    ////TEST\\\\
//    public static void main (String[] args) {
//        Flower Rose19122021 = new Flower("rose", "red", 30, 12.50F, "20211219");
//        System.out.println(Rose19122021);
//    }
}
//*TODO* Dodać sensowny equals