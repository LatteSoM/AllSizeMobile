package com.example.allsize;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detail_act extends AppCompatActivity {

    private TextView nodel_name;
    private TextView brand;
    private TextView price;
    private TextView color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        nodel_name = findViewById(R.id.model_name);
        brand = findViewById(R.id.brand_id);
        price = findViewById(R.id.price);
        color = findViewById(R.id.color);

        nodel_name.setText(getIntent().getStringExtra("name"));
        brand.setText(getIntent().getStringExtra("brand"));
        price.setText(getIntent().getStringExtra("price"));
        color.setText(getIntent().getStringExtra("color"));
//        prTxt.setText(getIntent().getStringExtra("pr_id"));

    }
}