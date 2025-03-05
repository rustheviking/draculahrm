package com.virusoft.draculahrm.controller.auth;

import com.virusoft.draculahrm.utils.sceneSwitch.SwitchUtil;
import com.virusoft.draculahrm.service.auth.AuthService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private final AuthService authService = new AuthService();

    @FXML public TextField usernameTextField;
    @FXML public PasswordField passwordPasswordField;
    @FXML public Button loginButton;
    @FXML public Button cancelButton;
    @FXML public Label forgetyourpasswordLabel;
    @FXML public Label loginMessageLabel;

    public void login() {
        if (usernameTextField.getText().equals("admin") && passwordPasswordField.getText().equals("1234")) {
            SwitchUtil.switchScene(loginButton, "/com/virusoft/draculahrm/view/dashboard/dashboard.fxml");
        }
    }
}
