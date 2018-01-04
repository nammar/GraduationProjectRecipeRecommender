/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.repository;

/**
 *
 * @author Yazan Zaghal
 */
import org.springframework.data.repository.CrudRepository;
import project.domain.Group;

  
public interface GroupRepository extends CrudRepository<Group, Long> {

}