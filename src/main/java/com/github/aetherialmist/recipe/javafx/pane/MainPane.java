package com.github.aetherialmist.recipe.javafx.pane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class MainPane extends BorderPane {

    private MenuBar menuBar;
    private LeftNavBar leftNavBar;
    private DisplayPane displayPane;

    public MainPane() {
        super();
        Constants.clearStyle(this);
        boolean isDebug = System.getProperty("debug") != null && System.getProperty("debug").equals("true");

        this.menuBar = new MenuBar(isDebug);
        this.leftNavBar = new LeftNavBar(isDebug);
        this.displayPane = new DisplayPane(isDebug);
        this.setTop(menuBar);
        this.setLeft(leftNavBar);
        this.setCenter(displayPane);

        linkNewRecipeButton();
        linkSaveRecipeButton();

        ObservableList<String> recipeList = FXCollections.observableList(new ArrayList<>());
        recipeList.add("Recipe 1");
        recipeList.add("Recipe 2");
        recipeList.add("Recipe 3");
        recipeList.add("Recipe 4");
        bindRecipeList(recipeList);
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

    public void bindRecipeList(ObservableList<String> recipeList) {
        leftNavBar.bindRecipeList(recipeList);
    }

}
