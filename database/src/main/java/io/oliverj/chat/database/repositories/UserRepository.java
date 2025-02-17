package io.oliverj.chat.database.repositories;

import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.CrudRepository;
import io.oliverj.chat.database.objects.User;

@MongoRepository
public interface UserRepository extends CrudRepository<User, String> {}
