package com.virusoft.draculahrm.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity{
    @Column(unique = true, nullable = false)
    private  String name; // Example: "Software Engineer", "CSR", "HR Manager"

    public Position(){}

    public Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}