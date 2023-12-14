package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.layout.BorderPane;

public class MainPane extends BorderPane {

    private MenuBar menuBar;
    private LeftNavBar leftNavBar;
    private DisplayPane displayPane;

    public MainPane() {
        super();
        this.menuBar = new MenuBar();
        this.leftNavBar = new LeftNavBar();
        this.displayPane = new DisplayPane();
        this.setTop(menuBar);
        this.setLeft(leftNavBar);
        this.setCenter(displayPane);

        linkNewRecipeButton();
        linkSaveRecipeButton();
    }

    private void linkNewRecipeButton() {
        menuBar.getNewRecipeButton().setOnAction(event -> {
            displayPane.getChildren().clear();
            displayPane.getChildren().add(new EditRecipePane());
            menuBar.swapNewOrSaveButton();
        });
    }

    private void linkSaveRecipeButton() {
        menuBar.getSaveRecipeButton().setOnAction(event -> {
            menuBar.swapNewOrSaveButton();
        });
    }

}
