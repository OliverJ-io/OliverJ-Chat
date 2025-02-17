package io.oliverj.chat.router.objects;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record User(
        @Nullable String id,
        @NonNull String username,
        @NonNull String email
) {}
