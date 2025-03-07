package com.virusoft.draculahrm.controller.dashboard;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class DashboardNavbarController {
    public TextField searchTextField;
    public Button dashboardButton;
    public Button adminButton;
    public Button pimButton;
    public Button leaveButton;
    public Button timeButton;
    public Button recruitmentButton;
    public Button myinfoButton;
    public Button performanceButton;
    public Button directoryButton;
    public Button buzzButton;
    public Label clickableLabel;
    public ImageView adminImage;


    public void setupNavbar(String role) {
        // Hide or show buttons based on role
        if ("admin".equals(role)) {
            adminButton.setVisible(true);
            adminImage.setVisible(true);
            
        } else {
            adminButton.setVisible(false);
            adminImage.setVisible(false);

            adminButton.setManaged(false);
            adminImage.setManaged(false);
        }
    }



}
