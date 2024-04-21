package com.Eurisko.Final.Exam.PhotoAlbumGallery.config;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.service.LdapUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class LdapAuthConfig {
    private final LdapUserDetailsService ldapUserDetailsService;

    public LdapAuthConfig(LdapUserDetailsService ldapUserDetailsService) {
        this.ldapUserDetailsService = ldapUserDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Autowired
    public void authenticateLdap(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8081/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPassword")
                .and()
                .userDetailsContextMapper(ldapUserDetailsService.userDetailsContextMapper());
    }
}

