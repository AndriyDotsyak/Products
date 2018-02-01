package com.andriy.products.model.xml;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "product", strict = false)
public class Product {

    @Element(name = "id")
    private String id;
    @Element(name = "name")
    private String name;
    @Element(name = "price")
    private String price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}