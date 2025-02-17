package io.oliverj.chat.database.services;

import io.micronaut.core.annotation.NonNull;
import io.oliverj.chat.database.objects.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> list();

    User save(User user);

    Optional<User> find(@NonNull String id);
}
