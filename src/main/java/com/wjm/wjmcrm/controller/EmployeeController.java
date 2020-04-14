package com.wjm.wjmcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.entity.Role;
import com.wjm.wjmcrm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employeeList")
    public List<Employee> employee(){
        return employeeService.list();
    }

    /**
     * 查询一页员工信息
     * url:/emp/每页条数/当前页码
     * /emp/10/1
     */
    @GetMapping("/emp")
    public Map getList(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String,Object> ();
        //设置mybatisPlus分页
        Page<Employee> p = new Page<Employee>();
        p.setSize(limit);//设置每页记录数
        p.setCurrent(page);//设置当前页码
        IPage<Employee> iPage=employeeService.selectList(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @GetMapping("/emp/selectByDel")
    public Map selectByDel(Integer page,Integer limit){
        Map<String,Object> map = new HashMap<String,Object> ();
        Page<Employee> p = new Page<Employee>();
        p.setSize(limit);//设置每页记录数
        p.setCurrent(page);//设置当前页码
        IPage<Employee> iPage=employeeService.selectByDel(p);
        map.put("msg","");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    /**
     *  新增用户
     */
    @PostMapping("/emp/add")
    public Map add(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.add(employee,roleId));
        return result;
    }

    /**
     *  删除用户
     */
    @DeleteMapping("/emp/del/{empId}")
    public Map del(@PathVariable Integer empId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.del(empId));
        return result;
    }

    /**
     *  修改用户
     */
    @PutMapping("/edit")
    public Map edit(Employee employee,Integer roleId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.update(employee,roleId));
        return result;
    }

    @DeleteMapping("/emp/recover/{empId}")
    public Map recover(@PathVariable Integer empId){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("state",employeeService.recover(empId));
        return result;
    }
}
