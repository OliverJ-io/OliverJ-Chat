package io.oliverj.chat.database.controllers;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.oliverj.chat.database.objects.Message;
import io.oliverj.chat.database.services.MessageService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Controller("/messages")
@ExecuteOn(TaskExecutors.BLOCKING)
public class MessageController {
    private final MessageService messageService;

    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @Get
    Iterable<Message> list() {
        return messageService.list();
    }

    @Post
    @Status(HttpStatus.CREATED)
    Message save(@NonNull @NotNull @Valid Message message) {
        return messageService.save(message);
    }

    @Put
    Message update(@NonNull @NotNull @Valid Message message) {
        return messageService.save(message);
    }

    @Get("/{id}")
    Optional<Message> find(@PathVariable String id) {
        return messageService.find(id);
    }
}
