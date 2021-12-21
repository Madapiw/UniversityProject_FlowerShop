package com.flowerpost.pack;

public class Address {

    public String postalCode;
    public String townName;
    public String streetName;
    public int buildingNumber;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public Address(String postalCode, String townName, String streetName, int buildingNumber) {
        this.postalCode = postalCode;
        this.townName = townName;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }

    public void setAddress(String postalCode, String townName, String streetName, int buildingNumber){
        this.postalCode = postalCode;
        this.townName = townName;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }

    public void clearAddress(){
        this.postalCode = "";
        this.townName = "";
        this.streetName = "";
        this.buildingNumber = -1;
    }

    @Override
    public String toString() {
        return "Address{" +
                "postalCode='" + postalCode + '\'' +
                ", townName='" + townName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", buildingNumber=" + buildingNumber +
                '}';
    }
}
