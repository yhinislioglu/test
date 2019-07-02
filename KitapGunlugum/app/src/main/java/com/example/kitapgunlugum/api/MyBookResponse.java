package com.example.kitapgunlugum.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MyBookResponse implements Serializable {
    @SerializedName("pk")
    String pk;
    @SerializedName("book_name")
    String book_name;
    @SerializedName("sub_title")
    String sub_title;
    @SerializedName("page_number")
    String page_number;
    @SerializedName("barcode")
    String barcode;
    @SerializedName("exam")
    String exam;
    @SerializedName("author")
    String author;
    @SerializedName("type")
    String type;
    @SerializedName("language")
    String language;
    @SerializedName("description")
    String description;

    public String getPk() {
        return pk;
    }

    public String getBook_name() {
        return book_name;
    }

    public String getSub_title() {
        return sub_title;
    }

    public String getPage_number() {
        return page_number;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getExam() {
        return exam;
    }

    public String getAuthor() {
        return author;
    }

    public String getType() {
        return type;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }




}
