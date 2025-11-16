package com.bmi.utils;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class RootBackground {
    private RootBackground() {}
    
    public static Background getLightGrayBackground() {
        return new Background(new BackgroundFill(Color.WHITE, null, null));
    }
}
