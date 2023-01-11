package com.guru.recipe.services;


import com.guru.recipe.commands.RecipeCommand;
import com.guru.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
