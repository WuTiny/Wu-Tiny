package com.wjm.wjmcrm.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Department;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.service.DepartmentService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/deptList")
    public List<Department> list(){
        return departmentService.list();
    }
    @GetMapping("/dept")
    public Map depList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Department> p = new Page<Department>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Department> iPage=departmentService.page(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }

    @PostMapping("/dept")
    public Map add(Department department){
        Map<String,Object> map=new HashMap<>();
        department.setCreateTime(StringUtils.getNowTime());
        department.setUpdateTime(department.getCreateTime());
        department.setIsDel(0);
        if (departmentService.save(department)){
            map.put("state",1);
        }
        return map;
    }
    @DeleteMapping("/dept/del/{deptId}")
    public Map del(@PathVariable Integer deptId){
        Map<String,Object> map=new HashMap<>();
        Department department=new Department();
        department.setUpdateTime(StringUtils.getNowTime());
        department.setIsDel(1);
        department.setDeptId(deptId);
        map.put("state",departmentService.updateById(department));
        return map;
    }
    @PutMapping("/dept")
    public Map update(Department department){
        Map<String,Object> map=new HashMap<>();
        department.setUpdateTime(StringUtils.getNowTime());
        map.put("state",departmentService.updateById(department));
        return map;
    }
}
