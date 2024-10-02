package net.talaatharb.chat.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.talaatharb.chat.dto.MessageRequest;
import net.talaatharb.chat.mapper.MessageMapper;
import net.talaatharb.chat.model.MessageEntity;
import net.talaatharb.chat.repository.MessageRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

	private final MessageRepository messageRepository;
	private final MessageMapper messageMapper;

	@Override
	@Transactional
	public MessageRequest save(MessageRequest messageRequest) {
		MessageEntity message = messageMapper.toEntity(messageRequest);
		message = messageRepository.save(message);
		log.debug("Message with id {} saved", message.getId().toString());
		return messageMapper.toDTO(message);
	}

}
