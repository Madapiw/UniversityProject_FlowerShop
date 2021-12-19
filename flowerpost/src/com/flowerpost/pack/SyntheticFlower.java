package com.flowerpost.pack;

public class SyntheticFlower extends Flower{

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
}
