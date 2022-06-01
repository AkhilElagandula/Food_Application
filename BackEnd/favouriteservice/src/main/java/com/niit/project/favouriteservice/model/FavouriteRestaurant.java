package com.niit.project.favouriteservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FavouriteRestaurant
{
    @Id
    private long restaurantId;
    private String restaurantName;
    private String location;
    private String restaurantImage;
    private double rating;
    private String emailId;

    public FavouriteRestaurant()
    {

    }

    public FavouriteRestaurant(long restaurantId, String restaurantName, String location, String restaurantImage, double rating, String emailId) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        this.restaurantImage = restaurantImage;
        this.rating = rating;
        this.emailId = emailId;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "FavouriteRestaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", location='" + location + '\'' +
                ", restaurantImage='" + restaurantImage + '\'' +
                ", rating=" + rating +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
