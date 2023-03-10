package com.guru.recipe.domain;


import jakarta.persistence.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    //todo add
    //private Difficulty difficulty;

    @Lob
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    public Recipe() {
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Recipe;
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getPrepTime() {
        return this.prepTime;
    }

    public Integer getCookTime() {
        return this.cookTime;
    }

    public Integer getServings() {
        return this.servings;
    }

    public String getSource() {
        return this.source;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDirections() {
        return this.directions;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return this.notes;
    }

    public Set<Category> getCategories() {
        if(categories == null)
            this.setCategories(new HashSet<>());
        return this.categories;
    }

    public Set<Ingredient> getIngredients() {
        if(ingredients == null)
            this.ingredients = new HashSet<>();
        return this.ingredients;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }



    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Recipe)) return false;
        final Recipe other = (Recipe) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$prepTime = this.getPrepTime();
        final Object other$prepTime = other.getPrepTime();
        if (this$prepTime == null ? other$prepTime != null : !this$prepTime.equals(other$prepTime)) return false;
        final Object this$cookTime = this.getCookTime();
        final Object other$cookTime = other.getCookTime();
        if (this$cookTime == null ? other$cookTime != null : !this$cookTime.equals(other$cookTime)) return false;
        final Object this$servings = this.getServings();
        final Object other$servings = other.getServings();
        if (this$servings == null ? other$servings != null : !this$servings.equals(other$servings)) return false;
        final Object this$source = this.getSource();
        final Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) return false;
        final Object this$url = this.getUrl();
        final Object other$url = other.getUrl();
        if (this$url == null ? other$url != null : !this$url.equals(other$url)) return false;
        final Object this$directions = this.getDirections();
        final Object other$directions = other.getDirections();
        if (this$directions == null ? other$directions != null : !this$directions.equals(other$directions))
            return false;
        if (!java.util.Arrays.equals(this.getImage(), other.getImage())) return false;
        final Object this$notes = this.getNotes();
        final Object other$notes = other.getNotes();
        if (this$notes == null ? other$notes != null : !this$notes.equals(other$notes)) return false;
        final Object this$categories = this.getCategories();
        final Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories))
            return false;
        final Object this$ingredients = this.getIngredients();
        final Object other$ingredients = other.getIngredients();
        if (this$ingredients == null ? other$ingredients != null : !this$ingredients.equals(other$ingredients))
            return false;
        final Object this$difficulty = this.getDifficulty();
        final Object other$difficulty = other.getDifficulty();
        if (this$difficulty == null ? other$difficulty != null : !this$difficulty.equals(other$difficulty))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $prepTime = this.getPrepTime();
        result = result * PRIME + ($prepTime == null ? 43 : $prepTime.hashCode());
        final Object $cookTime = this.getCookTime();
        result = result * PRIME + ($cookTime == null ? 43 : $cookTime.hashCode());
        final Object $servings = this.getServings();
        result = result * PRIME + ($servings == null ? 43 : $servings.hashCode());
        final Object $source = this.getSource();
        result = result * PRIME + ($source == null ? 43 : $source.hashCode());
        final Object $url = this.getUrl();
        result = result * PRIME + ($url == null ? 43 : $url.hashCode());
        final Object $directions = this.getDirections();
        result = result * PRIME + ($directions == null ? 43 : $directions.hashCode());
        result = result * PRIME + java.util.Arrays.hashCode(this.getImage());
        final Object $notes = this.getNotes();
        result = result * PRIME + ($notes == null ? 43 : $notes.hashCode());
        final Object $categories = this.getCategories();
        result = result * PRIME + ($categories == null ? 43 : $categories.hashCode());
        final Object $ingredients = this.getIngredients();
        result = result * PRIME + ($ingredients == null ? 43 : $ingredients.hashCode());
        final Object $difficulty = this.getDifficulty();
        result = result * PRIME + ($difficulty == null ? 43 : $difficulty.hashCode());
        return result;
    }

    public String toString() {
        return "Recipe(id=" + this.getId() + ", description=" + this.getDescription() + ", prepTime=" + this.getPrepTime() + ", cookTime=" + this.getCookTime() + ", servings=" + this.getServings() + ", source=" + this.getSource() + ", url=" + this.getUrl() + ", directions=" + this.getDirections() + ", image=" + java.util.Arrays.toString(this.getImage()) + ", notes=" + this.getNotes() + ", categories=" + this.getCategories() + ", ingredients=" + this.getIngredients() + ", difficulty=" + this.getDifficulty() + ")";
    }
}
