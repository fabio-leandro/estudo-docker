package com.fabio.personapi.controller;

import com.fabio.personapi.entity.Person;
import com.fabio.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("people/save")
    public ResponseEntity<Person> save (@RequestBody Person person){
        Person person1 = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.OK).body(person1);
    }

    @GetMapping("people/all")
    public List<Person> findAll(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    @GetMapping("people/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("Product not found for this id."));
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @DeleteMapping("people/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        findById(id);
        personRepository.deleteById(id);
    }

    @PutMapping("people/update/{id}")
    public ResponseEntity<Person> updateById(@PathVariable Long id, @RequestBody Person person) throws PersonNotFoundException {
        findById(id);
        Person personPut = personRepository.save(person);
        return ResponseEntity.status(HttpStatus.OK).body(personPut);
    }


}
