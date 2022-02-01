package com.flowerpost.pack;

import org.json.JSONException;
import org.json.JSONObject;

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

    @Override
    public SyntheticFlower clone() {
        try {
            SyntheticFlower clone = (SyntheticFlower) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
