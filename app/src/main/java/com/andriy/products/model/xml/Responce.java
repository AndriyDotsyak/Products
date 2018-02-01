package com.andriy.products.model.xml;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "xml", strict = false)
public class Responce {

    @ElementList(name = "product", inline = true)
    @Path("products")
    public List<Product> product;

}