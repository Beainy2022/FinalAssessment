package com.Eurisko.Final.Exam.PhotoAlbumGallery.advice.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
