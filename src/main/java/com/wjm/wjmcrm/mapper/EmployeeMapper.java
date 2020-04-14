package com.wjm.wjmcrm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
    //Employee Login(Employee employee);
    IPage<Employee> selectList(Page<Employee> page);
    Employee selectByName(String empName);
    IPage<Employee> selectByDel(Page<Employee> page);
    Integer selectByRoleName(String roleName);
}

