package com.virusoft.draculahrm.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/virusoft/draculahrm/view/auth/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 626, 500);
        stage.setTitle("DraculaHRM System - Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
