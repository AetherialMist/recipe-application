package com.github.aetherialmist.recipe.javafx.pane;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LeftNavBar extends VBox {

    private static final String BORDER_STYLE = "-fx-border-color: red; -fx-border-width: 2px;";

    private TextField searchField;
    private ScrollPane scrollPane;
    private VBox recipeListVBox;

    private Map<String, Label> recipeLabels = new ConcurrentHashMap<>();

    public LeftNavBar(boolean isDebug) {
        super();
        this.setMinWidth(300);
        Constants.clearStyle(this);

        if (isDebug) {
            this.setStyle(BORDER_STYLE);
        }

        this.searchField = new TextField();
        this.searchField.setPromptText("Search");
        this.getChildren().add(searchField);

        this.scrollPane = new ScrollPane();
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        this.scrollPane.prefHeightProperty().bind(this.heightProperty().subtract(this.searchField.heightProperty()));
        Constants.clearStyle(this.scrollPane);
        this.getChildren().add(scrollPane);

        this.recipeListVBox = new VBox();
        Constants.clearStyle(this.recipeListVBox);
        this.scrollPane.setContent(recipeListVBox);
    }

    public void bindRecipeList(ObservableList<String> recipeList) {
        for (String recipe : recipeList) {
            Label label = new Label(recipe);
            label.setOnMouseClicked(event -> {
                System.out.println("Clicked " + recipe);
            });
            this.recipeLabels.put(recipe, label);
            this.recipeListVBox.getChildren().add(label);
        }
        recipeList.addListener((ListChangeListener<String>) c -> {
            for (String recipe : c.getAddedSubList()) {
                if (!recipeLabels.containsKey(recipe)) {
                    Label label = new Label(recipe);
                    label.setOnMouseClicked(event -> {
                        System.out.println("Clicked " + recipe);
                    });
                    recipeLabels.put(recipe, label);
                    recipeListVBox.getChildren().add(label);
                }
            }
            for (String recipe : c.getRemoved()) {
                if (recipeLabels.containsKey(recipe)) {
                    recipeListVBox.getChildren().remove(LeftNavBar.this.recipeLabels.get(recipe));
                    recipeLabels.remove(recipe);
                }
            }
        });
    }

}
