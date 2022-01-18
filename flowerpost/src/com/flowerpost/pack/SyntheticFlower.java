package com.flowerpost.pack;

import org.json.JSONException;
import org.json.JSONObject;

public class SyntheticFlower extends Flower{

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

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String materialType;

    public SyntheticFlower(String name, String colour, String materialType, int quantity, float price, String deliveryDateRRRRMMDD) {
        super(name, colour, quantity, price, deliveryDateRRRRMMDD);

        this.setMaterialType(materialType);

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

}
