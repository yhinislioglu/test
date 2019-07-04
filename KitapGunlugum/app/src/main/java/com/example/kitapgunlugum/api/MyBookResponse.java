package com.example.kitapgunlugum.api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyBookResponse {

    @SerializedName("pk")
    @Expose
    private Integer pk;
    @SerializedName("book_name")
    @Expose
    private String bookName;
    @SerializedName("sub_title")
    @Expose
    private Object subTitle;
    @SerializedName("page_number")
    @Expose
    private String pageNumber;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("exam")
    @Expose
    private List<Object> exam = null;
    @SerializedName("author")
    @Expose
    private List<Object> author = null;
    @SerializedName("type")
    @Expose
    private List<Object> type = null;
    @SerializedName("language")
    @Expose
    private Object language;
    @SerializedName("description")
    @Expose
    private Object description;

    public MyBookResponse(Integer pk,String bookName,Object subTitle,String pageNumber,String barcode,List<Object> exam,List<Object> author,List<Object> type,Object language,Object description)
    {
        this.pk = pk;
        this.bookName = bookName;
        this.subTitle = subTitle;
        this.pageNumber = pageNumber;
        this.barcode = barcode;
        this.exam = exam;
        this.author = author;
        this.type = type;
        this.language = language;
        this.description = description;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Object getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(Object subTitle) {
        this.subTitle = subTitle;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public List<Object> getExam() {
        return exam;
    }

    public void setExam(List<Object> exam) {
        this.exam = exam;
    }

    public List<Object> getAuthor() {
        return author;
    }

    public void setAuthor(List<Object> author) {
        this.author = author;
    }

    public List<Object> getType() {
        return type;
    }

    public void setType(List<Object> type) {
        this.type = type;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

}
