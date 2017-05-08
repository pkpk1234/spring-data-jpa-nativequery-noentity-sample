package com.example.model;

/**
 * Created by pkpk1234 on 2017/5/8.
 */
public class EmployeeDetail {

    private String employeeName;
    private String departmentName;
    private String roleName;
    private String jobPosition;

    public EmployeeDetail() {
    }

    public EmployeeDetail(String employeeName, String departmentName, String roleName, String jobPosition) {
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.roleName = roleName;
        this.jobPosition = jobPosition;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    @Override
    public String toString() {
        return "EmployeeDetail{" +
                "employeeName='" + employeeName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", roleName='" + roleName + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                '}';
    }
}
