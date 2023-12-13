package br.xksoberbado.model;

import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Serdeable
public class Person {

    private UUID id;
    private String name;

    private Person(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static Person of(final UUID id, final String name) {
        return new Person(id, name);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
