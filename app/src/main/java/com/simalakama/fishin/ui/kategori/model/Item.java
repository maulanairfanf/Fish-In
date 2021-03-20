package com.simalakama.fishin.ui.kategori.model;

import java.io.Serializable;

public class Item implements Serializable {

    private int imgItem;
    private String namaItem;
    private float ratingItem;
    private String hargaItem;
    private String reviewItem;

    public Item(int imgItem, String namaItem, float ratingItem, String hargaItem, String reviewItem) {
        this.imgItem = imgItem;
        this.namaItem = namaItem;
        this.ratingItem = ratingItem;
        this.reviewItem = reviewItem;
        this.hargaItem = hargaItem;
    }

    public int getImgItem() {
        return imgItem;
    }

    public String getNamaItem() {
        return namaItem;
    }

    public float getRatingItem() {
        return ratingItem;
    }

    public String getReviewItem() {
        return reviewItem;
    }

    public String getHargaItem() {
        return hargaItem;
    }
}
