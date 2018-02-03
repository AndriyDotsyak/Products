package com.andriy.products.View.RecyclerView;

import com.andriy.products.R;
import com.andriy.products.model.DBProducts;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;

    RVAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RVAdapter.ViewHolder holder, int position) {

        DBProducts dbProducts = new DBProducts(context);
        SQLiteDatabase db = dbProducts.getWritableDatabase();

        Cursor cursor = db.query("products", null, "id = ?", new String[] {String.valueOf(position+1)}, null, null, null);

        if (cursor.moveToFirst()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            int price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));

            holder.txtName.setText(name);
            holder.txtPrice.setText(String.valueOf(price));
        }

        cursor.close();
        dbProducts.close();

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtName, txtPrice;

        ViewHolder(View view){
            super(view);

            txtName = view.findViewById(R.id.txt_name);
            txtPrice = view.findViewById(R.id.txt_price);

        }
    }
}