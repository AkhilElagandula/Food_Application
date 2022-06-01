package com.niit.project.restaurantservice.controller;

import com.niit.project.restaurantservice.model.RestaurantImageUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@CrossOrigin("*")
@RestController
@RequestMapping("/foodieApp/restaurantImage")
public class RestaurantImageController
{
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addRestaurantImage(@ModelAttribute RestaurantImageUpload restaurantImageUpload)
    {
        System.out.println("started");
        if(restaurantImageUpload.getRestaurantImage()!=null)
        {
            System.out.println("entered");

            System.out.println("image name :" + restaurantImageUpload.getRestaurantImage().getOriginalFilename());
            System.out.println(" location :" + System.getProperty("restaurantservice.dir"));
            String localPath = System.getProperty("restaurantservice.dir");
            try{
                Path path = Paths.get(localPath+ "\\images\\");
                Files.copy(restaurantImageUpload.getRestaurantImage().getInputStream(),path.resolve(restaurantImageUpload.getRestaurantImage().getOriginalFilename() + ".jpg"));

            }

            catch (IOException io)
            {
                io.printStackTrace();
            }
        }

//        RedirectView redirectView = new RedirectView();
//        redirectView.setUrl("http://localhost:5555/foodieApp/restaurant/getRestaurant");

        return new ResponseEntity<>("image uploaded", HttpStatus.OK);

    }

    @GetMapping(value = "/image/{restaurantName}",produces=MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getRestaurantImage(@PathVariable String restaurantName) throws IOException{
        String localPath = System.getProperty("restaurantservice.dir");
        HttpHeaders headers = new HttpHeaders();
        Path path = Paths.get(localPath + "\\images\\" + restaurantName + ".jpg");
        byte[] media = Files.readAllBytes(path);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media,HttpStatus.OK);
        return responseEntity;
    }
}
