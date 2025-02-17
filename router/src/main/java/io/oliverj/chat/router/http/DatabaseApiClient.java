package io.oliverj.chat.router.http;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Header;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.oliverj.chat.router.objects.Message;
import io.oliverj.chat.router.objects.User;
import org.reactivestreams.Publisher;

import java.util.List;

import static io.micronaut.http.HttpHeaders.ACCEPT;
import static io.micronaut.http.HttpHeaders.USER_AGENT;

@Client(id = "database")
@Header(name = USER_AGENT, value = "OliverJ Chat Router")
@Header(name = ACCEPT, value = "application/json")
public interface DatabaseApiClient {

    @Get("/messages")
    @SingleResult
    List<Message> getMessages();

    @Get("/messages/{id}")
    @SingleResult
    Message getMessage(@PathVariable String id);

    @Post("/messages")
    @SingleResult
    Message save(Message message);

    @Get("/users")
    @SingleResult
    List<User> getUsers();

    @Get("/users/{id}")
    @SingleResult
    User getUser(@PathVariable String id);

    @Post("/users")
    @SingleResult
    User save(User user);
}
