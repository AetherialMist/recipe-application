package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MenuBar extends BorderPane {

    private static final String BORDER_STYLE = "-fx-border-color: green; -fx-border-width: 2px;";

    private HBox leftSide;
    private HBox rightSide;
    private StackPane newOrSavePane;

    @Getter
    private Button newRecipeButton;
    @Getter
    private Button saveRecipeButton;
    private boolean isSaveButton;

    @Getter
    private Button deleteRecipeButton;
    @Getter
    private Button editRecipeButton;

    public MenuBar() {
        super();
        this.setMinHeight(30);
        this.setStyle(BORDER_STYLE);
        this.initLeftSide();
        this.initRightSide();
    }

    private void initLeftSide() {
        this.leftSide = new HBox();
        this.setLeft(leftSide);
        this.newOrSavePane = new StackPane();
        this.leftSide.getChildren().add(newOrSavePane);

        this.newRecipeButton = new Button("New Recipe");
        this.saveRecipeButton = new Button("Save Recipe");
        this.newRecipeButton.setOnAction(event -> log.info("New Recipe"));
        this.newOrSavePane.getChildren().add(newRecipeButton);
        this.isSaveButton = false;
    }

    private void initRightSide() {
        this.rightSide = new HBox();
        this.setRight(rightSide);

        this.deleteRecipeButton = new Button("Delete Recipe");
        this.deleteRecipeButton.setOnAction(event -> log.info("Delete Recipe"));
        this.rightSide.getChildren().add(deleteRecipeButton);
    }

    public void swapNewOrSaveButton() {
        if (isSaveButton) {
            this.newOrSavePane.getChildren().remove(saveRecipeButton);
            this.newOrSavePane.getChildren().add(newRecipeButton);
        } else {
            this.newOrSavePane.getChildren().remove(newRecipeButton);
            this.newOrSavePane.getChildren().add(saveRecipeButton);
        }
        isSaveButton = !isSaveButton;
    }

}
