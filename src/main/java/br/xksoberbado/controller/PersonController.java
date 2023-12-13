package br.xksoberbado.controller;

import br.xksoberbado.dto.request.PersonRequest;
import br.xksoberbado.model.Person;
import br.xksoberbado.service.PersonService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;
import java.util.UUID;

@Controller("people")
public class PersonController {

    @Inject
    private PersonService service;

    @Get
    public List<Person> get() {
        return service.getAll();
    }

    @Get("{id}")
    public Person getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @Post
    @Status(HttpStatus.CREATED)
    public Person create(@Body PersonRequest request) {
        return service.create(Person.of(request.getId(), request.getName()));
    }

    @Delete("{id}")
    @Status(HttpStatus.ACCEPTED)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
