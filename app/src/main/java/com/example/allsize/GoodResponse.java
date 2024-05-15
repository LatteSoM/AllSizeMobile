package com.example.allsize;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GoodResponse {
    @SerializedName("results")
    private List<Good> goodsList;

    private int count;
    private String next;

    private String previous;

    public List<Good> getGoodsList() {
        return goodsList;
    }
}