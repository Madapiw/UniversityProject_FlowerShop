package com.flowerpost.pack;

public class SyntheticFlower extends Flowers implements Cloneable{

    @Override
    public String toString() {
        return ("Typ: Sztuczny       Nazwa: " + this.name + "\t" + "Kolor: " + this.colour + "\t" + "Cena: " + this.price + "\t" +"Typ materiału: " + (this.materialType) + "\t" + "Identyfikator: " + this.id + "\n" +
                "Dostępnośc: " + this.availability + "\t" + "Data dostawy: " + this.deliveryDate + "\t" + "Ilość: " + this.quantity);
    }




    public SyntheticFlower(String name, String colour, String materialType, int quantity, float price, String deliveryDateRRRRMMDD) {
        super(name, colour, quantity, price, deliveryDateRRRRMMDD);

        this.materialType = materialType;

    }

}
