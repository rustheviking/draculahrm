package com.virusoft.draculahrm.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{
    @Column(unique = true, nullable = false)
    private  String name; // Example: "Admin", "HR", "Finance", "Employee"

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
