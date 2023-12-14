package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.layout.StackPane;

public class DisplayPane extends StackPane {

    private static final String BORDER_STYLE = "-fx-border-color: blue; -fx-border-width: 2px;";

    public DisplayPane() {
        super();
        this.setStyle(BORDER_STYLE);
    }

}
