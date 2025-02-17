package io.oliverj.chat.router.services;

import io.oliverj.chat.router.http.DatabaseApiClient;
import io.oliverj.chat.router.messaging.MessageProducer;
import io.oliverj.chat.router.objects.Message;
import jakarta.inject.Singleton;
import lombok.NonNull;

import java.util.List;

@Singleton
public class MessageService {
    MessageProducer messageProducer;

    DatabaseApiClient databaseApiClient;

    public MessageService(MessageProducer messageProducer, DatabaseApiClient databaseApiClient) {
        this.messageProducer = messageProducer;
        this.databaseApiClient = databaseApiClient;
    }

    public Message getMessage(String id) {
        return databaseApiClient.getMessage(id);
    }

    public List<Message> getMessages() {
        return databaseApiClient.getMessages();
    }

    public Message save(@NonNull Message message) {
        return databaseApiClient.save(message);
    }

    public void send(@NonNull Message message) {
        messageProducer.send(message, message.receiver());
    }

    public void broadcast(@NonNull Message message) {
        messageProducer.broadcast(message);
    }
}
