package com.messaging.MessagingApplication.controller;

import com.messaging.MessagingApplication.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(value = "/{source}/{target}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String sendMessage(@PathVariable String source,
                              @PathVariable String target,
                              @RequestBody String message){

        messageService.save(source, target,message);

        return "Sended!";

    }

}
