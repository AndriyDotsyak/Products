package com.andriy.products;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andriy.products.model.DBProducts;

public class ChangePrice extends AppCompatActivity implements View.OnClickListener {
    private EditText etPrice;
    private Button btnOK;

    private DBProducts dbProducts;
    private SQLiteDatabase db;

    private int position;
    private int price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_price);

        etPrice = findViewById(R.id.et_price);

        btnOK = findViewById(R.id.btn_ok);
        btnOK.setOnClickListener(this);

        position = getIntent().getIntExtra("ClickItem", 0);

        dbProducts = new DBProducts(this);
        db = dbProducts.getWritableDatabase();

        getItemDataBase();

        etPrice.setText(String.valueOf(price));
    }

    private void getItemDataBase() {
        Cursor cursor = db.query("products", null, "id = ?", new String[] {String.valueOf(position+1)}, null, null, null);

        if (cursor.moveToFirst()) {
            price = cursor.getInt(cursor.getColumnIndexOrThrow("price"));
        }

        cursor.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:

                ContentValues cv = new ContentValues();
                cv.put("price", etPrice.getText().toString());
                db.update("products", cv, "id=" + String.valueOf(position+1), null);

                dbProducts.close();

                this.finish();

                break;
        }
    }
}
