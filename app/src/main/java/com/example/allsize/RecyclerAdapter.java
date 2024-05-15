package com.example.allsize;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Good> goodsList;

    private List<Color> colorsList;

    public RecyclerAdapter(Context context, List<Good> goodsList){
        this.context = context;
        this.goodsList = goodsList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        Good goods = goodsList.get(position);

        holder.model_name.setText(goods.model_name);


        // Set text to TextViews
        holder.price.setText(String.valueOf(goods.price));
        holder.color.setText(String.valueOf(goods.color_id));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detail_act.class);
                intent.putExtra("name",goods.model_name);
                intent.putExtra("color", String.valueOf(goods.color_id));
                intent.putExtra("price", String.valueOf(goods.price));
                intent.putExtra("brand", String.valueOf(goods.brand_id));
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
//        holder.price.setText(goods.price);
//        Picasso.with(context).load("https://allsizs.com/media/image/IMG_8077.webp").into(holder.imga);
//        Uri uri = Uri.parse("https://allsizs.com/media/image/IMG_8077.webp");
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                        .setUri("https://allsizs.com/media/image/IMG_8077.webp")
//                                .setAutoPlayAnimations(true)
//                                        .build();
//       holder.imga.setController(controller);

//       holder.imga.setImageURI(uri);

    }

    @Override
    public int getItemCount() {
        return goodsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView model_name;
        TextView color;
        TextView price;
//        SimpleDraweeView imga;
        ViewHolder(View view){
            super(view);
            model_name = view.findViewById(R.id.model_name);
            color = view.findViewById(R.id.color);
            price = view.findViewById(R.id.price);
//            imga = view.findViewById(R.id.image);
        }
    }

}
