package com.rofik.springstartertemplate.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serial;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@Entity
@Table(name = "users")
@NoArgsConstructor
public class User extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -2892586095682409786L;

    enum Role {
        SUPERADMIN,
        SUPERVISOR,
        CONSULTANT
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated
    private Role role;
}
