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
//    }
}

