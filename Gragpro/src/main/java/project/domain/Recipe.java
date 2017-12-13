/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yazan Zaghal
 */
package project.domain;

import java.util.Date;
import java.util.Set;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import sun.security.util.Password;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import java.util.HashSet;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
/**
 *
 * @author Yazan Zaghal
 */
@JsonIdentityInfo(generator = JSOGGenerator.class)
@NodeEntity
public class Recipe {
    String titleText;
    String summaryText;
    String recipeImage;
    String ingredientsText;
   
    
    @Relationship(type = "favorite",direction = Relationship.INCOMING)
    private Person person;

    
    

public Recipe(){
}
public Recipe(String titleText,String summaryText,String recipeImage, String ingredientsText){
    this.titleText=titleText;
    this.summaryText=summaryText;
    this.recipeImage=recipeImage;
    this.ingredientsText=ingredientsText;
}

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public void setSummaryText(String summaryText) {
        this.summaryText = summaryText;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(String recipeImage) {
        this.recipeImage = recipeImage;
    }

    public String getIngredientsText() {
        return ingredientsText;
    }

    public void setIngredientsText(String ingredientsText) {
        this.ingredientsText = ingredientsText;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Recipe{" + "titleText=" + titleText + ", summaryText=" + summaryText + ", recipeImage=" + recipeImage + ", ingredientsText=" + ingredientsText + ", person=" + person + '}';
    }
    

    public void updateFrom(Recipe recipe) {
		this.titleText = recipe.titleText;
	}


}
