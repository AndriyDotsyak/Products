package com.andriy.products;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andriy.products.controller.Controller;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDownloadXML;
    Button btnProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownloadXML = findViewById(R.id.btn_downloadXML);
        btnProductList= findViewById(R.id.btn_productList);

        btnDownloadXML.setOnClickListener(this);
        btnProductList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_downloadXML:
                Controller controller = new Controller();
                controller.getData(this);
                break;
            case R.id.btn_productList:
                Intent intent = new Intent("android.intent.ProductList");
                startActivity(intent);
                break;
        }
    }
}
