package com.Eurisko.Final.Exam.PhotoAlbumGallery.service;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.advice.exception.ResponseStatusException;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.Photo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PhotoService {
    private final WebClient webClient;

    public PhotoService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Flux<Photo> getAllPhotos() {
        return this.webClient.get().uri("/photos")
                .retrieve()
                .bodyToFlux(Photo.class);
    }

    public Mono<Photo> getPhotoById(int id) {
        return this.webClient.get().uri("/photos/{id}", id)
                .retrieve()
                .bodyToMono(Photo.class) .switchIfEmpty(Mono.defer(()
                        -> Mono.error(new ResponseStatusException("Photo with ID " + id + " not found"))));
    }

    public Mono<Photo> addPhoto(Photo photo) {
        return this.webClient.post().uri("/photos")
                .body(Mono.just(photo), Photo.class)
                .retrieve()
                .bodyToMono(Photo.class);

    }

    public Mono<Void> deletePhoto(int id) {
        return this.webClient.delete().uri("/photos/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}

