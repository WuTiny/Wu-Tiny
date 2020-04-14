package com.wjm.wjmcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjm.wjmcrm.entity.Customer;
import com.wjm.wjmcrm.mapper.CustomerMapper;
import com.wjm.wjmcrm.mapper.EmployeeMapper;
import com.wjm.wjmcrm.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CustomerServiceImpl  extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public IPage<Customer> selectList(Page<Customer> page) {
        return customerMapper.selectList(page);
    }


}
