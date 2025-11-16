package com.bmi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.bmi.utils.IconLoader;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        BMICalculatorView view = new BMICalculatorView();

        Scene scene = new Scene(view.getRoot(), 400, 300);

        stage.getIcons().add(IconLoader.loadAppIcon());
        stage.setTitle("BMI Calculator");
        stage.setScene(scene);
        stage.show();
    }
}
