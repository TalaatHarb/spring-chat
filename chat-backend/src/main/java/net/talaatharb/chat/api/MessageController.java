	package net.talaatharb.chat.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.chat.dto.MessageRequest;
import net.talaatharb.chat.service.MessageBroadcastService;
import net.talaatharb.chat.service.MessageService;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageBroadcastService messageBroadcastService;
    private final MessageService messageService;

    @PostMapping
    public MessageRequest sendMessage(@RequestBody MessageRequest messageRequest) {
    	messageRequest = messageService.save(messageRequest);
    	messageBroadcastService.broadcast(messageRequest);
    	
    	return messageRequest;
    }
}

