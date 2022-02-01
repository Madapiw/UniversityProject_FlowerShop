package com.flowerpost.pack;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveToFile {
    //*TODO* [] Zapis wszystkiego do jednego pliku json.
    //*TODO* [] Dopisanie do klas metod toJson().
    public void saveToFile(FlowerShop flowerShop, String fileName){
        Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(fileName +".json"));
            gson.toJson(flowerShop,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FlowerShop readFromFile(String fileName){
            Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
            FlowerShop flowerShopFromFile = null;
        try {
            Path inputFilePath = Paths.get(fileName+".json");
            Reader reader = Files.newBufferedReader(Path.of(String.valueOf(inputFilePath.toAbsolutePath())));
            flowerShopFromFile = gson.fromJson(reader,FlowerShop.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flowerShopFromFile;
    }

    ////TEST\\\\
    public static void main(String[] args){
        FlowerShop[] flowershops;
        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, "222123456");

        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20220212", "20211220");
        GunNRoses.addFlowerToStock(Rose12122021);
        GunNRoses.addFlowerToStock(Rose19122021);
        GunNRoses.addFlowerToStock(PlasticRose);
//        System.out.println(Arrays.toString(GunNRoses.stock));
        System.out.println("#############################################################");
        ////TEST JSON\\\\
        SaveToFile FlowerShopsDB = new SaveToFile();
        FlowerShopsDB.saveToFile(GunNRoses,"GunNRoses");
        System.out.println(FlowerShopsDB.readFromFile("GunNRoses"));
        }


}

