package com.Eurisko.Final.Exam.PhotoAlbumGallery.controller;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.MyUser;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.service.MyUserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final MyUserService userService;
    public UserController(MyUserService userService){
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Flux<MyUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<MyUser> getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
}


