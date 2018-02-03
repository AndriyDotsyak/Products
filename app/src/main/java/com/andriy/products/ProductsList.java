package com.andriy.products;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.andriy.products.controller.Controller;

public class ProductsList extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producst_list);

        recyclerView = findViewById(R.id.rv_products);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Controller controller = new Controller();
        controller.outData(this, recyclerView);
    }
}
