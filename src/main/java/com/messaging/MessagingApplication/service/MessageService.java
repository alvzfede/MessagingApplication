package com.messaging.MessagingApplication.service;

import com.messaging.MessagingApplication.model.Message;

import java.util.List;

public interface MessageService {

    Message save( Message message);
    void delete(Long id);
    List<Message> getAll(Long userId);

}
