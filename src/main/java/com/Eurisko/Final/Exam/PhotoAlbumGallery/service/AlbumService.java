package com.Eurisko.Final.Exam.PhotoAlbumGallery.service;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.advice.exception.ResponseStatusException;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.Album;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlbumService {
    private final WebClient webClient;

    public AlbumService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Flux<Album> getAllAlbums() {
        return this.webClient.get().uri("/albums")
                .retrieve()
                .bodyToFlux(Album.class);
    }

    public Mono<Album> getAlbumById(int id) {
        return this.webClient.get().uri("/albums/{id}", id)
                .retrieve()
                .bodyToMono(Album.class)
                .switchIfEmpty(Mono.defer(()
                        -> Mono.error(new ResponseStatusException("Album with ID " + id + " not found"))));
    }
}

