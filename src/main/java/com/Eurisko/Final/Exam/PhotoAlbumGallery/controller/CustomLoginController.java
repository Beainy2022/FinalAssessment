package com.Eurisko.Final.Exam.PhotoAlbumGallery.controller;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.CustomLogin;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.UserDetails;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.service.JwtGeneratorService;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomLoginController {
    private final LoginService loginService;

    public CustomLoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> customLogin(@RequestBody CustomLogin customLogin) {
      return loginService.customLogin(customLogin);
    }
}
