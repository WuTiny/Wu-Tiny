package com.wjm.wjmcrm.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.wjm.wjmcrm.entity.Department;
import com.wjm.wjmcrm.entity.DeptRole;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.entity.Role;
import com.wjm.wjmcrm.mapper.DeptRoleMapper;
import com.wjm.wjmcrm.mapper.RoleMapper;
import com.wjm.wjmcrm.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;


    @Test
    public void add() {
        Role role =new Role();
        role.setRoleId(null);
        role.setRoleName("aaa");
        role.setCreateTime("2020-3-25");
        role.setUpdateTime("2020-3-25");
        role.setIsDel(0);
        roleService.save(role);
    }
}