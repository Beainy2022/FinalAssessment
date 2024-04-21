package com.Eurisko.Final.Exam.PhotoAlbumGallery.controller;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.Photo;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.service.PhotoService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Flux<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/{id}")
    public Mono<Photo> getPhotoById(@PathVariable int id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping
    public Mono<Photo> addPhoto(@RequestBody Photo photo) {
        return photoService.addPhoto(photo);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePhoto(@PathVariable int id) {
        return photoService.deletePhoto(id);
    }
}
