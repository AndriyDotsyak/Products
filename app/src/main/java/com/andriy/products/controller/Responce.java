package com.andriy.products.controller;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "Products", strict = false)
public class Responce {
    @ElementList(inline = true)
    public List<Products> products;
}
