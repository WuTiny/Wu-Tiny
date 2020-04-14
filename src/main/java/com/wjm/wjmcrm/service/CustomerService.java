package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjm.wjmcrm.entity.Customer;

public interface CustomerService extends IService<Customer> {
    IPage<Customer> selectList(Page<Customer> page);
}
