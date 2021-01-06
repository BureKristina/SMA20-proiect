package com.example.dishy;

public class TopRated {

    String name;
    String spots;
    Integer imageUrl;

    public TopRated(String name, String spots, Integer image){
        this.spots=spots;
        this.name=name;
        imageUrl=image;
    }

    public String getName() {
        return name;
    }

    public String getSpots() {
        return spots;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

}
