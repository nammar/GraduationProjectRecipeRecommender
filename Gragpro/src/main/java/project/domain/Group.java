/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.domain;

/**
 *
 * @author Yazan Zaghal
 */
import java.util.Date;
import java.util.Set;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import sun.security.util.Password;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity(label = "Class")
public class Group {
    String name;
    
    @Relationship(type = "join",direction = Relationship.INCOMING)
    private Person person;
    
    public Group(){
    }
    public Group(String name,Person person){
        this.name=name;
        this.person=person;
    
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Group{" + "name=" + name + ", person=" + person + '}';
    }
    
}
