package net.talaatharb.chat.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.chat.dto.MessageRequest;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = { "rabbit.broadcast" }, havingValue = "false")
public class DirectMessagingBroadcastService implements MessageBroadcastService {

	private final SimpMessagingTemplate messagingTemplate;

	@Override
	public void broadcast(MessageRequest message) {
		log.info("Broadcasting Message: {}", message.toString());
		messagingTemplate.convertAndSend("/topic/messages", message);
	}

}
