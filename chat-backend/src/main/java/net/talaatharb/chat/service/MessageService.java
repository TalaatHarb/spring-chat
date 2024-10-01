package net.talaatharb.chat.service;

import net.talaatharb.chat.dto.MessageRequest;

public interface MessageService {

	MessageRequest save(MessageRequest messageRequest);

}
