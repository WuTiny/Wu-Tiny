package com.wjm.wjmcrm.mapper;

import com.wjm.wjmcrm.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询全部部门信息
     */
    /*@Test
    public void selectList(){
        List<Customer> list=customerMapper.selectList(null);
        for(Object o : list){
            System.out.println(o);
        }
    }*/
}