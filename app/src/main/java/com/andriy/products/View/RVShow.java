package com.andriy.products.View;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RVShow implements View {
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void showProducts(Activity activity, RecyclerView recyclerView) {

        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RVAdapter(activity);
        recyclerView.setAdapter(adapter);

    }
}