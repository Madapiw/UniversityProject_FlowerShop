package com.flowerpost.pack;

import org.json.*;

import java.util.Arrays;
import java.util.Objects;

public class File {
    public String FileName = "FlowerShops_db";
    public Objects FlowerShops = null;
    public Objects Deliveries = null; // work in progress not tested

    public String getFileName() {
        return FileName;
    }

    public void setFileName(String fileName) {
        FileName = fileName;
    }

    public Objects getFlowerShops() {
        return FlowerShops;
    }

    public void setFlowerShops(Objects flowerShops) {
        FlowerShops = flowerShops;
    }

    public Objects getDeliveries() {
        return Deliveries;
    }

    public void setDeliveries(Objects deliveries) {
        Deliveries = deliveries;
    }

    //*TODO* [] Zapis wszystkiego do jednego pliku json.
    //*TODO* [] Dopisanie do klas metod toJson().
    public JSONObject SaveToJson(FlowerShop Fshop, String FlowerShopName) throws JSONException{
        JSONObject FlowerShops = new JSONObject(); // main
        JSONObject flowershop = new JSONObject(); // secondary
        JSONObject FlowerShopAddress = new JSONObject();
        JSONArray FlowersJson = new JSONArray();
        try {
            //FlowerShop Address to json
            FlowerShopAddress.put("postalCode", Fshop.flowerShopAddress.postalCode);
            FlowerShopAddress.put("townName", Fshop.flowerShopAddress.townName);
            FlowerShopAddress.put("streetName", Fshop.flowerShopAddress.streetName);
            FlowerShopAddress.put("buildingNumber", Fshop.flowerShopAddress.buildingNumber);
            flowershop.put("Address",FlowerShopAddress);
            FlowerShops.put(FlowerShopName, flowershop);
            //FlowerShop PhoneNumber to json
            flowershop.put("phoneNumber",Fshop.phoneNumber);
            //FlowerShop Stock to json
            for(Flower flower : Fshop.stock){
                FlowersJson.put(flower.toJson());
            }
            flowershop.put("Flowers stock",FlowersJson);
        }
        catch(JSONException exception) {
            exception.printStackTrace();
            }
            return FlowerShops;
        }

    ////TEST\\\\
    public static void main(String[] args) throws JSONException {
        Address GunNRosesAddress = new Address("98101", "Seattle", "Cobain", "27");
        FlowerShop GunNRoses = new FlowerShop(GunNRosesAddress, 222123456);
        NaturalFlower Rose19122021 = new NaturalFlower("rose", "red", 30, 12.50F, "20211219", "20220119");
        SyntheticFlower PlasticRose = new SyntheticFlower("rose", "white", "plastic", 15, 7.50F,"20211219");
        NaturalFlower Rose12122021 = new NaturalFlower("rose", "red", 13, 12.50F, "20211212", "20211220");
        Rose19122021.setAvailability(true);
        Rose12122021.setAvailability(true);
        PlasticRose.setAvailability(true);
        GunNRoses.addFlowerToStock(Rose12122021);
        GunNRoses.addFlowerToStock(Rose19122021);
        GunNRoses.addFlowerToStock(PlasticRose);
        System.out.println(Arrays.toString(GunNRoses.stock));
        System.out.println("#############################################################");
        ////TEST JSON\\\\
        File FlowerShopsDB = new File();
        System.out.println(FlowerShopsDB.SaveToJson(GunNRoses,"GunNRosses"));

        }


}

