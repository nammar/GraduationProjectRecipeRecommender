/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yazan Zaghal
 */
package project.repository;
import org.springframework.data.repository.CrudRepository;
import project.domain.Person;

  
public interface PersonRepository extends CrudRepository<Person, Long> {

}

