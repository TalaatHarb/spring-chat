package net.talaatharb.chat.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.chat.config.RabbitMQConfig;
import net.talaatharb.chat.config.WebSocketConfig;

@Slf4j
@ConditionalOnProperty(name = {"rabbit.broadcast"}, havingValue = "true")
@RequiredArgsConstructor
@Service
public class RabbitMQListenerService {

    private final SimpMessagingTemplate messagingTemplate;

    @RabbitListener(queues = RabbitMQConfig.MESSAGE_QUEUE)
    public void receiveMessage(String message) {
    	log.debug("Received message: {}", message);
        messagingTemplate.convertAndSend(WebSocketConfig.TOPIC_MESSAGES, message);
    }
}

