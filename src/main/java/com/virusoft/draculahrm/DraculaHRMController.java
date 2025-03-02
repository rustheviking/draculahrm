package com.virusoft.draculahrm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DraculaHRMController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}