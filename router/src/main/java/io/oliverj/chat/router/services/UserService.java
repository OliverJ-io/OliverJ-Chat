package io.oliverj.chat.router.services;

import io.oliverj.chat.router.http.DatabaseApiClient;
import io.oliverj.chat.router.messaging.MessageProducer;
import io.oliverj.chat.router.objects.Message;
import io.oliverj.chat.router.objects.User;
import jakarta.inject.Singleton;
import lombok.NonNull;

import java.util.List;

@Singleton
public class UserService {

    DatabaseApiClient databaseApiClient;

    public UserService(DatabaseApiClient databaseApiClient) {
        this.databaseApiClient = databaseApiClient;
    }

    public User getUser(String id) {
        return databaseApiClient.getUser(id);
    }

    public List<User> getUsers() {
        return databaseApiClient.getUsers();
    }

    public User save(@NonNull User user) {
        return databaseApiClient.save(user);
    }
}
