package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.Node;
import javafx.scene.layout.Region;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class Constants {

    public static final String TRANSPARENT = "-fx-focus-color: transparent; -fx-faint-focus-color: transparent; -fx-background-color: transparent;";

    public static void clearStyle(Node node) {
        node.getStyleClass().clear();
    }

    public static void clearStyle(Region region) {
        region.getStylesheets().clear();
        region.getStyleClass().clear();
    }
}
