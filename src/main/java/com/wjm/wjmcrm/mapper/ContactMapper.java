package com.wjm.wjmcrm.mapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjm.wjmcrm.entity.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMapper extends BaseMapper<Contact>{
    IPage<Contact> list(Page<Contact> page,Integer empId);
}
