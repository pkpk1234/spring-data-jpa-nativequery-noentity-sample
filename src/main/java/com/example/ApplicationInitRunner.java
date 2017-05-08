package com.example;

import com.example.dao.DepartmentRepository;
import com.example.dao.EmployeeRepository;
import com.example.dao.RoleRepository;
import com.example.model.Department;
import com.example.model.Employee;
import com.example.model.EmployeeRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * Created by pkpk1234 on 2017/5/8.
 */
@Component
public class ApplicationInitRunner implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(ApplicationInitRunner.class);
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;
    private final EmployeeRepository employeeRepository;

    public ApplicationInitRunner(DepartmentRepository departmentRepository, RoleRepository roleRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.roleRepository = roleRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Department plm = new Department("PLM");
        plm = departmentRepository.save(plm);
        Department erp = new Department("ERP");
        erp = departmentRepository.save(erp);
        Department crm = new Department("CRM");
        crm = departmentRepository.save(crm);

        EmployeeRole programmer = new EmployeeRole("programmer");
        programmer = roleRepository.save(programmer);
        EmployeeRole manager = new EmployeeRole("manager");
        manager = roleRepository.save(manager);

        Employee pkpk1234 = new Employee("pkpk1234", "15A", programmer.getId(), plm.getId());
        employeeRepository.save(pkpk1234);

        Employee lw = new Employee("lw", "15C", manager.getId(), plm.getId());
        employeeRepository.save(lw);

        Employee liz = new Employee("liz", "13B", programmer.getId(), erp.getId());
        employeeRepository.save(liz);

        Employee yaocc = new Employee("yaocc", "14B", manager.getId(), erp.getId());
        employeeRepository.save(yaocc);

        Employee redlin = new Employee("redlin", "18A", programmer.getId(), crm.getId());
        employeeRepository.save(redlin);
        logger.info("Sample data insert database complete.");
    }
}
