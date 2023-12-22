package com.github.aetherialmist.recipe.javafx.pane;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class EditIngredientsPane extends VBox {

    private final List<IngredientRow> ingredientRows = new ArrayList<>();

    public EditIngredientsPane() {
        super();
        Constants.clearStyle(this);
        this.addIngredientRow();
    }

    private IngredientRow addIngredientRow() {
        IngredientRow ingredientRow = new IngredientRow(ingredientRows.size());
        ingredientRows.add(ingredientRow);
        ingredientRow.setCallback(() -> {
            if (ingredientRow.getIndex() == ingredientRows.size() - 1) {
                if (!ingredientRow.getIngredientName().isBlank()) {
                    addIngredientRow().setFocus();
                }
                ingredientRow.highlightInvalid();
            }
        });
        this.getChildren().add(ingredientRow);
        return ingredientRow;
    }

    public static class IngredientRow extends HBox {

        @Getter
        private final int index;
        private final TextField amount = new TextField();
        private final TextField unit = new TextField();
        private final TextField ingredientName = new TextField();

        public IngredientRow(int index) {
            super();
            this.setSpacing(5);
            this.index = index;
            Constants.clearStyle(this);

            amount.setPromptText("Amount");
            amount.setPrefWidth(45);

            unit.setPromptText("Unit");
            unit.setPrefWidth(90);

            ingredientName.setPromptText("Ingredient Name");
            ingredientName.setPrefWidth(400);

            this.getChildren().addAll(amount, unit, ingredientName);
        }

        public String getAmount() {
            return amount.getText();
        }

        public String getUnit() {
            return unit.getText();
        }

        public String getIngredientName() {
            return ingredientName.getText();
        }

        public void setCallback(Runnable callback) {
            ingredientName.setOnAction(event -> callback.run());
        }

        public void setFocus() {
            amount.requestFocus();
        }

        public boolean isValid() {
            return !amount.getText().isBlank() && !unit.getText().isBlank() && !ingredientName.getText().isBlank();
        }

        public void highlightInvalid() {
            highlightIfInvalid(amount);
            highlightIfInvalid(unit);
            highlightIfInvalid(ingredientName);
        }

        private void highlightIfInvalid(TextField textField) {
            if (textField.getText().isBlank()) {
                textField.setStyle("-fx-background-color: rgba(255,0,0,0.25);");
            } else {
                textField.setStyle("");
            }
        }

    }

}
