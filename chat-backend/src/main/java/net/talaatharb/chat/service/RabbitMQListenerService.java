package net.talaatharb.chat.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.chat.config.RabbitMQConfig;

@ConditionalOnProperty(name = {"rabbit.broadcast"}, havingValue = "true")
@RequiredArgsConstructor
@Service
public class RabbitMQListenerService {

    private final SimpMessagingTemplate messagingTemplate;

    @RabbitListener(queues = RabbitMQConfig.MESSAGE_QUEUE)
    public void receiveMessage(String message) {
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}

