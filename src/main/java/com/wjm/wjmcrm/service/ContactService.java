package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Contact;
import com.baomidou.mybatisplus.extension.service.IService;


public interface ContactService extends IService<Contact> {
    IPage<Contact> list(Page<Contact> page);
}
