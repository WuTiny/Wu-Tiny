package com.wjm.wjmcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Customer;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.entity.Orders;
import com.wjm.wjmcrm.mapper.CustomerMapper;
import com.wjm.wjmcrm.mapper.OrdersMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjm.wjmcrm.service.OrdersService;
import com.wjm.wjmcrm.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public IPage<Orders> selectOrders(Page<Orders> page) {
        Subject subject = SecurityUtils.getSubject();
        Employee employee = (Employee) subject.getPrincipal();
        return ordersMapper.selectOrders(page,employee.getEmpId());
    }

    @Override
    public Integer add(Orders orders) {
        orders.setCreateTime(StringUtils.getNowTime());
        orders.setUpdateTime(orders.getCreateTime());
        Integer a=ordersMapper.insert(orders);
        QueryWrapper<Customer> wrapper=new QueryWrapper<>();
        if (customerMapper.selectOne(wrapper.eq("customer_id",orders.getCustomerId()).eq("is_orders",1))==null){
            Customer customer=new Customer();
            customer.setCustomerId(orders.getCustomerId());
            customer.setIsOrders(1);
            customerMapper.updateById(customer);
        }
        return a;
    }

}
