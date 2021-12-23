package com.flowerpost.pack;

import java.util.Objects;

public class FlowerShop {
    //Atrybuty Klasy\\
    public Address flowerShopAddress;
    public int phoneNumber;
    Flower[] stock = new Flower[0];

    //Gettery i Settery\\
    public Address getFlowerShopAddress() {
        return flowerShopAddress;
    }

    public void setFlowerShopAddress(Address flowerShopAddress) {
        this.flowerShopAddress = flowerShopAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Flower[] getStock() {
        return stock;
    }

    public void setStock(Flower[] stock) {
        this.stock = stock;
    }

    //Konstruktor\\\
    public FlowerShop(Address flowerShopAddress, int phoneNumber, Flower[] stock) {
        this.flowerShopAddress = flowerShopAddress;
        this.phoneNumber = phoneNumber;
        this.stock = stock;
    }

    //Funkcja dodająca pozycję do magazynu\\
    public void addFlowerToStock(Flower flowerObject) {
        int newArraySize = this.stock.length + 1;
        Flower[] biggerArray = new Flower[newArraySize];
        System.arraycopy(this.stock, 0, biggerArray, 0, stock.length);
        biggerArray[newArraySize - 1] = flowerObject;
        this.stock = biggerArray;
    }

    //Funkcja usuwająca pozycję z magazynu o określonym id\\
    public void removeFlowerObjectFromStock(String id) {
        for (int i = 0; i < this.stock.length; i++) {
            if (Objects.equals(stock[i].id, id)) {
                stock[i] = null;
            }
        }
    }

    //Funkcja usuwająca kawiaty z obiektu zawartego w liście, spełniającego minimum zawarte w opisie\\
    public void removeFlowerFromStockObject(Flower flower) {
        for (Flower flowerStocked : this.stock) {
            if (Objects.equals(flowerStocked.name, flower.name)
                    && Objects.equals(flowerStocked.colour, flower.colour)
                    && Objects.equals(flowerStocked.availability, flower.availability)
                    && Objects.equals(flowerStocked.availability, true)
                    && (flowerStocked.quantity >= flower.quantity)) {
                flowerStocked.quantity = flowerStocked.quantity - flower.quantity;
                break;
            }
        }
    }

    //Funkcja sprawdzająca czy jest na stanie Obiekt kwiat spełniający założenia\\
    public boolean checkFlowerFromStockObject(Flower flower) {
        for (Flower flowerStocked : this.stock) {
            if (Objects.equals(flowerStocked.name, flower.name)
                    && Objects.equals(flowerStocked.colour, flower.colour)
                    && Objects.equals(flowerStocked.availability, flower.availability)
                    && Objects.equals(flowerStocked.availability, true)
                    && (flowerStocked.quantity >= flower.quantity)) {
                return true;
            }
        }
        return false;
    }


}

