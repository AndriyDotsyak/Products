package com.andriy.products.View;

import android.util.Log;

import com.andriy.products.model.xml.Product;

import java.util.ArrayList;
import java.util.List;

public class RecycleView implements View {
    @Override
    public void showProducts(List<Product> products) {
        Log.d("Products", "Products: " +
                "id = " +products.get(0).getId() +
                ", name = " +products.get(0).getName() +
                ", price = " +products.get(0).getPrice());
    }
}
