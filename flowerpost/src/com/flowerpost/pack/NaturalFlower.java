package com.flowerpost.pack;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class NaturalFlower extends Flowers{

    //Dodatkowy parametr\\

    //////////\\\\\\\\\\\
    //Metoda utilize ustawia ilość kwiatów na 0, przy założeniu że data utylizacji była conajmniej dzisiaj.\\
    //*TODO* dodać funkcję do bazy danych która będzie usuwać pozycje z @param quantity = 0 (Czy napewno???)\\
    public void utilize(){
        long milis = System.currentTimeMillis();
        Date today = new Date(milis);
        if(disposalDate.before(today)){
            this.setAvailability(false);
        }
    }

    //Konstruktor\\
    public NaturalFlower(String name, String colour, int quantity, float price, String deliveryDateRRRRMMDD, String disposalDateRRRRMMDD) {
        super(name, colour, quantity, price, deliveryDateRRRRMMDD);
        this.setDisposalDate(disposalDateRRRRMMDD);
    }

    public JSONObject toJson(){
        JSONObject NaturalFlowersJsonObj = new JSONObject();
        try {
            NaturalFlowersJsonObj.put("id", this.id);
            NaturalFlowersJsonObj.put("name", this.name);
            NaturalFlowersJsonObj.put("colour", this.colour);
            NaturalFlowersJsonObj.put("quantity", this.quantity);
            NaturalFlowersJsonObj.put("availability", this.availability);
            NaturalFlowersJsonObj.put("price", this.price);
            NaturalFlowersJsonObj.put("deliveryDate", this.deliveryDate);
            NaturalFlowersJsonObj.put("disposalDate", this.disposalDate);
        }catch( JSONException exception){
            exception.printStackTrace();
        }
        return  NaturalFlowersJsonObj;
    }

    @Override
    public String toString() {
        return "NaturalFlower{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", quantity=" + quantity +
                ", availability=" + availability +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", id='" + id + '\'' +
                ", disposalDate=" + disposalDate +
                '}';
    }

    ////TEST\\\\
    public static void main (String[] args) {
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
//        System.out.println(Rose19122021);
        Rose19122021.setDisposalDate("20220118");
    }
}
