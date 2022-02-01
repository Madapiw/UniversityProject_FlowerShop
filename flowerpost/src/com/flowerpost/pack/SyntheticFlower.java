package com.flowerpost.pack;

import org.json.JSONException;
import org.json.JSONObject;

public class SyntheticFlower extends Flowers implements Cloneable{

    @Override
    public String toString() {
        return "SyntheticFlower{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", quantity=" + quantity +
                ", availability=" + availability +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", id='" + id + '\'' +
                ", materialType='" + materialType + '\'' +
                '}';
    }

    public String getMaterialType() {
        return materialType;
    }

    public final String materialType;

    public SyntheticFlower(String name, String colour, String materialType, int quantity, float price, String deliveryDateRRRRMMDD) {
        super(name, colour, quantity, price, deliveryDateRRRRMMDD);

        this.materialType = materialType;

    }

    public JSONObject toJson(){
        JSONObject SyntheticFlowersJsonObj = new JSONObject();
        try {
            SyntheticFlowersJsonObj.put("id", this.id);
            SyntheticFlowersJsonObj.put("name", this.name);
            SyntheticFlowersJsonObj.put("colour", this.colour);
            SyntheticFlowersJsonObj.put("quantity", this.quantity);
            SyntheticFlowersJsonObj.put("availability", this.availability);
            SyntheticFlowersJsonObj.put("price", this.price);
            SyntheticFlowersJsonObj.put("deliveryDate", this.deliveryDate);
            SyntheticFlowersJsonObj.put("materialType", this.materialType);
        }catch( JSONException exception){
            exception.printStackTrace();
        }
        return  SyntheticFlowersJsonObj;
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
