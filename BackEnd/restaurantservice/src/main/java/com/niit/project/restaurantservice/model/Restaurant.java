package com.niit.project.restaurantservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Restaurant
{
    @Id
    private int restaurantId;
    private String restaurantName;
    private String restaurantImage;
    private String location;
    private double rating;
    private List<Cuisine> cuisine;

    public Restaurant()
    {
        cuisine = new ArrayList<Cuisine>();
    }

    public Restaurant(int restaurantId, String restaurantName, String restaurantImage, String location, double rating, List<Cuisine> cuisine) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantImage = restaurantImage;
        this.location = location;
        this.rating = rating;
        this.cuisine = cuisine;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Cuisine> getCuisine() {
        return cuisine;
    }

    public void setCuisine(List<Cuisine> cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantImage='" + restaurantImage + '\'' +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                ", cuisine=" + cuisine +
                '}';
    }
}
