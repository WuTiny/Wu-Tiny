package com.wjm.wjmcrm.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjm.wjmcrm.entity.Department;
import com.wjm.wjmcrm.mapper.DepartmentMapper;
import com.wjm.wjmcrm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper,Department> implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public IPage<Department> selectList(Page<Department> page) {
        return departmentMapper.selectList(page);
    }

    @Override
    public Integer add(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public Integer update(Department department) {
        return departmentMapper.updateById(department);
    }
}
