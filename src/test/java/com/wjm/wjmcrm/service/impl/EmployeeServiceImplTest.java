package com.wjm.wjmcrm.service.impl;

import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void add(){
        Employee employee = new Employee(null,"hello","123","123",18,"男","111111","广东省",null);
        employee.setCreateTime("2020-3-25");
        employee.setUpdateTime("2020-3-25");
        employee.setIsDel(0);
        employeeService.save(employee);
    }

    @Test
    public void add1() {
        Employee employee = new Employee(null,"h","123","123",18,"男","11111","广东省",null);
        employeeService.add(employee,1);

    }
}