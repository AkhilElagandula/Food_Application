package com.niit.project.restaurantservice.model;

import org.springframework.web.multipart.MultipartFile;

public class RestaurantImageUpload
{
    private MultipartFile restaurantImage;
    public RestaurantImageUpload()
    {

    }

    public RestaurantImageUpload(MultipartFile restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public MultipartFile getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(MultipartFile restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    @Override
    public String toString() {
        return "RestaurantImageUpload{" +
                "restaurantImage=" + restaurantImage +
                '}';
    }
}
