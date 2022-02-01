package com.flowerpost.pack;

import java.sql.Date;

public class NaturalFlower extends Flowers implements Cloneable{

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
    public NaturalFlower(String name, String colour, int quantity, float price, String deliveryDateRRRRMMDD, String disposalDateRRRRMMDD){
        super(name, colour, quantity, price, deliveryDateRRRRMMDD);
        this.setDisposalDate(disposalDateRRRRMMDD);
    }


    @Override
    public String toString() {
        return ("Typ: naturalny      Nazwa: " + this.name + "\t" + "Kolor: " + this.colour + "\t" + "Cena: " + this.price + "\t" + "Identyfikator: " + this.id + "\n" +
                "Dostępnośc: " + this.availability + "\t" + "Data dostawy: " + this.deliveryDate + "\t" + "Termin ważności: " + this.disposalDate + "\t" + "Ilość: " + this.quantity);
    }

    ////TEST\\\\
    public static void main (String[] args) {
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
//        System.out.println(Rose19122021);
        Rose19122021.setDisposalDate("20220118");
    }


}
