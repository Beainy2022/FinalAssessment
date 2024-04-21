package com.Eurisko.Final.Exam.PhotoAlbumGallery.advice.exception;

public class ResponseStatusException extends RuntimeException{
    public ResponseStatusException(String message) {
        super(message);
    }
}
