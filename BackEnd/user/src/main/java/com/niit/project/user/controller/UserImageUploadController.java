package com.niit.project.user.controller;

import com.niit.project.user.model.UserImageUpload;
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
@RequestMapping("/foodieApp/profile")
public class UserImageUploadController
{
    @PostMapping(value = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProfilePicture(@ModelAttribute UserImageUpload userImageUpload)
    {
        System.out.println("started");
        if(userImageUpload.getImageFile()!=null)
        {
            System.out.println("entered");

            System.out.println("image name :" + userImageUpload.getImageFile().getOriginalFilename());
            System.out.println(" location :" + System.getProperty("user.dir"));
            String localPath = System.getProperty("user.dir");
            try{
                Path path = Paths.get(localPath+ "\\images\\");
                Files.copy(userImageUpload.getImageFile().getInputStream(),path.resolve(userImageUpload.getImageFile().getOriginalFilename() + ".jpg"));

            }

            catch (IOException io)
            {
                io.printStackTrace();
            }
        }

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:5555/foodieApp/restaurant/getRestaurant");

        return new ResponseEntity<>(redirectView, HttpStatus.OK);

    }

    @GetMapping(value = "/image/{emailId}",produces=MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getUserImage(@PathVariable String emailId) throws IOException{
        String localPath = System.getProperty("user.dir");
        HttpHeaders headers = new HttpHeaders();
        Path path = Paths.get(localPath + "\\images\\" + emailId + ".jpg");
        byte[] media = Files.readAllBytes(path);
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media,HttpStatus.OK);
        return responseEntity;
        }
}
