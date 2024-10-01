package net.talaatharb.chat.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.talaatharb.chat.mapper.MessageMapper;

@Configuration
public class MapperBeans {

	@Bean
	MessageMapper messageMapper() {
		return Mappers.getMapper(MessageMapper.class);
	}
}
