package com.loadingeli.chapstickDistribution.employee;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private Integer hours;
    @Column
    private String role;

    public Employee() {

    }

    public Employee(Long id, String name, String password, String email, Integer hours, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.hours = hours;
        this.role = role;

    }

    public Employee(String member) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
