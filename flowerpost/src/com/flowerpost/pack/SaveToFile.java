package com.flowerpost.pack;

import com.google.gson.GsonBuilder;
import org.json.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class SaveToFile {
    //*TODO* [] Zapis wszystkiego do jednego pliku json.
    //*TODO* [] Dopisanie do klas metod toJson().
    public void SaveToFile(FlowerShop flowerShop, String fileName){
        Gson gson = new GsonBuilder().setDateFormat("yyyyMMdd").setPrettyPrinting().create();
        try {
            Writer writer = Files.newBufferedWriter(Paths.get(fileName +".json"));
            gson.toJson(flowerShop,writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReadFromFile(String fileName){
            Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(fileName + ".json"));
            FlowerShop flowerShopFromFile = gson.fromJson(reader,FlowerShop.class);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    ////TEST\\\\
    public static void main(String[] args) throws JSONException {
        FlowerShop[] flowershops;
        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, "222123456");
        Address TESTSHOP = new Address("29183","WWA","Grzybowa","56a");
        FlowerShop TESTFLOWERSHOP = new FlowerShop(TESTSHOP,"21372137");
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20211212", "20211220");
        GunNRoses.addFlowerToStock(Rose12122021);
        GunNRoses.addFlowerToStock(Rose19122021);
        GunNRoses.addFlowerToStock(PlasticRose);
        TESTFLOWERSHOP.addFlowerToStock(Rose19122021);
        System.out.println(Arrays.toString(GunNRoses.stock));
        System.out.println("#############################################################");
        ////TEST JSON\\\\
        SaveToFile FlowerShopsDB = new SaveToFile();
        FlowerShopsDB.SaveToFile(GunNRoses,"GunNRoses");

        }


}

