package com.niit.project.user.model;


import org.springframework.web.multipart.MultipartFile;

public class UserImageUpload
{
    private MultipartFile imageFile;

    public UserImageUpload()
    {

    }

    public UserImageUpload(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    @Override
    public String toString() {
        return "UserImageUpload{" +
                "imageFile=" + imageFile +
                '}';
    }
}
