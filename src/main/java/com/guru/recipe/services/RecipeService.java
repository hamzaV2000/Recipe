package com.guru.recipe.services;

import com.guru.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface RecipeService {

    public Set<Recipe> getRecipes();
}
