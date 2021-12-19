package com.flowerpost.pack;

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
}
