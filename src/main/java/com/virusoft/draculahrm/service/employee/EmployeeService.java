package com.virusoft.draculahrm.service.employee;

import com.virusoft.draculahrm.dao.employee.EmployeeDAO;
import com.virusoft.draculahrm.model.pim.employee.Employee;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public void addEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }
}

