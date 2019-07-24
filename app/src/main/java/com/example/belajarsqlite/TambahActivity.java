package com.example.belajarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.belajarsqlite.db.DBSource;
import com.example.belajarsqlite.models.Barang;

public class TambahActivity extends AppCompatActivity {

    EditText edName, edBrand, edPrice;
    Button btnSubmit;

    DBSource dbSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        edName = findViewById(R.id.ed_name);
        edBrand = findViewById(R.id.ed_brand);
        edPrice = findViewById(R.id.ed_price);

        btnSubmit = findViewById(R.id.btn_submit);

        dbSource = new DBSource(this);
        dbSource.open();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tambahData();
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        dbSource.close();
    }

    public void tambahData(){
        String name = null;
        String merk = null;
        String harga = null;

        name = edName.getText().toString().trim();
        merk = edBrand.getText().toString().trim();
        harga = edPrice.getText().toString().trim();

        Barang barang = dbSource.createBarang(name, merk, harga);

        Toast.makeText(TambahActivity.this, "Data baru tersimpan" + barang, Toast.LENGTH_SHORT).show();

        finish();
    }
}
