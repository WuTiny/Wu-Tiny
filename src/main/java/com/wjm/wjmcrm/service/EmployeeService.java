package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjm.wjmcrm.entity.Employee;

public interface EmployeeService extends IService<Employee> {
    IPage<Employee> selectList(Page<Employee> page);
    Employee selectByName(String empName);
    Integer add(Employee employee,Integer roleId);
    Integer update(Employee employee,Integer roleId);
    Integer del(Integer empId);
    IPage<Employee> selectByDel(Page<Employee> page);
    Integer selectByRoleName(String roleName);
    Integer recover(Integer empId);
}

