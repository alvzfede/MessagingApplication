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
        msg.setViewed(false);
        msg.setSender(sourceUsr.get());
        msg.setReceiver(targetUsr.get());

        return messageRepository.save(msg);
    }

    @Override
    public void delete(Long id) {
        Optional<Message> message = messageRepository.findById(id);
        if(!message.isPresent())
            throw new IllegalArgumentException("Message not exists.");
        messageRepository.delete(message.get());
    }

    @Override
    public List<Message> getAll(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(!user.isPresent())
            throw new IllegalArgumentException("Username not exists.");
        return messageRepository.findByReceiver(user.get());
    }

    @Override
    public void markAsViewed(Long idMessage) {
        Optional<Message> message = messageRepository.findById(idMessage);
        if(!message.isPresent())
            throw new IllegalArgumentException("Message not exists.");

        message.get().setViewed(true);
        messageRepository.save(message.get());
    }
}
