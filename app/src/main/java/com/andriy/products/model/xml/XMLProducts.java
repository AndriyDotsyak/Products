package com.andriy.products.model.xml;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.andriy.products.model.DBProducts;
import com.andriy.products.model.Model;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.SimpleXmlConverterFactory;

public class XMLProducts implements Model {
    private String API_BASE_URL = "http://ainsoft.pro/";
    private List<Product> productsList;

    private DBProducts dbProducts;

    @Override
    public void getProducts(final Activity activity) {

        dbProducts = new DBProducts(activity);

        final SQLiteDatabase database = dbProducts.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();

        final ProgressDialog loading = ProgressDialog.show(activity,"Получение данных","Пожалуйста подождите...",false,false);

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
                productsList = response.body().product;

                database.delete("products", null, null);

                for (int index = 0; index < productsList.size(); index++) {
                    contentValues.clear();
                    contentValues.put("name", productsList.get(index).getName());
                    contentValues.put("price", productsList.get(index).getPrice());

                    database.insert("products", null, contentValues);
                }

                dbProducts.close();

                loading.dismiss();

            }

            @Override
            public void onFailure(Call<Responce> call, Throwable t) {
                Log.d("Products", "Error: " +t.getLocalizedMessage());
                loading.dismiss();
            }
        });
    }
}