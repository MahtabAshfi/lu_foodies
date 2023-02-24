package com.example.lu_foodies.connector;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lu_foodies.R;
import com.example.lu_foodies.models.HomeCafeModel;
import com.example.lu_foodies.models.HomeItemModel;

import java.util.ArrayList;

public class HomeCafeConnector extends RecyclerView.Adapter<HomeCafeConnector.ViewHolder> {

    UpdateItem updateItem;
    Activity activity;
    ArrayList<HomeCafeModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeCafeConnector(UpdateItem updateItem, Activity activity, ArrayList<HomeCafeModel> list) {
        this.updateItem = updateItem;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cafe_name,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeItemModel> homeItemModels = new ArrayList<>();
            homeItemModels.add(new HomeItemModel(R.drawable.sandwich, "Sandwich", "8.00AM-5.00PM", "60Tk"));
            homeItemModels.add(new HomeItemModel(R.drawable.burger, "Burger", "8.00AM-5.00PM", "60Tk"));
            homeItemModels.add(new HomeItemModel(R.drawable.pizza, "Pizza", "8.00AM-5.00PM", "50Tk"));
            homeItemModels.add(new HomeItemModel(R.drawable.biryani, "Biryani", "8.00AM-5.00PM", "90Tk"));
            homeItemModels.add(new HomeItemModel(R.drawable.khichuri, "Khichuri", "8.00AM-5.00PM", "60Tk"));

            updateItem.callBack(position, homeItemModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();

                if (position == 0){
                    ArrayList<HomeItemModel> homeItemModels = new ArrayList<>();
                    homeItemModels.add(new HomeItemModel(R.drawable.sandwich,"Sandwich","8.00AM-5.00PM", "60Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.burger,"Burger","8.00AM-5.00PM", "60Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.pizza,"Pizza","8.00AM-5.00PM", "50Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.biryani,"Biryani","8.00AM-5.00PM", "90Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.khichuri,"Khichuri","8.00AM-5.00PM", "60Tk"));


                    updateItem.callBack(position,homeItemModels);
                }
                else if (position == 1){
                    ArrayList<HomeItemModel> homeItemModels = new ArrayList<>();
                    homeItemModels.add(new HomeItemModel(R.drawable.khichuri,"Khichuri","8.00AM-5.00PM", "20Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.alu_chop,"Alu Chop","8.00AM-5.00PM", "5Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.piyaju,"Piyazu","8.00AM-5.00PM", "1Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.samosa,"Samosa","8.00AM-5.00PM", "7Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.singara,"Singara","8.00AM-5.00PM", "7Tk"));

                    updateItem.callBack(position,homeItemModels);
                }
                else if (position == 2) {
                    ArrayList<HomeItemModel> homeItemModels = new ArrayList<>();
                    homeItemModels.add(new HomeItemModel(R.drawable.khichuri, "Khichuri", "8.00AM-5.00PM", "50Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.alu_chop, "Alu Chop", "8.00AM-5.00PM", "15Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.biryani, "Biryani", "8.00AM-5.00PM", "60Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.chicken_roll, "Chicken Roll", "8.00AM-5.00PM", "20Tk"));
                    homeItemModels.add(new HomeItemModel(R.drawable.shwarma, "Shwarma", "8.00AM-5.00PM", "60Tk"));

                    updateItem.callBack(position, homeItemModels);
                }
            }
        });
        if (select){
            if (position == 0){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
                select = false;
            }
        }
        else {
            if (row_index == position){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
            }
            else{
                holder.cardView.setBackgroundResource(R.drawable.default_bg);
            }
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cafe_img);
            name = itemView.findViewById(R.id.cafe_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
