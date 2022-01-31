package com.flowerpost.pack;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

//*TODO*Dodać metodę potrafiącą podzielić obiekt na dwa obiekty. np. Mamy dwie róże => jedna róża + jedna róża
class Flower {

    //Atrybuty klasy\\

    public String name;
    public String colour;
    public boolean availability = false;
    public float price;
    public Date deliveryDate;
    public String id; //*TODO*Czy nie powinna być "final"?

    /////////////\\\\\\\\\\\\\

    //Automatycznie wygenerowane gettery i setttery\\
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
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
        String date;
        String[] parts = deliveryDateRRRRMMDD.split("");
        if(parts.length == 8){
            date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
            deliveryDate = Date.valueOf(date);
        }else {
            deliveryDate = Date.valueOf("1970-01-01");
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    ///////////////////////\\\\\\\\\\\\\\\\\\\\
    //Konstruktor\\
    public Flower(String name,
                  String colour,
                  float price,
                  String deliveryDateRRRRMMDD){
        //Domyślne ustawienie dostępności na "false". *TODO*Czy da się w parametrach?\\
        //this.availability = false;
        //////////////\\\\\\\\\\\\\\\\\
        this.setName(name);
        this.setColour(colour);
        ////////\\\\\\\\
        this.setPrice(price);
        this.setDeliveryDate(deliveryDateRRRRMMDD);
        //Automatycznie wygenerowane "unikatowe" ID\\ *TODO*zrobić bardziej unikatowe, żeby bazowało na każdej cesze
        //Bardzo złe ID poniżej !!POPRAWIC!!\\
        String iD;
        String[] parts = deliveryDateRRRRMMDD.split("");
        if(parts.length == 8){
            iD = parts[0] + parts[1] + parts[2] + parts[3] + parts[4] + parts[5] + parts[6] + parts[7]
                    + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        }else {
            iD = "1997" + "01" + "01" + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10)) + ((int)Math.floor(Math.random()*10));
        }
        this.setId(iD);
        ///////////////\\\\\\\\\\\\\\\\\
    }

    public JSONObject toJson(){
        JSONObject FlowersJsonObj = new JSONObject();
        try {
            FlowersJsonObj.put("id", this.id);
            FlowersJsonObj.put("name", this.name);
            FlowersJsonObj.put("colour", this.colour);
            FlowersJsonObj.put("availability", this.availability);
            FlowersJsonObj.put("price", this.price);
            FlowersJsonObj.put("deliveryDate", this.deliveryDate);
        }catch( JSONException exception){
            exception.printStackTrace();
        }
        return  FlowersJsonObj;
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