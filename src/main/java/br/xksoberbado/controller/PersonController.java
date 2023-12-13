package br.xksoberbado.controller;

import br.xksoberbado.dto.request.PersonRequest;
import br.xksoberbado.model.Person;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Controller("people")
public class PersonController {

    private static Person JOAO = Person.of(UUID.fromString("aa83fd1f-4450-4775-9de9-b536f8a80ec1"), "João");
    private static Person MARIA = Person.of(UUID.randomUUID(), "Maria");
    private static List<Person> PEOPLE = List.of(JOAO, MARIA);

    @Get
    public List<Person> get() {
        return PEOPLE;
    }

    @Get("{id}")
    public Person getById(@PathVariable UUID id) {
        return Stream.of(JOAO, MARIA)
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Person create(@Body PersonRequest request) {
        final var person = Person.of(request.getId(), request.getName());

        PEOPLE = Stream.concat(PEOPLE.stream(), Stream.of(person)).toList();

        return person;
    }

    @Delete("{id}")
    @Status(HttpStatus.ACCEPTED)
    public void delete(@PathVariable UUID id) {
        PEOPLE = PEOPLE.stream()
            .filter(p -> !p.getId().equals(id))
            .toList();
    }
}
