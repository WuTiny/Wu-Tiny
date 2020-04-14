package com.wjm.wjmcrm.mapper;

import com.wjm.wjmcrm.entity.EmpRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpRoleMapperTest {
    @Autowired
    EmpRoleMapper empRoleMapper;
    @Test
    public void selectList(){
        List<EmpRole> list=empRoleMapper.selectList(null);
        for(Object o : list){
            System.out.println(o);
        }
    }

}