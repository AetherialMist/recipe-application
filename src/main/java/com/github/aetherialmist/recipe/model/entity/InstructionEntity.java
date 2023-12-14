package com.github.aetherialmist.recipe.model.entity;

import com.github.aetherialmist.recipe.model.pk.InstructionPk;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(InstructionPk.class)
public class InstructionEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private long recipeId;
    @Id
    private int step;

    private String instruction;

}
