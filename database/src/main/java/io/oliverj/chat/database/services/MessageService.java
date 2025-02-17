package io.oliverj.chat.database.services;

import io.micronaut.core.annotation.NonNull;
import io.oliverj.chat.database.objects.Message;

import java.util.Optional;

public interface MessageService {
    Iterable<Message> list();

    Message save(Message message);

    Optional<Message> find(@NonNull String id);
}
