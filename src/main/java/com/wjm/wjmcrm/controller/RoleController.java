package com.wjm.wjmcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Role;
import com.wjm.wjmcrm.service.RoleService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

   @GetMapping("/roleList")
    public List<Role> roles(){
        return roleService.list();
    }

    /**
     *  查询一页员工信息
     */
    @GetMapping("/role")
    public Map getList(Integer page, Integer limit ){
        Map<String,Object> map = new HashMap<String,Object>();
        //设置mybatisPlus分页
        Page<Role> p = new Page<Role>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Role> iPage = roleService.selectList(p);
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
    @PostMapping("/role")
    public Map add(Role role,Integer deptId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.add(role,deptId));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/role/del/{roleId}")
    public Map del(@PathVariable Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        Role role = new Role();
        role.setRoleId(roleId);
        role.setUpdateTime(StringUtils.getNowTime());
        role.setIsDel(1);
        result.put("state",roleService.updateById(role));
        return result;
    }

    /**
     *  修改用户
     */
    @PutMapping("/role")
    public Map edit(Role role,Integer deptId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",roleService.update(role,deptId));
        return result;
    }
}
