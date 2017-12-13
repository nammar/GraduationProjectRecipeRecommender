/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yazan Zaghal
 */
package project.controller;

import org.neo4j.ogm.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import project.domain.Person;
import project.repository.PersonRepository;

@RestController
@RequestMapping(value = "/api/classes")
public class PersonController {

	private PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Person> readAll() {
		return personRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Person create(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public Person read(@PathVariable Long id) {
		return personRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		personRepository.deleteById(id);
	}

	@Transactional
	@RequestMapping(value = "/{username}", method = RequestMethod.PUT)
	public Person update(@PathVariable Long id, @RequestBody Person update) {
		final Person existing = personRepository.findById(id).orElseThrow(NotFoundException::new);
		existing.updateFrom(update);
		return personRepository.save(existing);
	}
}
