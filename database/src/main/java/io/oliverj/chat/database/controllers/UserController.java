package io.oliverj.chat.database.controllers;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.oliverj.chat.database.objects.Message;
import io.oliverj.chat.database.objects.User;
import io.oliverj.chat.database.services.MessageService;
import io.oliverj.chat.database.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

@Controller("/users")
@ExecuteOn(TaskExecutors.BLOCKING)
public class UserController {
    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @Get
    Iterable<User> list() {
        return userService.list();
    }

    @Post
    @Status(HttpStatus.CREATED)
    User save(@NonNull @NotNull @Valid User message) {
        return userService.save(message);
    }

    @Put
    User update(@NonNull @NotNull @Valid User message) {
        return userService.save(message);
    }

    @Get("/{id}")
    Optional<User> find(@PathVariable String id) {
        return userService.find(id);
    }
}
