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
@TableName("orders")
public class Orders extends BaseEntity{
    @TableId(type = IdType.AUTO)
    private Integer ordersId;
    private Integer businessId;
    private String totalPrice;
    private Integer customerId;
    @TableField(exist = false)
    private Business business;
    @TableField(exist = false)
    private Customer customer;

}
