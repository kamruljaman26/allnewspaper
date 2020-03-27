package com.example.bdallnewspaper.model;

public class Newspaper {

    public Newspaper(int photo, String url) {
        this.photo = photo;
        this.url = url;
    }

    private  int photo ;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private  String url;

    public Newspaper(){


    }
    //Getter

    public int getPhoto() {
        return photo;
    }

    //Setter


    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
