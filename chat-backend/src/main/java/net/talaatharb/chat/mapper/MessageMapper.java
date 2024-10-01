package net.talaatharb.chat.mapper;

import org.mapstruct.Mapper;

import net.talaatharb.chat.dto.MessageRequest;
import net.talaatharb.chat.model.MessageEntity;

@Mapper
public interface MessageMapper {

	MessageEntity toEntity(MessageRequest messageRequest);
	
	MessageRequest toDTO(MessageEntity message);
	
}
