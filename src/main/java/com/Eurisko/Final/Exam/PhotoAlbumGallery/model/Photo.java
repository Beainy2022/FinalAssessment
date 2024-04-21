package com.Eurisko.Final.Exam.PhotoAlbumGallery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Photo {
    @Id
    private Integer id;

    private String title;

    private String url; //actual photo
    private String thumbnailUrl; //thumbnailUrl version of photo
    @DBRef
    private Album album; // Reference to the Album entity
//allows you to maintain a clear relationship between each photo
// and its corresponding album without duplicating album data in each photo document.

    public Photo() {}

    public Photo(Integer id, String title, String url, String thumbnailUrl, Album album) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
        this.album = album;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
