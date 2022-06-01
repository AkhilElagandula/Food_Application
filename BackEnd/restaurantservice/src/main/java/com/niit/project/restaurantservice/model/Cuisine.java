package com.niit.project.restaurantservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Cuisine
{
    @Id
    private String cuisineName;
    private String cuisineImage;

    public Cuisine()
    {

    }

    public Cuisine( String cuisineName, String cuisineImage) {

        this.cuisineName = cuisineName;
        this.cuisineImage = cuisineImage;
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
        return "Cuisine{" +
                ", cuisineName='" + cuisineName + '\'' +
                ", cuisineImage='" + cuisineImage + '\'' +
                '}';
    }
}
