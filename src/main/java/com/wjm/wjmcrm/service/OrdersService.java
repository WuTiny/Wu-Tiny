package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;


public interface OrdersService extends IService<Orders> {
    IPage<Orders> selectOrders(Page<Orders> page);
    Integer add(Orders orders);

}
