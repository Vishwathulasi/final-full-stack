package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long galleryId;

    private String galleryTitle;
    private String galleryUrl;
    public Long getGalleryId() {
        return galleryId;
    }
    public void setGalleryId(Long galleryId) {
        this.galleryId = galleryId;
    }
    public String getGalleryTitle() {
        return galleryTitle;
    }
    public void setGalleryTitle(String galleryTitle) {
        this.galleryTitle = galleryTitle;
    }
    public String getGalleryUrl() {
        return galleryUrl;
    }
    public void setGalleryUrl(String galleryUrl) {
        this.galleryUrl = galleryUrl;
    }
    public Gallery() {
    }
    public Gallery(Long galleryId, String galleryTitle, String galleryUrl) {
        this.galleryId = galleryId;
        this.galleryTitle = galleryTitle;
        this.galleryUrl = galleryUrl;
    }
    
}
