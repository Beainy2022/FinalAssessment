package com.Eurisko.Final.Exam.PhotoAlbumGallery.service;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.constant.SecurityConstants;
import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.UserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtGeneratorService {
    public String generateToken(UserDetails customUserDetails) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            String role = customUserDetails.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("");
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            return Jwts.builder().issuer("spring Security Exercise").subject("JWT Token body")
                    .claim("uid", customUserDetails.getUid())
                    .claim("telephoneNumber", customUserDetails.getTelephoneNumber())
                    .claim("role",role)
                    .issuedAt(new Date())
                    .expiration(new Date((new Date()).getTime() + 30000000))
                    .signWith(key).compact();

        } else {
            return "Unable to generate token";
        }
    }
}

