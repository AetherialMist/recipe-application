package com.github.aetherialmist.recipe.javafx.pane;

import com.github.aetherialmist.recipe.model.FullRecipe;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EditRecipePane extends BorderPane {

    private ScrollPane primaryPane;
    private VBox formPane;

    public EditRecipePane(String title) {
        super();
        Constants.clearStyle(this);

        this.primaryPane = new ScrollPane();
        this.primaryPane.setPadding(new Insets(10, 0, 0, 10));
        this.primaryPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.primaryPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        Constants.clearStyle(this.primaryPane);
        this.setCenter(primaryPane);

        this.formPane = new VBox();
        this.formPane.setSpacing(10);
        Constants.clearStyle(this.formPane);
        this.primaryPane.setContent(formPane);

        Label label = new Label(title + " Recipe");
        label.setStyle("-fx-font-size: 24px;");
        this.formPane.getChildren().add(label);

        Label recipeNameLabel = new Label("Recipe Name");
        TextField recipeNameField = new TextField();
        HBox recipeNameHBox = new HBox();
        recipeNameHBox.setSpacing(10);
        recipeNameHBox.getChildren().addAll(recipeNameLabel, recipeNameField);
        this.formPane.getChildren().add(recipeNameHBox);

        Label ingredientsLabel = new Label("Ingredients");
        ingredientsLabel.setStyle("-fx-font-size: 18px;");
        this.formPane.getChildren().add(ingredientsLabel);

        EditIngredientsPane editIngredientsPane = new EditIngredientsPane();
        this.formPane.getChildren().add(editIngredientsPane);
    }

    public EditRecipePane(FullRecipe recipe) {
        super();
    }
}
