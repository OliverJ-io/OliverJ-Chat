package io.oliverj.chat.database.repositories;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import io.oliverj.chat.database.objects.Message;

import java.util.List;

@MongoRepository
public interface MessageRepository extends CrudRepository<Message, String> {}
