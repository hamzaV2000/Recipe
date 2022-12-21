package com.guru.recipe.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    private Category category;
    @BeforeEach
    public void setup(){
        System.out.println("before each");
        category = new Category();
    }
    @Test
    void getId() {
        Long id = 4L;
        category.setId(id);

        assertEquals(id, category.getId());
    }

    @Test
    void getRecipes() {
    }

    @Test
    void getDescription() {
    }
}