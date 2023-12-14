package com.github.aetherialmist.recipe.model.pk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructionPk implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long recipeId;
    private int step;
}
