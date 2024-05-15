package com.example.allsize;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ColorResponse {

    @SerializedName("result")
    private List<Color> colorsList;

    private int count;
    private String next;

    private String previous;

    public List<Color> getColorsList() {
        return colorsList;
    }

}
