package com.guru.recipe.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by jt on 6/21/17.
 */
@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {
    private Long id;
    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom;

    @Override
    public String toString() {
        return "IngredientCommand{" +
                "id=" + id +
                ", recipeId=" + recipeId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", uom=" + uom +
                '}';
    }
}
