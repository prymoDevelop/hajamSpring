package com.prymodev.barberAPI.service.impl;

import com.prymodev.barberAPI.domain.entity.CurrentUser;
import com.prymodev.barberAPI.service.CurrentUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CurrentUserServiceImpl implements CurrentUserService {


    @Override
    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        log.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null;
    }

}
