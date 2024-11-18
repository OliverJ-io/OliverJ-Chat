package io.oliverj.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;
import java.util.Optional;

@Entity
public class ChannelEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String description;

    public String icon;

    public ChannelType type;

    public enum ChannelType {
        TEXT,
        VOICE
    }

    @OneToMany
    public Collection<MessageEntity> messages;
}
