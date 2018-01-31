package com.andriy.products.model;

import android.app.ProgressDialog;
import android.util.Log;

import com.andriy.products.MainActivity;
import com.andriy.products.controller.Products;
import com.andriy.products.controller.Responce;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;

public class XMLProducts implements Model {
    private Products products = new Products();

    private String API_BASE_URL = "http://ainsoft.pro/";
    private List<Products> kk;

    @Override
    public Products getProducts() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        ProductAPI api = retrofit.create(ProductAPI.class);

        Call<Responce> call = api.getProducts();
        call.enqueue(new Callback<Responce>() {
            @Override
            public void onResponse(Call<Responce> call, Response<Responce> response) {
                kk = response.body().products;
                ArrayList<Products> p = new ArrayList<>(kk);
            }

            @Override
            public void onFailure(Call<Responce> call, Throwable t) {

            }
        });
        return products;
    }
}
