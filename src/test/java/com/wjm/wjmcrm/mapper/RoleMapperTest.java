package com.wjm.wjmcrm.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wjm.wjmcrm.entity.Employee;
import com.wjm.wjmcrm.entity.Role;
import com.wjm.wjmcrm.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询全部角色信息
     */
   /* @Test
    public void selectList(){
        List<Role> list=roleMapper.selectList(null);
        for(Object o : list){
            System.out.println(o);
        }
    }*/
    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        Page<Role> page = new Page<>(1, 5);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        IPage<Role> iPage = roleMapper.selectPage(page,queryWrapper);
        System.out.println(iPage);
    }

    /**
     * 添加角色信息
     */
    @Test
    public void insert(){
        Role role=new Role();
        role.setRoleId(null);
        role.setRoleName("员工");
        role.setCreateTime("2020-3-23");
        role.setUpdateTime("2020-3-23");
        role.setIsDel(1);
        int insert=roleMapper.insert(role);
        System.out.println(insert);
    }

    /**
     * 根据id修改角色信息
     */
    @Test
    public void updateById(){
        Role role=new Role();
        role.setRoleId(2);
        role.setRoleName("管理员");
        role.setCreateTime("2020-3-23");
        role.setUpdateTime("2020-3-23");
        role.setIsDel(1);
        int updateById=roleMapper.updateById(role);
        System.out.println(updateById);
    }

    /**
     * 根据id删除角色信息
     */
    @Test
    public void deleteById(){
        roleMapper.deleteById(2);
    }
}