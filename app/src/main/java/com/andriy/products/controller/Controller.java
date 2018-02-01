package com.andriy.products.controller;

import com.andriy.products.View.RecycleView;
import com.andriy.products.View.View;
import com.andriy.products.model.Model;
import com.andriy.products.model.xml.Product;
import com.andriy.products.model.xml.XMLProducts;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Model model = new XMLProducts();
    View view = new RecycleView();

    public void execute() {
        List<Product> products = model.getProducts();
        //view.showProducts(products);
    }
}
