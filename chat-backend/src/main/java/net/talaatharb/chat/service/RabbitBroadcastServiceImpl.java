package net.talaatharb.chat.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.chat.config.RabbitMQConfig;
import net.talaatharb.chat.dto.MessageRequest;

@Slf4j
@ConditionalOnProperty(name = {"rabbit.broadcast"}, havingValue = "true")
@Service
@RequiredArgsConstructor
public class RabbitBroadcastServiceImpl implements MessageBroadcastService{
	
	private final RabbitTemplate rabbitTemplate;
    private static final String EXCHANGE_NAME = RabbitMQConfig.MESSAGE_EXCHANGE;
	
	public void broadcast(MessageRequest message) {
		log.debug("Broadcasting Message through RabbitMQ: {}", message.toString());
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", message.getContent());
	}

}
