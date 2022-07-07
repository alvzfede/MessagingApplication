package com.messaging.MessagingApplication.controller;

import com.messaging.MessagingApplication.model.Message;
import com.messaging.MessagingApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    public static final String VIEWED = "Viewed!";
    public static final String SENT = "Sent it!";
    public static final String REMOVED = "Removed!";

    @Autowired
    MessageService messageService;

    @PostMapping(value = "/{source}/{target}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String sendMessage(@PathVariable String source,
                              @PathVariable String target,
                              @RequestBody String message){

        messageService.save(source, target,message);

        return SENT;

    }

    @GetMapping(value = "/{username}")
    public List<Message> getAll(@PathVariable String username){
        return messageService.getAll(username);
    }

    @PostMapping(value = "/markAsRead/{idMessage}")
    public String markAsViewed(@PathVariable Long idMessage){
        messageService.markAsViewed(idMessage);
        return VIEWED;
    }

    @DeleteMapping()
    public String delete(@PathVariable Long idMessage){
        messageService.delete(idMessage);
        return REMOVED;
    }

}
