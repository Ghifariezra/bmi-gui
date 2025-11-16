package com.bmi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import com.bmi.utils.RootBackground;

public class BMICalculatorView {

    private final VBox root = new VBox();

    public BMICalculatorView() {
        root.setBackground(RootBackground.getLightGrayBackground());
        root.setSpacing(12);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        Label weightLabel = new Label("Weight (kg):");
        Label heightLabel = new Label("Height (m):");
        Label resultLabel = new Label();
        Label statusLabel = new Label();
        TextField weightField = new TextField();
        TextField heightField = new TextField();
        Button calculateButton = new Button("Calculate BMI");

        calculateButton.setOnAction(e -> {
            String weight = weightField.getText();
            String height = heightField.getText();

            if (weight.isEmpty() || height.isEmpty()) {
                showError("Please enter both weight and height.");
                return;
            }

            try {
                double weightValue = Double.parseDouble(weight);
                double heightValue = Double.parseDouble(height);

                if (heightValue > 10) {
                    heightValue = heightValue / 100.0;
                }

                Person person = new Person(weightValue, heightValue);
                double bmi = person.calculateBMI();
                String status = person.checkBMIStatus();

                System.out.println("Calculated BMI: " + bmi);
                String backgroundColorStatus = "-fx-background-color: " + colorStatus(status) + ";";

                statusLabel.setStyle(
                        "-fx-font-weight: bold;" +
                                "-fx-font-size: 16px;" +
                                "-fx-padding: 10px;" +
                                backgroundColorStatus +
                                "-fx-background-radius: 5px;" +
                                "-fx-text-fill: #333333;"
                );

                resultLabel.setText(String.format("Your BMI is: %.2f", bmi));
                statusLabel.setText("Status: " + status);
            } catch (NumberFormatException ex) {
                showError("Please enter valid numbers for weight and height.");
            } catch (IllegalArgumentException ex) {
                showError(ex.getMessage());
            }
        });

        HBox weightLabelBox = new HBox(weightLabel);
        weightLabelBox.setAlignment(Pos.CENTER_LEFT);

        HBox heightLabelBox = new HBox(heightLabel);
        heightLabelBox.setAlignment(Pos.CENTER_LEFT);

        root.getChildren().addAll(
                        weightLabelBox,
                        weightField,
                        heightLabelBox,
                        heightField,
                        calculateButton,
                        resultLabel,
                        statusLabel);

    }

    public VBox getRoot() {
        return root;
    }

    private void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR, msg);
        alert.showAndWait();
    }

    private String colorStatus(String status) {
        return switch (status) {
            case "Underweight" -> "#ADD8E6";
            case "Normal weight" -> "#90EE90";
            case "Overweight" -> "#FFD700";
            case "Obesity" -> "#FF6347";
            default -> "#FFFFFF";
        };
    }
}
