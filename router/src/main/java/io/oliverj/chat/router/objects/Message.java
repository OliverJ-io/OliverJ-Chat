package io.oliverj.chat.router.objects;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record Message(
        @Nullable String id,
        @NonNull String sender,
        @Nullable String receiver,
        @Nullable String body
) {}
