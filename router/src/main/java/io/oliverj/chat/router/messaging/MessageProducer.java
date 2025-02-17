package io.oliverj.chat.router.messaging;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;
import io.oliverj.chat.router.objects.Message;

@RabbitClient("service.router")
public interface MessageProducer {

    void send(Message message, @Binding String key);

    @Binding("*")
    void broadcast(Message message);
}