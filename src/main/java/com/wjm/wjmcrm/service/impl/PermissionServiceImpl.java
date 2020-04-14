package com.wjm.wjmcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjm.wjmcrm.entity.DeptRole;
import com.wjm.wjmcrm.entity.Permission;
import com.wjm.wjmcrm.entity.Role;
import com.wjm.wjmcrm.entity.RolePerm;
import com.wjm.wjmcrm.mapper.DeptRoleMapper;
import com.wjm.wjmcrm.mapper.PermissionMapper;
import com.wjm.wjmcrm.mapper.RoleMapper;
import com.wjm.wjmcrm.mapper.RolePermMapper;
import com.wjm.wjmcrm.service.PermissionService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermMapper rolePermMapper;

    @Override
    public IPage<Permission> selectList(Page<Permission> page) {
        return permissionMapper.selectList(page);
    }

    @Override
    public Permission selectByName(String roleName) {
        return null;
    }


    @Override
    public Integer add(Permission permission, Integer roleId) {
        permission.setCreateTime(StringUtils.getNowTime());
        permission.setUpdateTime(permission.getCreateTime());  //获取创建时间，可以提高一点性能
        permission.setIsDel(0);
        int result =  permissionMapper.insert(permission);
        int permId = permission.getPermId();  //获取插入自增的id
        //将roleId和deptId一同插入到  员工与角色关系表
        RolePerm rolePerm = new RolePerm(permId,roleId);
        rolePerm.setCreateTime(StringUtils.getNowTime());
        rolePerm.setUpdateTime(rolePerm.getCreateTime());
        rolePerm.setIsDel(0);
        rolePermMapper.insert(rolePerm);
        return result;
    }

    @Override
    public Integer update(Permission permission,Integer roleId) {
        permission.setCreateTime(StringUtils.getNowTime());
        int result = permissionMapper.updateById(permission);
        RolePerm rolePerm = new RolePerm(permission.getPermId(),roleId);
        rolePerm.setUpdateTime(StringUtils.getNowTime());
        AbstractWrapper wrapper = new QueryWrapper();
        wrapper.eq("role_id",permission.getPermId());
        rolePermMapper.update(rolePerm,wrapper);
        return result;
    }

}
