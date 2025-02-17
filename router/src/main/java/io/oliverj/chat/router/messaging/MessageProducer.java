package io.oliverj.chat.router.messaging;
import io.micronaut.rabbitmq.annotation.Binding;
import io.micronaut.rabbitmq.annotation.RabbitClient;

@RabbitClient("service.router")
public interface MessageProducer {
    @Binding("router")
    void send();
}