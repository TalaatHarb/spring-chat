package net.talaatharb.chat.service;

import net.talaatharb.chat.dto.MessageRequest;

public interface MessageBroadcastService {
	void broadcast(MessageRequest messageRequest);
}
