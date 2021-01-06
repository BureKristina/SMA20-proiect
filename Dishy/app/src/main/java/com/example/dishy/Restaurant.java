package com.example.dishy;

public class Restaurant {

    String name, spots,rating;
    Integer imageUrl;

    public Restaurant(String name,  Integer imageUrl, String rating, String spots ) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.spots=spots;

    }

    public String getSpots() {
        return spots;
    }

    public void setSpots(String spots) {
        this.spots = spots;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}