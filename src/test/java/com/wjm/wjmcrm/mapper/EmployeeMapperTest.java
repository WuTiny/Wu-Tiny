package com.wjm.wjmcrm.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void Login() {
        QueryWrapper<Employee> queryWrapper=new QueryWrapper<>();
        Employee login=employeeMapper.selectOne(queryWrapper.eq("emp_name","admin").eq("pwd","123456"));
        System.out.println(login);
    }

    /**
     * 查询全部员工信息
     */
/*    @Test
    public void selectList(){
        List<Employee> list=employeeMapper.selectList(null);
        for(Object o : list){
            System.out.println(o);
        }
    }*/

    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        Page<Employee> page = new Page<>(1, 5);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();

        IPage<Employee> iPage = employeeMapper.selectPage(page, queryWrapper);
        System.out.println(iPage);
    }


    /**
     * 添加员工信息
     */
    @Test
    public void insert(){
        Employee employee=new Employee();
        employee.setEmpId(null);
        employee.setEmpName("tiny");
        employee.setPwd("123456");
        employee.setSalt("123456");
        employee.setAge(20);
        employee.setSex("男");
        employee.setPhone("2222222");
        employee.setAddress("广东省");
        employee.setCreateTime("2020-3-23");
        employee.setUpdateTime("2020-3-23");
        employee.setIsDel(1);
        int insert=employeeMapper.insert(employee);
        System.out.println(insert);
    }

    /**
     * 根据id修改员工信息
     */
    @Test
    public void updateById(){
        Employee employee=new Employee();
        employee.setEmpName("tiny");
        employee.setPwd("11111");
        employee.setSalt("11111");
        employee.setAge(25);
        employee.setSex("男");
        employee.setPhone("111111");
        employee.setAddress("广东省");
        employee.setCreateTime("2020-3-23");
        employee.setUpdateTime("2020-3-23");
        employee.setIsDel(1);
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<>();
        wrapper.eq("emp_id", 3);
        int update=employeeMapper.update(employee,wrapper);
        System.out.println(update);
    }

    /**
     * 根据id删除员工信息
     */
    @Test
    public void deleteById(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("emp_id",3);
        int delete= employeeMapper.delete(queryWrapper);
        System.out.println(delete);
    }

}