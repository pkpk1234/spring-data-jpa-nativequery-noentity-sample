package com.example.model;

import javax.persistence.*;

/**
 * Created by pkpk1234 on 2017/5/8.
 */
@Entity
@Table(name="employee_role")
public class EmployeeRole {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    public EmployeeRole() {
    }

    public EmployeeRole(String roleName) {
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "EmployeeRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
