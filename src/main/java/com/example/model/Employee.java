package com.example.model;

import javax.persistence.*;

/**
 * Created by pkpk1234 on 2017/5/8.
 */
@Entity

// sql mapping like mybatis
@SqlResultSetMapping(
        name = "employeeDetailMapping",
        classes = {
                @ConstructorResult(
                        targetClass = EmployeeDetail.class,
                        columns = {
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "department_name"),
                                @ColumnResult(name = "role_name"),
                                @ColumnResult(name = "position")
                        }
                )
        }
)

@NamedNativeQueries(value={  // NamedNativeQuery name must start with entity class name Employee
        @NamedNativeQuery(name = "Employee.findAllEmployeeDetail", query = "SELECT e.name,d.department_name,r.role_name,e.position FROM employee e,employee_role r,department d" +
                " WHERE e.role_id = r.id AND e.department_id = d.id", resultSetMapping = "employeeDetailMapping"),

        @NamedNativeQuery(name="Employee.findEmployeeDetailByRoleName",query="SELECT e.name,d.department_name,r.role_name,e.position FROM employee e,employee_role r,department d" +
                " WHERE e.role_id = r.id AND e.department_id = d.id and r.role_name = :roleName", resultSetMapping = "employeeDetailMapping"),

        @NamedNativeQuery(name="Employee.findEmployeeDetailByNameAndDepartmentName",query="SELECT e.name,d.department_name,r.role_name,e.position FROM employee e,employee_role r,department d" +
                " WHERE e.role_id = r.id AND e.department_id = d.id and e.name = :eName and d.department_name = :dName", resultSetMapping = "employeeDetailMapping")
})
public class Employee {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String position;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "department_id")
    private Long depId;

    public Employee() {
    }

    public Employee(String name, String position, Long roleId, Long depId) {
        this.name = name;
        this.position = position;
        this.roleId = roleId;
        this.depId = depId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", roleId=" + roleId +
                ", depId=" + depId +
                '}';
    }
}
