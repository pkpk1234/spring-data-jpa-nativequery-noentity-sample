package com.example.dao;

import com.example.model.Employee;
import com.example.model.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;


/**
 * Created by pkpk1234 on 2017/5/8.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //native query method name must equals the name in @NamedNativeQuery
    @Query(nativeQuery = true)
    Collection<EmployeeDetail> findAllEmployeeDetail();

    @Query(nativeQuery = true)
    Collection<EmployeeDetail> findEmployeeDetailByRoleName(@Param("roleName") String roleName);

    // not must add @Query(nativeQuery = true)
    EmployeeDetail findEmployeeDetailByNameAndDepartmentName(@Param("eName") String employeeName,@Param("dName") String departmentName);
}
