package com.flowerpost.pack;

import java.util.Arrays;

//*TODO* dodać wyjątek jeśli dodawany kwiat ma dostępność false\\
public class FlowersBouquet {

    //Atrybuty obiektu klasy\\
    Flowers[] bouquet = new Flowers[0];
    public float cena;
    //////////////\\\\\\\\\\\\

    //Getter i Setter dla ceny\\
    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
    ////////////\\\\\\\\\\\\\\\\\\

    //Metoda dodająca kwiat do bukietu, aktualizuje również jego cenę.\\
    public void addFlower(Flowers flowers){
        int newArraySize = this.bouquet.length + 1;
        Flowers[] biggerArray = new Flowers[newArraySize];
        System.arraycopy(this.bouquet, 0, biggerArray, 0, bouquet.length);
        biggerArray[newArraySize - 1] = flowers;
        this.bouquet = biggerArray;

        this.setCena(this.getCena() + (flowers.price * flowers.quantity));
    }
    //////////////////\\\\\\\\\\\

    //*TODO* Dodać metodę deleteFlower usuwającą określoną pozycję w bouquet.\\
    public void deleteFlowers(String id, int quantity){
        Flowers[] bouquet1 = this.bouquet;
        for (int i = 0, bouquet1Length = bouquet1.length; i < bouquet1Length; i++) {
            Flowers flowers = bouquet1[i];
            if (flowers.id == id) {
                System.out.println("Deleted flowers: " + flowers.name + " ID: " + flowers.id + " Quantity: " + quantity);
                if (flowers.quantity > quantity) flowers.quantity -= quantity;
                else if (flowers.quantity <= quantity) {
                    Flowers[] bouquetWithoutDeleted = new Flowers[bouquet1Length -1];
                    for(int j = i; j < bouquet1Length -1;j++){
                        bouquet1[j] = bouquet1[j+1];
                    }
                    System.arraycopy(bouquet1,0,bouquetWithoutDeleted,0, bouquet1Length-1);
                    this.bouquet = bouquetWithoutDeleted;
                }
            }
        }
    }


    //Automatycznie wygenerowany toString\\\\\\\
    @Override
    public String toString() {
        return "FlowersBouquet{" +
                "bouquet=" + Arrays.toString(bouquet) +
                ", cena=" + cena +
                '}';
    }
    ////////////\\\\\\\\\\\\\\\\

    //TEST\\
//    public static void main (String[] args) {
//        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
//        FlowersBouquet RoseBouquet = new FlowersBouquet();
//        RoseBouquet.addFlower(Rose19122021);
//        SyntheticFlower DragonPlant = new SyntheticFlower("Dragon Plant", "Blue", "Plastik", 4, 3.50F, "20211220");
//        RoseBouquet.addFlower(DragonPlant);
//        System.out.println(RoseBouquet);
//        RoseBouquet.deleteFlowers("20211219875",31);
//        System.out.println(RoseBouquet);
//    }
}

