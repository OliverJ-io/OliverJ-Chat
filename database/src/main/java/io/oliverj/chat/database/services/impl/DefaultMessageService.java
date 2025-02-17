package io.oliverj.chat.database.services.impl;

import io.oliverj.chat.database.objects.Message;
import io.oliverj.chat.database.repositories.MessageRepository;
import io.oliverj.chat.database.services.MessageService;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class DefaultMessageService implements MessageService {

    private final MessageRepository messageRepository;

    public DefaultMessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Iterable<Message> list() {
        return messageRepository.findAll();
    }

    @Override
    public Message save(Message message) {
        if (message.getId() == null) {
            return messageRepository.save(message);
        } else {
            return messageRepository.update(message);
        }
    }

    @Override
    public Optional<Message> find(String id) {
        return messageRepository.findById(id);
    }
}
