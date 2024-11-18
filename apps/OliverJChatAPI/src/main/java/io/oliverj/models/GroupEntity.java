package io.oliverj.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class GroupEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue
    public Long id;

    @OneToOne
    public ChannelEntity channel;

    @OneToMany
    public Collection<UserEntity> members;
}
