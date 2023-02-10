package com.example.lu_foodies.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lu_foodies.R;
import com.example.lu_foodies.connector.HomeCafeConnector;
import com.example.lu_foodies.databinding.FragmentHomeBinding;
import com.example.lu_foodies.models.HomeCafeModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView homeCafeRec;
    List<HomeCafeModel> homeCafeModelList;
    HomeCafeConnector homeCafeConnector;

    @SuppressLint("MissingInflatedId")
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeCafeRec = root.findViewById(R.id.home_cafe_rec);
        homeCafeModelList = new ArrayList<>();

        homeCafeModelList.add(new HomeCafeModel(R.drawable.sandwich, "Sarah's Cafe"));
        homeCafeModelList.add(new HomeCafeModel(R.drawable.fried_potatoes, "MOJO"));
        homeCafeModelList.add(new HomeCafeModel(R.drawable.hamburger, "LU Cafe"));

        homeCafeConnector = new HomeCafeConnector(getActivity(),homeCafeModelList);
        homeCafeRec.setAdapter(homeCafeConnector);

        homeCafeRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeCafeRec.setHasFixedSize(true);
        homeCafeRec.setNestedScrollingEnabled(false);
        return root;
    }
}