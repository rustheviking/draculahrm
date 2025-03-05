package com.virusoft.draculahrm.utils.window;

import javafx.stage.Stage;

public class WindowUtil {
    public static void toggleFullscreen(Stage stage) {
        stage.setFullScreen(!stage.isFullScreen());
    }

    public static void resize(Stage stage, double width, double height) {
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
