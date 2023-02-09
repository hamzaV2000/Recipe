package com.guru.recipe.commands;


import com.guru.recipe.domain.Difficulty;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 6/21/17.
 */
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    @Min(1)
    @Max(999)
    private Integer prepTime;
    @Min(1)
    @Max(999)
    private Integer cookTime;
    @Min(1)
    @Max(100)
    private Integer servings;
    private String source;

    @URL
    private String url;
    @NotBlank
    @NotNull
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<CategoryCommand> categories = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public @NotBlank @Size(min = 3, max = 255) String getDescription() {
        return this.description;
    }

    public @Min(1) @Max(999) Integer getPrepTime() {
        return this.prepTime;
    }

    public @Min(1) @Max(999) Integer getCookTime() {
        return this.cookTime;
    }

    public @Min(1) @Max(100) Integer getServings() {
        return this.servings;
    }

    public String getSource() {
        return this.source;
    }

    public @URL String getUrl() {
        return this.url;
    }

    public @NotBlank @NotNull String getDirections() {
        return this.directions;
    }

    public Set<IngredientCommand> getIngredients() {
        return this.ingredients;
    }

    public byte[] getImage() {
        return image;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public NotesCommand getNotes() {
        return this.notes;
    }

    public Set<CategoryCommand> getCategories() {
        return this.categories;
    }
}
