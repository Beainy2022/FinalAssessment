package com.Eurisko.Final.Exam.PhotoAlbumGallery.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "albums")
public class Album {
    @Id
    private Integer id;

    private String title;

    @Field("userId")
    private Integer userId;


    public Album() {}

    public Album(Integer id, String title, Integer userId) {
        this.id = id;
        this.title = title;
        this.userId = userId;
    }


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


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

