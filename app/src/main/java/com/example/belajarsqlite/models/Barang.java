package com.example.belajarsqlite.models;

public class Barang {

    private long id;
    private String name;
    private String harga;
    private String merk;

    public Barang() {
    }

    @Override
    public String toString() {
        return "Barang" +
                "id=" + id +
                "name = " + name +
                "harga = " + harga +
                "merk = " + merk;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }
}
