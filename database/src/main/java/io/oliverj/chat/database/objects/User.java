package io.oliverj.chat.database.objects;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@MappedEntity("users")
public class User {

    @Setter
    @Getter
    @Id
    @GeneratedValue
    private String id;

    @NonNull
    @NotBlank
    private String username;

    @NonNull
    @NotBlank
    private String email;

    public User(@NonNull String username, @NonNull String email) {
        this.username = username;
        this.email = email;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public void setEmail(@NonNull String email) { this.email = email; }
}
