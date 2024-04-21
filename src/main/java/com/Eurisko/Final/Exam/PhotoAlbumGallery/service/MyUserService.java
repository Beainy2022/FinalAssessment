package com.Eurisko.Final.Exam.PhotoAlbumGallery.service;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.advice.exception.UserNotFoundException;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.MyUser;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.repository.MyUserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class MyUserService {



 private final WebClient webClient;

    public MyUserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Flux<MyUser> getAllUsers() {
        return this.webClient.get().uri("/users")
                .retrieve()
                .bodyToFlux(MyUser.class);
    }

    public Mono<MyUser> getUserById(int id) {
        return this.webClient.get().uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(MyUser.class)
                .switchIfEmpty(Mono.defer(() -> Mono.error(new UserNotFoundException("User with ID " + id + " not found"))));
    }


}

