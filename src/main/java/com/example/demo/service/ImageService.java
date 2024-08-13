package com.example.demo.service;

import com.example.demo.model.Gallery;
import com.example.demo.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Gallery> getAllImages() {
        return imageRepository.findAll();
    }

    public Gallery saveImage(Gallery image) {
        return imageRepository.save(image);
    }
}
