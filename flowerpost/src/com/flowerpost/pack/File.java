package com.flowerpost.pack;

import java.sql.Date;
import java.util.concurrent.Flow;

import org.json.*;

public class File {


    ////TEST\\\\
    public static void main(String[] args) throws JSONException {
        JSONArray Flowers =new JSONArray();
        Flowers.put("róża czerwona");
        Flowers.put("róża biała");
        Flowers.put("róża różowa");
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("Flowers",Flowers);
        //JSONArray listOfFlowers = new JSONArray(jsonObj);

        System.out.println(jsonObj);
        }
    }
