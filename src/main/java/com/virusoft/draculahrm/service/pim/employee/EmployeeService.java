package com.virusoft.draculahrm.service.pim.employee;

import com.virusoft.draculahrm.dao.pim.employee.EmployeeDAO;
import com.virusoft.draculahrm.model.base.Department;
import com.virusoft.draculahrm.model.pim.employee.Employee;
import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAO(); // Uses DAO for database operations

    public void saveEmployee(Employee employee) {
        String generatedNumber = employeeDAO.generateEmployeeNumber(); // Generate number
        employee.setEmployeeNumber(generatedNumber);
        employeeDAO.saveEmployee(employee); // Pass to DAO for saving
    }

    public List<Department> getAllDepartments() {
        return employeeDAO.getAllDepartments(); // Fetch departments from DAO
    }
}

