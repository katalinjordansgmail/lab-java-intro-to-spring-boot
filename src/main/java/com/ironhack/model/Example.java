package com.ironhack.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "examples")
@Data
@NoArgsConstructor
public class Example {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Example(String name) {
        this.name = name;
    }
}
