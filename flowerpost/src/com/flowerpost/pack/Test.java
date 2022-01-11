package com.flowerpost.pack;

import java.util.Arrays;

public class Test {
    public void FlowerShopTest(){
        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, 222123456);

//==================================================================================================================\\

        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20211212", "20211220");
        Rose19122021.setAvailability(true);
        Rose12122021.setAvailability(true);
        PlasticRose.setAvailability(true);

//==================================================================================================================\\

        GunNRoses.addFlowerToStock(Rose12122021);
        GunNRoses.addFlowerToStock(Rose19122021);
        GunNRoses.addFlowerToStock(PlasticRose);

        System.out.println("//==================================================================================================================\\");

        System.out.println("||||\t1.\t||||");
        System.out.println(Arrays.toString(GunNRoses.stock));

        System.out.println("//==================================================================================================================\\");

        System.out.println("||||\t2.\t||||");
        System.out.println(GunNRoses.utilize());
        System.out.println(Arrays.toString(GunNRoses.stock));

        System.out.println("//==================================================================================================================\\");

        Delivery delivery = new Delivery("20211224","98101", "Seattle", "Cobain", "27");
        NaturalFlower RosePink = new NaturalFlower("rose", "pink", 30, 12.50F, "", "20220119");
        SyntheticFlower PlasticRoseBlue = new SyntheticFlower("rose", "blue", "plastic", 15, 7.50F,"");
        delivery.addFlower(RosePink);
        delivery.addFlower(PlasticRoseBlue);
        delivery.setDeliveryDateForAllItems();

//==================================================================================================================\\");

        System.out.println("||||\t3.\t||||");
        System.out.println(Arrays.toString(delivery.deliveryItems));

        System.out.println("//==================================================================================================================\\");

        System.out.println("||||\t4.\t||||");
        GunNRoses.addDelivery(delivery);
        GunNRoses.checkDelivery();
        System.out.println(Arrays.toString(GunNRoses.stock));
    }

    public void FlowersBouquetTest(){
        FlowersBouquet Bouquet = new FlowersBouquet();
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        Bouquet.addFlower(Rose19122021);
        SyntheticFlower DragonPlant = new SyntheticFlower("Dragon Plant", "Blue", "Plastik", 4, 3.50F, "20211220");
        Bouquet.addFlower(DragonPlant);
        System.out.println(Bouquet);
    }

    public void OrderTest(){
        Order order = new Order("20220111", "20220214", "00-000", "Ciechocinek", "Cicha", "12", "Zaśpiewać przy wręczeniu.", "Tęsknimy.");
        FlowersBouquet bouquet = new FlowersBouquet();
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        bouquet.addFlower(Rose19122021);
        order.addBouquetToOrder(bouquet);
        System.out.println(order);
        System.out.println("============================================================");
        order.clearOrder();
        System.out.println(order);
    }

    public  static void main(String[] args) {
        Test test = new Test();
//        test.FlowerShopTest();
        test.FlowersBouquetTest();
        test.OrderTest();

    }
}
