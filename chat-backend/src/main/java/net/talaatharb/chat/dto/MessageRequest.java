package net.talaatharb.chat.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class MessageRequest {
	private UUID id;
	private UUID senderId;
    private String content;
}

