package br.xksoberbado.service;

import br.xksoberbado.model.Person;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Singleton
public class PersonService {

    private static Person JOAO = Person.of(UUID.fromString("aa83fd1f-4450-4775-9de9-b536f8a80ec1"), "João");
    private static Person MARIA = Person.of(UUID.randomUUID(), "Maria");
    private static List<Person> PEOPLE = List.of(JOAO, MARIA);

    public List<Person> getAll() {
        return PEOPLE;
    }

    public Person getById(final UUID id) {
        return PEOPLE.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

    public Person create(final Person person) {
        PEOPLE = Stream.concat(PEOPLE.stream(), Stream.of(person)).toList();

        return person;
    }

    public void delete(final UUID id) {
        PEOPLE = PEOPLE.stream()
            .filter(p -> !p.getId().equals(id))
            .toList();
    }
}
