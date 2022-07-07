package com.messaging.MessagingApplication.service;

import com.messaging.MessagingApplication.model.Message;

import java.util.List;

public interface MessageService {

    Message save(String usrNameSource,String usrNameTarget, String message);
    void delete(Long id);
    List<Message> getAll(String username);

    void markAsViewed(Long idMessage);

}
