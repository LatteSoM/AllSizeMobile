package com.example.allsize;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Good {
    public int id;

//    public String getModel_name() {
//        return model_name;
//    }

//    public String getMain_pic() {
//        return main_pic;
//    }

    public String model_name;
    public String main_pic;
    public String description;
    public int price;
    public int price_with_sale;
    public String articul;
    public boolean sale_confirmed;
    public int category;
    public int brand_id;
    public int color_id;
    public ArrayList<Integer> size;
}
