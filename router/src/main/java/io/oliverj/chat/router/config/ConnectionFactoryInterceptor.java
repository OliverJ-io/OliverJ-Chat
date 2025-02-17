package io.oliverj.chat.router.config;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.DefaultCredentialsProvider;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

@Singleton
public class ConnectionFactoryInterceptor implements BeanCreatedEventListener<ConnectionFactory> {

    @Override
    public ConnectionFactory onCreated(@NonNull BeanCreatedEvent<ConnectionFactory> event) {
        ConnectionFactory connectionFactory = event.getBean();
        connectionFactory.setCredentialsProvider(new DefaultCredentialsProvider("chat-server", "chatserver"));
        return connectionFactory;
    }
}
