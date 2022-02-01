package com.flowerpost.pack;

public class Flowers extends Flower{
    public int quantity;

    public int getQuantity() {
        return quantity;
    }

    //Poprawiona metoda, aby nie dało się ustawić ujemnej liczby kwiatów.\\
    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
    }

    //Własne metody\\

    //Metoda "addQuantity" dodaje określoną ilość @param quantity do atrybutu quantitu obiektu.\\
    public void  addQuantity(int quantity){
        int currentQuantity = this.getQuantity();
        this.setQuantity(currentQuantity + quantity);
    }

    //Metoda "removeQuantity" usuwa określoną ilość @param quantity z atrybutu obiektu quantity.\\
    //Wartość quantity nie może być ujemna więc przewidujemy ten przypadek stosując "if"\\
    public void removeQuantity(int quantity){
        int currentQuantity = this.getQuantity();
        this.setQuantity(currentQuantity - quantity);
    }

    public Flowers(String name, String colour, int quantity, float price, String deliveryDateRRRRMMDD) {
        super(name, colour, price, deliveryDateRRRRMMDD);
        //Ustawienie wartości quantity na nieujemną.\\
        this.setQuantity(Math.max(quantity, 0));
        ////////\\\\\\\\
    }

    @Override
    public String toString() {
        return "Flowers{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", availability=" + availability +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", id='" + id + '\'' +
                ", quantity=" + quantity +
                '}';
    }

}
