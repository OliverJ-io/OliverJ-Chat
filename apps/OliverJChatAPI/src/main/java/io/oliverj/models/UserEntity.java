package io.oliverj.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class UserEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue
    public Long id;

    public String username;

    public String email;

    public String password;

    @OneToMany(mappedBy = "id")
    public Collection<UserEntity> friends;
}
