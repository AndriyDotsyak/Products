package com.andriy.products.View;

import android.util.Log;

import com.andriy.products.controller.Products;

public class RecycleView implements View {
    @Override
    public void showProducts(Products products) {
        Log.d("Products", "Products: " +
                "id = " +products.getId() +
                ", name = " +products.getName() +
                ", price = " +products.getPrice());
    }
}
