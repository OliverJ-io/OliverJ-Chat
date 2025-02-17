package io.oliverj.chat.router.messaging;
import io.micronaut.rabbitmq.annotation.Queue;
import io.micronaut.rabbitmq.annotation.RabbitListener;
import io.oliverj.chat.router.objects.Message;
import io.oliverj.chat.router.services.MessageService;
import lombok.extern.slf4j.Slf4j;

@RabbitListener
@Slf4j
public class MessageConsumer {
    private final MessageService messageService;

    public MessageConsumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @Queue("app")
    public void receive(Message message) {
        log.info("Message received!");
        log.info("Received from {}", message.sender());
        log.info("Saving message");
        messageService.save(message);
        log.info("Sending Message");
        if (message.receiver() != null) {
            log.info("Sending to {}", message.sender());
            messageService.send(message);
        } else {
            log.info("Broadcast");
            messageService.broadcast(message);
        }
    }

}