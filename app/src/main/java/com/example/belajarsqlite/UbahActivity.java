package com.example.belajarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.belajarsqlite.db.DBSource;
import com.example.belajarsqlite.models.Barang;

public class UbahActivity extends AppCompatActivity {

    EditText edName, edBrand, edPrice;
    TextView tvId;
    Button btnSubmit, btnCancel;

    DBSource dbSource;
    long id;
    String nama, harga, merk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        edName = findViewById(R.id.ed_name);
        edBrand = findViewById(R.id.ed_brand);
        edPrice = findViewById(R.id.ed_price);

        tvId = findViewById(R.id.tv_id);

        btnSubmit = findViewById(R.id.btn_submit);
        btnCancel = findViewById(R.id.btn_cancel);

        dbSource = new DBSource(this);
        dbSource.open();

        Bundle bun = this.getIntent().getExtras();

        id = bun.getLong("id");
        nama = bun.getString("nama");
        merk = bun.getString("merk");
        harga = bun.getString("harga");

        tvId.setText("" + id);
        edName.setText(nama);
        edBrand.setText(merk);
        edPrice.setText(harga);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData(id);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData(id);
            }
        });

    }

    private void updateData(long id) {
        Barang barang = new Barang();

        barang.setName(edName.getText().toString().trim());
        barang.setMerk(edBrand.getText().toString().trim());
        barang.setHarga(edPrice.getText().toString().trim());
        barang.setId(id);

        dbSource.updateBarang(barang);

        Intent intent = new Intent(UbahActivity.this, TampilActivity.class);
        startActivity(intent);
        UbahActivity.this.finish();
    }

    private void deleteData(long id){
        dbSource.deleteBarang(id);

        Intent intent = new Intent(UbahActivity.this, TampilActivity.class);
        startActivity(intent);
        UbahActivity.this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        dbSource.close();
    }
}
