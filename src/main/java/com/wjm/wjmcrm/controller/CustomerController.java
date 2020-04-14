package com.wjm.wjmcrm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Customer;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.service.CustomerService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customer")
    public Map getList(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Customer> p = new Page<>();
        p.setSize(limit);
        p.setCurrent(page);
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        IPage<Customer> iPage=customerService.page(p,queryWrapper.eq("is_del",0).eq("emp_id",employee.getEmpId()));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @GetMapping("/customerPool")
    public Map pond(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Customer> page1 = new Page<>();
        page1.setSize(limit);
        page1.setCurrent(page);
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        IPage<Customer> iPage=customerService.page(page1,queryWrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @GetMapping("/customerList")
    public List<Customer> list(){
        QueryWrapper<Customer> queryWrapper=new QueryWrapper<>();
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return customerService.list(queryWrapper.eq("emp_id",employee.getEmpId()).eq("is_del",0));
    }
    @PostMapping("/customer")
    public Map add(Customer customer){
        Map<String,Object> map=new HashMap<>();
        customer.setCreateTime(StringUtils.getNowTime());
        customer.setUpdateTime(customer.getCreateTime());
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        customer.setEmpId(employee.getEmpId());
        if (customerService.save(customer)){
            map.put("state",1);
        }
        return  map;
    }
    @PutMapping("/customer")
    public Map update(Customer customer){
        Map<String,Object> map=new HashMap<>();
        customer.setUpdateTime(StringUtils.getNowTime());
        map.put("state",customerService.updateById(customer));
        return map;
    }
    @DeleteMapping("/customer/del/{customerId}")
    public Map del(@PathVariable Integer customerId){
        Map<String,Object> map=new HashMap<>();
        Customer customer=new Customer();
        customer.setCustomerId(customerId);
        customer.setIsDel(1);
        map.put("state",customerService.updateById(customer));
        return map;
    }
}
