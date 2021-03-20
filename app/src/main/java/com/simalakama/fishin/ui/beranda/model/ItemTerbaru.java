package com.simalakama.fishin.ui.beranda.model;

import java.io.Serializable;

public class ItemTerbaru implements Serializable {

    private int imgItem;
    private String namaItem;
    private String hargaItem;

    public ItemTerbaru(int imgItem, String namaItem, String hargaItem) {
        this.imgItem = imgItem;
        this.namaItem = namaItem;
        this.hargaItem = hargaItem;
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
}
