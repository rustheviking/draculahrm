package com.virusoft.draculahrm.model.pim.employee;

import com.virusoft.draculahrm.model.auth.User;
import com.virusoft.draculahrm.model.base.BaseEntity;
import com.virusoft.draculahrm.model.base.Department;
import com.virusoft.draculahrm.model.base.Position;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "employee_number", unique = true, nullable = false)
    private String employeeNumber;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @Column(nullable = false)
    private Date hireDate;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private User user;


    // Default Constructor
    public Employee() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


//    @PrePersist
//    private void generateEmployeeNumber(){
//        // this.employeeNumber = "EMP-" + System.currentTimeMillis();
//        // this.employeeNumber = "EMP-" + UUID.randomUUID().toString().substring(0,8);
//
//        if (this.employeeNumber == null){
//            this.employeeNumber = EmployeeService.generateEmployeeNumber();
//        }
//    }
}


