package com.guru.recipe.controller;


import com.guru.recipe.commands.RecipeCommand;
import com.guru.recipe.domain.Recipe;
import com.guru.recipe.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/show/{id}")
    private String show(@PathVariable String id, Model model){

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }
    @GetMapping ("/create")
    private String create(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeForm";
    }

    @PostMapping("/save")
    private String save(@ModelAttribute RecipeCommand recipeCommand){
        RecipeCommand recipe = recipeService.saveRecipeCommand(recipeCommand);
        return "redirect:/recipe/show/" + recipe.getId();
    }
}
