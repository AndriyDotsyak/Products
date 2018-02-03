package com.andriy.products.View.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.andriy.products.View.View;

public class RVShow implements View {

    @Override
    public void showProducts(final Activity activity, RecyclerView recyclerView) {

        RVAdapter adapter = new RVAdapter(activity.getApplicationContext());
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(activity, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(android.view.View view, int position) {
                        Intent intent = new Intent("android.intent.ChangePrice");
                        intent.putExtra("ClickItem", position);
                        activity.startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(android.view.View view, int position) {

                    }
                })
        );
    }
}