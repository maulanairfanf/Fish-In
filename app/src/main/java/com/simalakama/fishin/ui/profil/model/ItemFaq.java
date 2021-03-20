package com.simalakama.fishin.ui.profil.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemFaq {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> faq = new HashMap<>();

        List<String> faq_pertama = new ArrayList<>();
        faq_pertama.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vestibulum blandit laoreet.");

        List<String> faq_kedua = new ArrayList<>();
        faq_kedua.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vestibulum blandit laoreet.");

        List<String> faq_ketiga = new ArrayList<>();
        faq_ketiga.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus vestibulum blandit laoreet.");

        faq.put("Apa itu Fish-in ?", faq_pertama);
        faq.put("Bagaimana cara memesan ?", faq_kedua);
        faq.put("Mengapa Fish-in ?", faq_ketiga);
        return faq;
    }
}
