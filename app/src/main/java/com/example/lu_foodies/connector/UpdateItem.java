package com.example.lu_foodies.connector;

import com.example.lu_foodies.models.HomeItemModel;

import java.util.ArrayList;

public interface UpdateItem {
    public void callBack(int position, ArrayList<HomeItemModel>list);
}
