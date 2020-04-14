package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjm.wjmcrm.entity.Role;

public interface RoleService extends IService<Role> {
    IPage<Role> selectList(Page<Role> page);
    //IPage<Role> selectByDel(Page<Role> page);
    //Role selectByName(String roleName);
    Integer add(Role role,Integer deptId);
    Integer update(Role role,Integer deptId);
}
