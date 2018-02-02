package com.andriy.products.View;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andriy.products.R;
import com.andriy.products.model.DBProducts;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ProductsViewHolder> {
    DBProducts dbProducts;
    Activity activity;

    RVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_list, parent, false);
        ProductsViewHolder viewHolder = new ProductsViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        dbProducts = new DBProducts(activity);

        SQLiteDatabase database = dbProducts.getWritableDatabase();
        Cursor cursor = database.query("products", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {

            //int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int priceIndex = cursor.getColumnIndex("price");

            do {
                holder.txtName.setText(cursor.getString(nameIndex));
                holder.txtPrice.setText(cursor.getInt(priceIndex));

                /*Log.d("Products", "id = " +cursor.getInt(idIndex) +
                        "name = " +cursor.getString(nameIndex) +
                        " price = " +cursor.getInt(priceIndex));*/
            } while (cursor.moveToNext());

        } else {
            Log.d("Products", "DB Products = 0");
            cursor.close();
        }

        dbProducts.close();
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        TextView txtPrice;

        ProductsViewHolder(android.view.View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txt_name);
            txtPrice = itemView.findViewById(R.id.txt_price);
        }
    }
}
