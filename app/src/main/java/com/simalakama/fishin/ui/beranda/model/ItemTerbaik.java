package com.simalakama.fishin.ui.beranda.model;

import java.io.Serializable;

public class ItemTerbaik implements Serializable {

    private int imgItem;
    private String namaItem;
    private String hargaItem;
    private String hargaDiskon;
    private String diskonItem;

    public ItemTerbaik(int imgItem, String namaItem, String hargaItem, String hargaDiskon, String diskonItem) {
        this.imgItem = imgItem;
        this.namaItem = namaItem;
        this.hargaItem = hargaItem;
        this.hargaDiskon = hargaDiskon;
        this.diskonItem = diskonItem;
    }

    public int getImgItem() {
        return imgItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public String getHargaItem() {
        return hargaItem;
    }

    public String getHargaDiskon() {
        return hargaDiskon;
    }

    public String getDiskonItem() {
        return diskonItem;
    }
}
