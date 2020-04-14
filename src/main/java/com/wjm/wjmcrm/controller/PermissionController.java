package com.wjm.wjmcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Permission;
import com.wjm.wjmcrm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    /**
     *  查询一页员工信息
     */
    @GetMapping("/perm")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        //设置mybatisPlus分页
        Page<Permission> p = new Page<Permission>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Permission> iPage = permissionService.selectList(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        System.out.println(map);
        return map;
    }

    /**
     *  新增用户
     */
    @PostMapping("/perm")
    public Map add(Permission permission,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionService.add(permission,roleId));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/perm/del/{permId}")
    public Map del(@PathVariable Integer permId){
        Permission permission = new Permission();
        permission.setPermId(permId);
        permission.setIsDel(1);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionService.updateById(permission));
        return result;
    }

    /**
     *  修改用户
     */
    @PutMapping("/perm")
    public Map edit(Permission permission,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",permissionService.update(permission,roleId));
        return result;
    }
}