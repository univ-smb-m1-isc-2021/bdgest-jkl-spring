package com.manga.bdgest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role", nullable = false, updatable = false)
    private Long id;

    @Column(length = 60)
    private String name;
}
