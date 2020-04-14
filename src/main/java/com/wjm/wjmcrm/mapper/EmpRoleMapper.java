package com.wjm.wjmcrm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjm.wjmcrm.entity.EmpRole;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRoleMapper extends BaseMapper<EmpRole> {
    Integer del(Integer empId);
    Integer update(EmpRole empRole);

}
