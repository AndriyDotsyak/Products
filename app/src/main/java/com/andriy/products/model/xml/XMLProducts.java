package com.andriy.products.model.xml;

import android.util.Log;

import com.andriy.products.model.Model;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;

public class XMLProducts implements Model {
    private String API_BASE_URL = "http://ainsoft.pro/";
    private List<Product> kk;

    @Override
    public List<Product> getProducts() {

        //final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        final ProductAPI api = retrofit.create(ProductAPI.class);

        Call<Responce> call = api.getProducts();
        call.enqueue(new Callback<Responce>() {
            @Override
            public void onResponse(Call<Responce> call, Response<Responce> response) {
                kk = response.body().product;
                ArrayList<Product> p = new ArrayList<>(kk);

                Log.d("Products", "Response:" +kk.get(1).getName());
                //loading.dismiss();

            }

            @Override
            public void onFailure(Call<Responce> call, Throwable t) {
                Log.d("Products", "Error: " +t.getLocalizedMessage());
                //loading.dismiss();
            }
        });

        return kk;
    }
}