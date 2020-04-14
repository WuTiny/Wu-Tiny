package com.wjm.wjmcrm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Business;
import com.wjm.wjmcrm.service.BusinessService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController

public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @GetMapping("/businessList")
    public List<Business> lists(){
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        return businessService.list(wrapper.eq("is_del",0));
    }
    @GetMapping("/business")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Business> p = new Page<Business>();
        p.setSize(limit);
        p.setCurrent(page);
        QueryWrapper<Business> wrapper=new QueryWrapper<>();
        IPage<Business> iPage=businessService.page(p,wrapper.eq("is_del",0));
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @PostMapping("/business")
    public Map add(Business business){
        Map<String,Object> map=new HashMap<>();
        business.setUpdateTime(StringUtils.getNowTime());
        business.setCreateTime(business.getUpdateTime());
        if (businessService.save(business)){
            map.put("state",1);
        }
        return map;
    }
    @DeleteMapping("/business/del/{businessId}")
    public Map del(@PathVariable Integer businessId){
        Map<String,Object> map=new HashMap<>();
        Business business=new Business();
        business.setIsDel(1);
        business.setUpdateTime(StringUtils.getNowTime());
        business.setBusinessId(businessId);
        map.put("state",businessService.updateById(business));
        return map;
    }
    @PutMapping("/business")
    public Map update(Business business){
        Map<String,Object> map=new HashMap<>();
        business.setUpdateTime(StringUtils.getNowTime());
        map.put("state",businessService.updateById(business));
        return map;
    }

}
