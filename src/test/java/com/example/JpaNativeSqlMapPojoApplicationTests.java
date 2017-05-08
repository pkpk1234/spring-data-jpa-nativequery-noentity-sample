package com.example;

import com.example.dao.EmployeeRepository;
import com.example.model.EmployeeDetail;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaNativeSqlMapPojoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(JpaNativeSqlMapPojoApplicationTests.class);

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testFindAllEmployeeDetail() {
        Collection<EmployeeDetail> allEmployeeDetail = employeeRepository.findAllEmployeeDetail();
        assertNotNull(allEmployeeDetail);
        logger.info("allEmployeeDetail >>>> " + String.join(",",
                allEmployeeDetail.stream().map(o -> o.toString()).collect(Collectors.toList())));
        assertEquals(5, allEmployeeDetail.size());
    }

    @Test
    public void testFindEmployeeDetailByRoleName() {
        Collection<EmployeeDetail> allProgrammers = employeeRepository.findEmployeeDetailByRoleName("programmer");
        assertNotNull(allProgrammers);
        logger.info("allProgrammers >>>> " + String.join(",",
                allProgrammers.stream().map(o -> o.toString()).collect(Collectors.toList())));
        assertEquals(3, allProgrammers.size());
    }

    @Test
    public void testFindEmployeeDetailByNameAndDepartmentName() {
        EmployeeDetail pkpk1234 = employeeRepository
                .findEmployeeDetailByNameAndDepartmentName("pkpk1234", "PLM");
        assertNotNull(pkpk1234);
        logger.info("pkpk1234 >>>> " + pkpk1234.toString());
        assertNotNull(pkpk1234.getRoleName());
        assertEquals("programmer", pkpk1234.getRoleName());
    }
}
