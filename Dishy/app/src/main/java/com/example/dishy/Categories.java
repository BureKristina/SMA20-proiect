package com.example.dishy;

public class Categories {

    String category;
    Integer imageUrl;

    public Categories(String name, Integer image){

        this.category=name;
        imageUrl=image;
    }

    public String getName() {
        return category;
    }


    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.category = name;
    }


    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
