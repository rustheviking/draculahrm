package com.virusoft.draculahrm.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity{
    @Column(unique = true, nullable = false)
    private  String name; // Example: "IT", "HR", "Finance"

    public Department(){}

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
