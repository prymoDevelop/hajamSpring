package com.prymodev.entity;

import org.springframework.security.core.authority.AuthorityUtils;
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private AppUser user;

    public CurrentUser(AppUser user) {
        super(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRoles().toString()));
        this.user = user;
    }


}
