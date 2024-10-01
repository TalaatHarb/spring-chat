package net.talaatharb.chat.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.chat.config.RabbitMQConfig;
import net.talaatharb.chat.dto.MessageRequest;

@ConditionalOnProperty(name = {"rabbit.broadcast"}, havingValue = "true")
@Service
@RequiredArgsConstructor
public class RabbitBroadcastServiceImpl implements MessageBroadcastService{
	
	private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE_NAME = RabbitMQConfig.MESSAGE_EXCHANGE;
	
	public void broadcast(MessageRequest messageRequest) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", messageRequest.getContent());
	}

}
