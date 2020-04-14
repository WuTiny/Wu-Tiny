package com.wjm.wjmcrm.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Orders;
import com.wjm.wjmcrm.service.OrdersService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController

public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @GetMapping("/orders")
    public Map list(Integer page, Integer limit){
        Map<String,Object> map = new HashMap<String,Object>();
        Page<Orders> p = new Page<Orders>();
        p.setSize(limit);
        p.setCurrent(page);
        IPage<Orders> iPage=ordersService.selectOrders(p);
        map.put("msg","查询情况");
        map.put("count",iPage.getTotal());
        map.put("data",iPage.getRecords());
        map.put("code",0);
        return map;
    }
    @DeleteMapping("/orders/del/{ordersId}")
    public Map del(@PathVariable Integer ordersId){
        Map<String,Object> map=new HashMap<>();
        Orders orders=new Orders();
        orders.setOrdersId(ordersId);
        orders.setIsDel(1);
        orders.setUpdateTime(StringUtils.getNowTime());
        map.put("state",ordersService.updateById(orders));
        return map;
    }
    @PostMapping("/orders")
    public Map add(Orders orders){
        Map<String,Object> map=new HashMap<>();
        map.put("state",ordersService.add(orders));
        return map;
    }
    @PutMapping("/orders")
    public Map update(Orders orders){
        Map<String,Object> map=new HashMap<>();
        orders.setUpdateTime(StringUtils.getNowTime());
        map.put("state",ordersService.updateById(orders));
        return map;
    }
}
