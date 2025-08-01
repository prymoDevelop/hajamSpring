package com.prymodev.barberAPI.service;


import com.prymodev.barberAPI.domain.entity.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
