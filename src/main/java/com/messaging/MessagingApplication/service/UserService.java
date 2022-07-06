package com.messaging.MessagingApplication.service;

import com.messaging.MessagingApplication.model.User;

public interface UserService {

    User save(User user);
    void delete();
}
