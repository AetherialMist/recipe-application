package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.layout.StackPane;

public class DisplayPane extends StackPane {

    private static final String BORDER_STYLE = "-fx-border-color: blue; -fx-border-width: 2px;";

    public DisplayPane(boolean isDebug) {
        super();
        Constants.clearStyle(this);
        if (isDebug) {
            this.setStyle(BORDER_STYLE);
        }
        this.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
    }

}
