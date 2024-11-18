package io.oliverj.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class MessageEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    public ChannelEntity channel;

    public String text;
}
