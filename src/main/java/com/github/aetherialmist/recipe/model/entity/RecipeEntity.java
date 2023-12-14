package com.github.aetherialmist.recipe.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecipeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private long id;

    private String imageReference;
    private String name;
    private String description;
    private Duration prepTime;
    private Duration cookTime;
    private Duration keepLeftovers;

}
