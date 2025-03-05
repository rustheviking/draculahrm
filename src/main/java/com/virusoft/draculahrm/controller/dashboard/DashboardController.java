package com.virusoft.draculahrm.controller.dashboard;

import com.virusoft.draculahrm.utils.sceneSwitch.SwitchUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.ImageView;

public class DashboardController {
    @FXML public Label roundedLabel;
    @FXML public Label navbarButtonLabel;
    @FXML public ImageView userImageView;
    @FXML public MenuButton usernameMenuButton;
    @FXML private Button btnEmployees;

    public void openEmployees() {
        SwitchUtil.switchScene(btnEmployees, "/view/pim.fxml");
    }
}
