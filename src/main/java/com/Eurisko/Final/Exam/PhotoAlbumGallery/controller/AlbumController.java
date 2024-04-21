package com.Eurisko.Final.Exam.PhotoAlbumGallery.controller;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.Album;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.service.AlbumService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {

        this.albumService = albumService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Flux<Album> getAllAlbums() {

        return albumService.getAllAlbums();
    }

    @GetMapping("/{id}")
    public Mono<Album> getAlbumById(@PathVariable int id) {

        return albumService.getAlbumById(id);
    }
}

