package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LeftNavBar extends VBox {

    private static final String BORDER_STYLE = "-fx-border-color: red; -fx-border-width: 2px;";

    private TextField searchField;

    public LeftNavBar() {
        super();
        this.setMinWidth(300);
        this.setStyle(BORDER_STYLE);
        this.initSearchField();
        this.getChildren().add(searchField);
    }

    private void initSearchField() {
        this.searchField = new TextField();
        this.searchField.setPromptText("Search");
    }

}
