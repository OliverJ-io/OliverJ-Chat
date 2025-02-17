package io.oliverj.chat.database.services.impl;

import io.oliverj.chat.database.objects.User;
import io.oliverj.chat.database.repositories.UserRepository;
import io.oliverj.chat.database.services.UserService;
import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> find(String id) {
        return userRepository.findById(id);
    }
}
