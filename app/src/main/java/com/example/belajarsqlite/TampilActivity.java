package com.example.belajarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.belajarsqlite.db.DBSource;
import com.example.belajarsqlite.models.Barang;

import java.util.ArrayList;

public class TampilActivity extends AppCompatActivity {

    ListView listView;

    private DBSource dbSource;
    private ArrayList<Barang> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        listView = findViewById(R.id.listview);

        dbSource = new DBSource(this);
        dbSource.open();

        values = dbSource.getAllBarang();

        ArrayAdapter<Barang> adapter = new ArrayAdapter<Barang>(this,
                android.R.layout.simple_list_item_1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Barang barang = (Barang) adapterView.getAdapter().getItem(i);
                editData(barang.getId());
            }
        });
    }

    private void editData(long id) {
        Barang b = dbSource.getBarang(id);

        Intent intent = new Intent(TampilActivity.this, UbahActivity.class);

        Bundle bundle = new Bundle();
        bundle.putLong("id", b.getId());
        bundle.putString("nama", b.getName());
        bundle.putString("merk", b.getMerk());
        bundle.putString("harga", b.getHarga());

        intent.putExtras(bundle);
        TampilActivity.this.finish();
        startActivity(intent);

    }
}
