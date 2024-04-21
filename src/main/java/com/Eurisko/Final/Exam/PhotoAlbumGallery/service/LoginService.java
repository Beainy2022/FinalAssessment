package com.Eurisko.Final.Exam.PhotoAlbumGallery.service;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.CustomLogin;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginService {
    private final AuthenticationManager authenticationManager;
    private final JwtGeneratorService jwtGeneratorService;

    public LoginService(AuthenticationManager authenticationManager, JwtGeneratorService jwtGeneratorService) {
        this.authenticationManager = authenticationManager;
        this.jwtGeneratorService = jwtGeneratorService;
    }
    public ResponseEntity<Object> customLogin(@RequestBody CustomLogin customLogin) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customLogin.getUsername(), customLogin.getPassword()));
            if (authentication.getPrincipal() instanceof UserDetails userDetails) {
                //creating my JwttokenGenerator here because im getting my token from ldap auth(ldif file)
                String token = jwtGeneratorService.generateToken(userDetails);
                return ResponseEntity.ok(token);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to generate token");//500
            }
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }

    }
}
