package com.virusoft.draculahrm.controller.pim.employee;

import com.virusoft.draculahrm.model.base.Department;
import com.virusoft.draculahrm.model.pim.employee.Employee;
import com.virusoft.draculahrm.service.pim.employee.EmployeeService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.util.List;


public class EmployeeController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private ComboBox<Department> departmentComboBox;

    private final EmployeeService employeeService = new EmployeeService(); // Uses service layer

    @FXML
    public void initialize() {
        loadDepartments();
    }

    private void loadDepartments() {
        List<Department> departments = employeeService.getAllDepartments(); // Fetch from service
        if (departments != null) {
            departmentComboBox.getItems().addAll(departments);
        }
    }

    @FXML
    private void handleSaveEmployee() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        Department selectedDepartment = departmentComboBox.getValue();

        if (firstName.isEmpty() || lastName.isEmpty() || selectedDepartment == null) {
            showAlert("Error", "All fields are required!", Alert.AlertType.ERROR);
            return;
        }

        Employee employee = new Employee(firstName, lastName, selectedDepartment);
        employeeService.saveEmployee(employee); // Calls service layer

        showAlert("Success", "Employee saved successfully!", Alert.AlertType.INFORMATION);
        clearFields();
    }

    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        departmentComboBox.setValue(null);
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}


