package com.example.demo.controller;

import com.example.demo.model.Gallery;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Gallery> getAllImages() {
        return imageService.getAllImages();
    }

    @PostMapping
    public Gallery saveImage(@RequestBody Gallery image) {
        return imageService.saveImage(image);
    }
}
