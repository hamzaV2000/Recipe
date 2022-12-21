package com.guru.recipe.domain;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

    private String description;

    public Category() {
    }

    public Long getId() {
        return this.id;
    }

    public Set<Recipe> getRecipes() {
        return this.recipes;
    }

    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }
}
