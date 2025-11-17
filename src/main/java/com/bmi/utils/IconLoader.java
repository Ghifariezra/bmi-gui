package com.bmi.utils;

import javafx.scene.image.Image;

public class IconLoader {
    private static final String ICON_PATH = "/bmi.png";

    private IconLoader() {}

    public static Image loadAppIcon() {
        return new Image(IconLoader.class.getResourceAsStream(ICON_PATH));
    }
}
