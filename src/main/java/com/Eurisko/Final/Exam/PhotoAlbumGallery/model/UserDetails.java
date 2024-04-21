package com.Eurisko.Final.Exam.PhotoAlbumGallery.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
//mapping my user
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final String uid;
    private final Collection<? extends GrantedAuthority> authorities;
    private final String telephoneNumber;

    public UserDetails(org.springframework.security.core.userdetails.UserDetails userDetails, String telephoneNumber) {
        this.uid = userDetails.getUsername();
        this.authorities = userDetails.getAuthorities();
        this.telephoneNumber = telephoneNumber;
    }

    public String getUid() {
        return uid;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return uid;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
