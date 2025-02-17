package io.oliverj.chat.database.objects;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@MappedEntity("messages")
public class Message {

    @Setter
    @Getter
    @Id
    @GeneratedValue
    private String id;

    @NonNull
    @NotBlank
    private final String sender;

    @Nullable
    private String receiver;

    @Nullable
    private String body;

    public Message(@NonNull String sender, @Nullable String receiver, @Nullable String body) {
        this.sender = sender;
        this.receiver = receiver;
        this.body = body;
    }

    @NonNull
    public String getSender() {
        return sender;
    }

    @Nullable
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(@Nullable String receiver) {
        this.receiver = receiver;
    }

    @Nullable
    public String getBody() {
        return body;
    }

    public void setBody(@Nullable String body) {
        this.body = body;
    }
}
