package com.flowerpost.pack;

import java.sql.Date;

public class NaturalFlower extends Flower{

    //Dodatkowy parametr\\
    public Date disposalDate;
    //////////\\\\\\\\\\\

    //Getter i Setter\\
    public Date getDisposalDate() {
        return disposalDate;
    }

    //Metoda poprawiona analogicznie jak w klasie Flower\\
    //*TODO*Dodać assert, nie można ustawić daty utylizacji w przeszłości\\
    public void setDisposalDate(String disposalDateRRRRMMDD) {
        String date;
        String[] parts = disposalDateRRRRMMDD.split("");
        date = parts[0] + parts[1] + parts[2] + parts[3] + "-" + parts[4] + parts[5] + "-" + parts[6] + parts[7];
        disposalDate = Date.valueOf(date);
    }
    //////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //Metoda utilize ustawia ilość kwiatów na 0, przy założeniu że data utylizacji była conajmniej dzisiaj.\\
    //*TODO* dodać funkcję do bazy danych która będzie usuwać pozycje z @param quantity = 0\\
    public void utilize(){
        long milis = System.currentTimeMillis();
        Date today = new Date(milis);
        if(disposalDate.before(today)){
            this.setQuantity(0);
        }
    }

    //Konstruktor\\
    public NaturalFlower(String name, String colour, int quantity, float price, String deliveryDateRRRRMMDD, String disposalDateRRRRMMDD) {
        super(name, colour, quantity, price, deliveryDateRRRRMMDD);
        this.setDisposalDate(disposalDateRRRRMMDD);
    }

    @Override
    public String toString() {
        return "NaturalFlower{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", quantity=" + quantity +
                ", availability=" + availability +
                ", price=" + price +
                ", deliveryDate=" + deliveryDate +
                ", id='" + id + '\'' +
                ", disposalDate=" + disposalDate +
                '}';
    }

    ////TEST\\\\
//    public static void main (String[] args) {
//        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
//        System.out.println(Rose19122021);
//    }
}
