package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjm.wjmcrm.entity.Permission;
import com.wjm.wjmcrm.entity.Role;

public interface PermissionService extends IService<Permission> {
    IPage<Permission> selectList(Page<Permission> page);
    Permission selectByName(String roleName);
    Integer add(Permission permission,Integer roleId);
    Integer update(Permission permission,Integer roleId);
}
