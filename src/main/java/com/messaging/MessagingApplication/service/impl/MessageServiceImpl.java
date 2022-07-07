package com.messaging.MessagingApplication.service.impl;

import com.messaging.MessagingApplication.model.Message;
import com.messaging.MessagingApplication.model.User;
import com.messaging.MessagingApplication.repository.MessageRepository;
import com.messaging.MessagingApplication.repository.UserRepository;
import com.messaging.MessagingApplication.service.MessageService;
import com.messaging.MessagingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Message save(String source, String target, String message) {

        Optional<User> sourceUsr = userRepository.findByUsername(source);
        Optional<User> targetUsr = userRepository.findByUsername(target);

        if(!targetUsr.isPresent()||!sourceUsr.isPresent())
            throw new IllegalArgumentException("Username target not exists.");

        Message msg = new Message();
        msg.setMessage(message);
        msg.setReaded(false);
        msg.setSender(sourceUsr.get());
        msg.setReceiver(targetUsr.get());

        return messageRepository.save(msg);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Message> getAll(Long userId) {
        return null;
    }
}
