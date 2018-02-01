package com.andriy.products.model.xml;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {

    @GET("/test/test.xml")
    Call<Responce> getProducts();

}