package com.niit.project.favouriteservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FavouriteCuisine
{
    private String emailId;
    @Id
    private long cuisineId;
    private String cuisineName;
    private String cuisineImage;

    public FavouriteCuisine()
    {

    }

    public FavouriteCuisine(String emailId, long cuisineId, String cuisineName, String cuisineImage) {
        this.emailId = emailId;
        this.cuisineId = cuisineId;
        this.cuisineName = cuisineName;
        this.cuisineImage = cuisineImage;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(long cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    public String getCuisineImage() {
        return cuisineImage;
    }

    public void setCuisineImage(String cuisineImage) {
        this.cuisineImage = cuisineImage;
    }

    @Override
    public String toString() {
        return "FavouriteCuisine{" +
                "emailId='" + emailId + '\'' +
                ", cuisineId=" + cuisineId +
                ", cuisineName='" + cuisineName + '\'' +
                ", cuisineImage='" + cuisineImage + '\'' +
                '}';
    }
}
