package com.andriy.products.controller;

import com.andriy.products.View.RecycleView;
import com.andriy.products.View.View;
import com.andriy.products.model.Model;
import com.andriy.products.model.XMLProducts;

public class Controller {
    Model model = new XMLProducts();
    View view = new RecycleView();

    public void execute() {
        Products products = model.getProducts();
        view.showProducts(products);
    }
}
