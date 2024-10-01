package net.talaatharb.chat.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.talaatharb.chat.model.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, UUID>{

}
