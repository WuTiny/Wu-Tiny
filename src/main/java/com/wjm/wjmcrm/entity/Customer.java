package com.wjm.wjmcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("customer")
public class Customer extends BaseEntity{
    @TableId(type = IdType.AUTO)
    private Integer customerId;
    private String customerName;
    private String sex;
    private String telphone;
    private String company;
    private String address;
    private Integer empId;
    private Integer isOrders;
    @TableField(exist = false)
    private Employee employee;

}
