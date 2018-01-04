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
import project.domain.Recipe;
import project.repository.RecipeRepository;

@RestController
@RequestMapping(value = "/api/classes")
public class RecipeController {

	private RecipeRepository recipeRepository;

	@Autowired
	public RecipeController(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Recipe> readAll() {
		return recipeRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Recipe create(@RequestBody Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@RequestMapping(value = "/{titleText}", method = RequestMethod.GET)
	public Recipe read(@PathVariable Long id) {
		return recipeRepository.findById(id).orElseThrow(NotFoundException::new);
	}

	@RequestMapping(value = "/{titleText}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		recipeRepository.deleteById(id);
	}

	@Transactional
	@RequestMapping(value = "/{titleText}", method = RequestMethod.PUT)
	public Recipe update(@PathVariable Long id, @RequestBody Recipe update) {
		final Recipe existing = recipeRepository.findById(id).orElseThrow(NotFoundException::new);
		existing.updateFrom(update);
		return recipeRepository.save(existing);
	}
}
