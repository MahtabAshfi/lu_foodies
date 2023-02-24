package com.example.lu_foodies.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lu_foodies.R;
import com.example.lu_foodies.connector.HomeCafeConnector;
import com.example.lu_foodies.connector.HomeItemConnector;
import com.example.lu_foodies.connector.UpdateItem;
import com.example.lu_foodies.models.HomeCafeModel;
import com.example.lu_foodies.models.HomeItemModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateItem {

    RecyclerView homeCafeRec,homeItemRec;
    ArrayList<HomeCafeModel> homeCafeModelList;
    HomeCafeConnector homeCafeConnector;

    ArrayList<HomeItemModel> homeItemModelList;
    HomeItemConnector homeItemConnector;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeCafeRec = root.findViewById(R.id.home_cafe_rec);
        homeItemRec = root.findViewById(R.id.home_item_rec);

        /////// Horizontal Recyclerview ///////
        homeCafeModelList = new ArrayList<>();
        homeCafeModelList.add(new HomeCafeModel(R.drawable.sandwich1, "Sarah's Cafe"));
        homeCafeModelList.add(new HomeCafeModel(R.drawable.fried_potatoes, "MOJO"));
        homeCafeModelList.add(new HomeCafeModel(R.drawable.hamburger, "LU Cafe"));

        homeCafeConnector = new HomeCafeConnector(this,getActivity(),homeCafeModelList);
        homeCafeRec.setAdapter(homeCafeConnector);
        homeCafeRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));


        /////// Vertical Recyclerview ///////
        homeItemModelList = new ArrayList<>();

        homeItemConnector = new HomeItemConnector(getActivity(),homeItemModelList);
        homeItemRec.setAdapter(homeItemConnector);
        homeItemRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        homeItemRec.setHasFixedSize(true);
        homeItemRec.setNestedScrollingEnabled(false);

        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeItemModel> list) {
        homeItemConnector = new HomeItemConnector(getContext(),list);
        homeItemConnector.notifyDataSetChanged();
        homeItemRec.setAdapter(homeItemConnector);
    }
}