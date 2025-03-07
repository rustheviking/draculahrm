package com.virusoft.draculahrm.controller.dashboard;

import com.virusoft.draculahrm.utils.sceneSwitch.SwitchUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.Objects;

public class DashboardController {
    @FXML public Label roundedLabel;
    @FXML public Label navbarButtonLabel;
    @FXML public ImageView userImageView;
    @FXML public MenuButton usernameMenuButton;


    @FXML public BorderPane dashboardBorderPane;

    @FXML private Button btnEmployees;

    @FXML public Pane dashboardNavbar;
    @FXML public AnchorPane navbarAnchorPane; // Navbar Container
    @FXML public AnchorPane menuAnchorPane; // Menu Container
    @FXML public AnchorPane contentAnchorPane; // Content Container

    private String userRole;

    public void initialize(String UserRole){
        //load user role
        userRole = UserRole;

        //load default Navbar, Menu, and Content
        loadNavbar("dashboard-navbar.fxml");
        loadMenu("dashboard-menu.fxml");
        loadContent("dashboard-content.fxml");
    }

    private void loadContent(String fxmlFile) {
        try {
            Parent menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/virusoft/draculahrm/view/dashboard/" + fxmlFile)));
            contentAnchorPane.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMenu(String fxmlFile) {
        try {
            Parent menu = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/virusoft/draculahrm/view/dashboard/" + fxmlFile)));
            menuAnchorPane.getChildren().setAll(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNavbar(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/virusoft/draculahrm/view/dashboard/" + fxmlFile));
            Parent navbar = loader.load();

            // Get the controller of navbar and pass user role
            DashboardNavbarController dashboardNavbarController = loader.getController();
            dashboardNavbarController.setupNavbar(userRole);

            dashboardNavbar.getChildren().setAll(navbar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
