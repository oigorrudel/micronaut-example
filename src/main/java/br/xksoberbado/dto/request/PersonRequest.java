package br.xksoberbado.dto.request;

import io.micronaut.serde.annotation.Serdeable;

import java.util.UUID;

@Serdeable
public class PersonRequest {

    private UUID id;
    private String name;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
