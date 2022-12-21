package com.guru.recipe.controller;


import com.guru.recipe.domain.*;
import com.guru.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Controller
@RequestMapping("")
@Slf4j
public class IndexController {



    private final RecipeService recipeService;

    private Set<Recipe> recipes = null;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;

        log.debug("Index Controller Initializing....");
    }

    @GetMapping({"", "/"})
    public String getIndexPage(Model model){
        //Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        //Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        Map<Long, String> productBase64Images = new HashMap<>();
        if(recipes == null )
            recipes = recipeService.getRecipes();
        System.out.println(recipes);
   //     for(Recipe recipe: recipes){
   //         productBase64Images.put(recipe.getId(), Base64.getEncoder().encodeToString(recipe.getImage()));
      //  }

        model.addAttribute("images", productBase64Images);
        model.addAttribute("recipes", recipes);
        //System.out.println("categoryOptional " + categoryOptional.get().getId());
        //System.out.println("unitOfMeasureOptional " + unitOfMeasureOptional.get().getId());
        return "index";
    }
/*
    public List<Recipe> loadData(){

//        insert into recipe (cock_time, description, directions, prep_time, servings, source, url, notes_id)
//        values
//                (35, 'Sweet and Sour Cabbage Soup','Freeze the butter, Line a baking sheet, Mix the dry ingredients, Cut in the butter, Mix the wet ingredients'
//                        ,22,3,'https://www.simplyrecipes.com/sweet-and-sour-cabbage-soup-recipe-6835442'
//                        , 'https://www.simplyrecipes.com/sweet-and-sour-cabbage-soup-recipe-6835442');
        Recipe recipe1 = new Recipe();
        recipe1.setDescription("Pumpkin scones make a special weekend treat for a family breakfast or brunch.");
        recipe1.setCookTime(22);
        recipe1.setPrepTime(15);
        recipe1.setDirections("Freeze the butter, Line a baking sheet, Mix the dry ingredients, Cut in the butter, Mix the wet ingredients");
        recipe1.setServings(3);
        recipe1.setUrl("https://www.simplyrecipes.com/sweet-and-sour-cabbage-soup-recipe-6835442");

        //categories
        HashSet<Category> categories = new HashSet<>();
        categories.add(categoryRepository.findByDescription("American").get());
        recipe1.setCategories(categories);

        //Ingredients
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setAmount(new BigDecimal(0.55));
        ingredient1.setDescription("Lilies");
        ingredient1.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Ounce").get());
        ingredient1.setRecipe(recipe1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setAmount(new BigDecimal(1));
        ingredient2.setDescription("Onion");
        ingredient2.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Cup").get());
        ingredient2.setRecipe(recipe1);

        HashSet<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        recipe1.setIngredients(ingredients);

        Notes notes = new Notes();
        notes.setRecipeNotes("No notes be free");
        recipe1.setNotes(notes);
        notes.setRecipe(recipe1);

        byte[] image = getByteArrayImage("https://www.sbs.com.au/food/sites/sbs.com.au.food/files/strozzapreti-pumpkin-bacon.jpg");

        recipe1.setImage(image);
        recipe1.setSource("simplyrecipes");

/////////////////////////////////////////////////////////////////////////////////////
        Recipe recipe2 = new Recipe();
        recipe2.setDescription("Sweet and Sour Cabbage Soup");
        recipe2.setCookTime(22);
        recipe2.setPrepTime(15);
        recipe2.setDirections("Freeze the butter, Line a baking sheet, Mix the dry ingredients, Cut in the butter, Mix the wet ingredients");
        recipe2.setServings(3);

        //categories
        HashSet<Category> categories2 = new HashSet<>();
        categories2.add(categoryRepository.findByDescription("Mexican").get());
        recipe2.setCategories(categories2);

        //Ingredients
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setAmount(new BigDecimal(0.55));
        ingredient3.setDescription("Potato");
        ingredient3.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Ounce").get());
        ingredient3.setRecipe(recipe2);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setAmount(new BigDecimal(1));
        ingredient4.setDescription("Apples");
        ingredient4.setUnitOfMeasure(unitOfMeasureRepository.findByDescription("Teaspoon").get());
        ingredient4.setRecipe(recipe2);

        HashSet<Ingredient> ingredients2 = new HashSet<>();
        ingredients2.add(ingredient3);
        ingredients2.add(ingredient4);

        recipe2.setIngredients(ingredients2);

        Notes notes2 = new Notes();
        notes2.setRecipeNotes("No notes2 be free");
        recipe2.setNotes(notes2);
        notes2.setRecipe(recipe2);
        byte[] image2 = getByteArrayImage("https://i1.wp.com/wonkywonderful.com/wp-content/uploads/2019/06/mexican-street-corn-salad-3.jpg?fit=1200%2C1800&ssl=1");

        recipe2.setImage(image2);
        recipe2.setUrl("https://wonkywonderful.com/mexican-street-corn-salad-recipe/");
        recipe2.setSource("wonkywonderful");

        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);

        return new LinkedList<>(Arrays.asList(recipe1, recipe2));
    }

 */
    private byte[] getByteArrayImage(String imageUrl) {

        URL url = null;
        try {
            url = new URL(imageUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            byte[] chunk = new byte[4096];
            int bytesRead;
            InputStream stream = url.openStream();

            while ((bytesRead = stream.read(chunk)) > 0) {
                outputStream.write(chunk, 0, bytesRead);
            }

            url.openStream().close();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputStream.toByteArray();
    }
}
