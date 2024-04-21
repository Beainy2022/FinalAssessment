package com.Eurisko.Final.Exam.PhotoAlbumGallery.service;

import com.Eurisko.Final.Exam.PhotoAlbumGallery.model.UserDetails;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LdapUserDetailsService {
    // to get user details from my ldif file
    // and send them to my userDetails
    public UserDetailsContextMapper userDetailsContextMapper() {
        return new LdapUserDetailsMapper() {
            @Override
            public org.springframework.security.core.userdetails.UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
                org.springframework.security.core.userdetails.UserDetails originalUserDetails = super.mapUserFromContext(ctx, username, authorities);
                String uid = ctx.getStringAttribute("uid");//ctx gives me access to uid and phone
                String telephoneNumber = ctx.getStringAttribute("telephoneNumber");
                return new UserDetails(originalUserDetails, telephoneNumber);
            }
        };
    }

}
//import com.springsecurity.exercise.springsecurityexercise.model.UserDetails;
//import org.springframework.ldap.core.DirContextOperations;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
//import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//
//@Service
//public class LdapUserDetailsService {
//// to get user details from my ldif file
//    // and send them to my userDetails
//    public UserDetailsContextMapper userDetailsContextMapper() {
//        return new LdapUserDetailsMapper() {
//            @Override
//            public org.springframework.security.core.userdetails.UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
//                org.springframework.security.core.userdetails.UserDetails originalUserDetails = super.mapUserFromContext(ctx, username, authorities);
//                String uid = ctx.getStringAttribute("uid");//ctx gives me access to uid and phone
//                String telephoneNumber = ctx.getStringAttribute("telephoneNumber");
//                return new UserDetails(originalUserDetails, telephoneNumber);
//            }
//        };
//    }
//
//}


