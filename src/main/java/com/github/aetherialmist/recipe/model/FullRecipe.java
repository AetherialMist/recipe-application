package com.github.aetherialmist.recipe.model;

import com.github.aetherialmist.recipe.model.entity.IngredientEntity;
import com.github.aetherialmist.recipe.model.entity.InstructionEntity;
import com.github.aetherialmist.recipe.model.entity.RecipeEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FullRecipe {

    private RecipeEntity details;
    private List<InstructionEntity> instructions;
    private List<IngredientEntity> ingredients;

}
