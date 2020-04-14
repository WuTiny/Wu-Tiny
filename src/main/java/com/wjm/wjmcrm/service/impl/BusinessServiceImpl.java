package com.wjm.wjmcrm.service.impl;

import com.wjm.wjmcrm.entity.Business;
import com.wjm.wjmcrm.mapper.BusinessMapper;
import com.wjm.wjmcrm.service.BusinessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements BusinessService {

}
