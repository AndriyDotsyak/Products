package com.andriy.products.controller;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

import com.andriy.products.View.RVShow;
import com.andriy.products.View.View;
import com.andriy.products.model.Model;
import com.andriy.products.model.xml.XMLProducts;

public class Controller {
    private Model model = new XMLProducts();
    private View view = new RVShow();

    public void getData(Activity activity) {
         model.getProducts(activity);
    }

    public void outData(Activity activity, RecyclerView recyclerView) {
        view.showProducts(activity, recyclerView);
    }
}
