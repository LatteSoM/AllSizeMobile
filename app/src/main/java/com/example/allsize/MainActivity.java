package com.example.allsize;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView goodsRecucler;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        goodsRecucler = findViewById(R.id.list_gods);

        apiInterface = ServiceBuilder.BuildRequest().create(ApiInterface.class);

//        Call<ArrayList<Good>> getGoodsList = apiInterface.getGoodsList();
//
//        getGoodsList.enqueue(new Callback<ArrayList<Good>>() {
//            @Override
//            public void onResponse(Call<ArrayList<Good>> call, Response<ArrayList<Good>> response) {
//                if (response.isSuccessful()){
//                    goodsRecucler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                    goodsRecucler.setHasFixedSize(false);
//                    ArrayList<Good> listGood = response.body();
//                    RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(), listGood);
//                    goodsRecucler.setAdapter(adapter);
//                    }
//                else {
//                    Toast.makeText(MainActivity.this, "Ошибка на стороне клиента", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<Good>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

        Call<GoodResponse> getGoodsList = apiInterface.getGoodsList();

        getGoodsList.enqueue(new Callback<GoodResponse>() {
            @Override
            public void onResponse(Call<GoodResponse> call, Response<GoodResponse> response) {
                if (response.isSuccessful()) {
                    goodsRecucler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    goodsRecucler.setHasFixedSize(true);
                    List<Good> listGood = response.body().getGoodsList();
                   // goodsRecucler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));// Получаем список товаров из ответа
                    RecyclerAdapter adapter = new RecyclerAdapter(getApplicationContext(),  listGood);
                    goodsRecucler.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Ошибка на стороне сервера", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GoodResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });




    }
}