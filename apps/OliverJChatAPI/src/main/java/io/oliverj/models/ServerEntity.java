package io.oliverj.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class ServerEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    public String description;

    public String icon;

    @ManyToOne
    public UserEntity owner;

    @OneToMany
    public Collection<UserEntity> members;

    @OneToMany
    public Collection<ChannelEntity> channels;
}
