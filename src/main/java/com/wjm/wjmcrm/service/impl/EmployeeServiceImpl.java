package com.wjm.wjmcrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wjm.wjmcrm.entity.EmpRole;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.mapper.EmpRoleMapper;
import com.wjm.wjmcrm.mapper.EmployeeMapper;
import com.wjm.wjmcrm.service.EmployeeService;
import com.wjm.wjmcrm.utils.ShiroUtils;
import com.wjm.wjmcrm.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmpRoleMapper empRoleMapper;
    @Override
    public IPage<Employee> selectList(Page<Employee> page) {
        return employeeMapper.selectList(page);
    }
    @Override
    public Employee selectByName(String empName) {
        return employeeMapper.selectByName(empName);
    }
    @Override
    public IPage<Employee> selectByDel(Page<Employee> page) {
        return employeeMapper.selectByDel(page);
    }
    @Override
    public Integer selectByRoleName(String roleName) {
        return employeeMapper.selectByRoleName(roleName);
    }

    @Override
    public Integer add(Employee employee, Integer roleId) {
        /*
         *  1.获取盐
         *  2.shiro加盐加密
         *  3.用户信息存入对象，插入数据库，获取到插入的id
         *  4.将empId和roleId插入到emp_role表中
         */
        //从ShiroUtils类中随机生成盐
        employee.setSalt(ShiroUtils.randomSalt());
        //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
        employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        //设置时间，idDel
        employee.setCreateTime(StringUtils.getNowTime());
        //获取创建时间，可以提高一点性能
        employee.setUpdateTime(employee.getCreateTime());
        employee.setIsDel(0);
        int result =  employeeMapper.insert(employee);
        int empId = employee.getEmpId();  //获取插入自增的id
        //将empId和roleId一同插入到  员工与角色关系表
        EmpRole empRole = new EmpRole(empId,roleId);
        empRole.setCreateTime(StringUtils.getNowTime());
        empRole.setUpdateTime(empRole.getCreateTime());  //获取创建时间，可以提高一点性能
        empRole.setIsDel(0);
        empRoleMapper.insert(empRole);
        return result;
    }

    @Override
    public Integer update(Employee employee, Integer roleId) {
        if(!"".equals(employee.getPwd())){
            //从ShiroUtils类中随机生成盐
            employee.setSalt(ShiroUtils.randomSalt());
            //将密码设置为 加密后的密码（由ShiroUtils里面encryptPassword方法实现）
            employee.setPwd(ShiroUtils.encryptPassword(employee.getPwd(),employee.getCredentialsSalt()));
        }else {
            employee.setPwd(null);
        }
        //设置时间
        employee.setUpdateTime(StringUtils.getNowTime());
        //将信息更新到数据库中（空的属性不修改）
        int result =  employeeMapper.updateById(employee);
        if (roleId!=null){
            EmpRole empRole=new EmpRole();
            empRole.setRoleId(roleId);
            empRole.setUpdateTime(employee.getUpdateTime());
            QueryWrapper<EmpRole> queryWrapper=new QueryWrapper<>();
            if (empRoleMapper.selectOne(queryWrapper.eq("emp_id",employee.getEmpId()))==null){
                empRole.setCreateTime(employee.getUpdateTime());
                empRole.setEmpId(employee.getEmpId());
                empRole.setIsDel(0);
                empRoleMapper.insert(empRole);
            }else{
                QueryWrapper<EmpRole> queryWrapper1=new QueryWrapper<>();
                empRoleMapper.update(empRole,queryWrapper1.eq("emp_id",employee.getEmpId()));
            }
        }
        return result;
    }

    @Override
    public Integer del(Integer empId) {
        Employee employee=new Employee();
        employee.setEmpId(empId);
        employee.setIsDel(1);
        empRoleMapper.del(empId);
        int result = employeeMapper.updateById(employee);
        return result;
    }

    @Override
    public Integer recover(Integer empId) {
        Employee employee=new Employee();
        employee.setEmpId(empId);
        employee.setIsDel(0);
        empRoleMapper.del(empId);
        int result = employeeMapper.updateById(employee);
        return result;
    }
}
