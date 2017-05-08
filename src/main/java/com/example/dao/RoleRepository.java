package com.example.dao;

import com.example.model.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pkpk1234 on 2017/5/8.
 */
@Repository
public interface RoleRepository extends JpaRepository<EmployeeRole, Long> {
}
