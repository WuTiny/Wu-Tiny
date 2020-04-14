package com.wjm.wjmcrm.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wjm.wjmcrm.entity.Department;

public interface DepartmentService extends IService<Department>{
    IPage<Department> selectList(Page<Department> page);
    Integer add(Department department);
    Integer update(Department department);
}
