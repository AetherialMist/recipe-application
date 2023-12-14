package com.github.aetherialmist.recipe.javafx.pane;

import com.github.aetherialmist.recipe.model.FullRecipe;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class EditRecipePane extends BorderPane {

    private ScrollPane primaryPane;
    private VBox formPane;

    public EditRecipePane() {
        super();
        this.primaryPane = new ScrollPane();
        this.primaryPane.setPadding(new Insets(10, 0, 0, 10));
        this.primaryPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.primaryPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.setCenter(primaryPane);

        this.formPane = new VBox();
        this.formPane.setSpacing(10);
        this.primaryPane.setContent(formPane);

        Label label = new Label("Edit Recipe");
        label.setStyle("-fx-font-size: 24px;");
        this.formPane.getChildren().add(label);
    }

    public EditRecipePane(FullRecipe recipe) {
        super();
    }
}
