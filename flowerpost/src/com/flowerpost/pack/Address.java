package com.flowerpost.pack;

public class Address {

    public final String postalCode;
    public final String townName;
    public final String streetName;
    public final String buildingNumber;

    public String getPostalCode() {
        return postalCode;
    }

    public String getTownName() {
        return townName;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public Address(String postalCode, String townName, String streetName, String buildingNumber) {
        this.postalCode = postalCode;
        this.townName = townName;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return "Adres: " + postalCode + townName + ", ul. " + streetName + ", numer budynku " + buildingNumber;
    }
}
