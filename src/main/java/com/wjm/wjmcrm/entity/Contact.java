package com.wjm.wjmcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("contact")
public class Contact extends BaseEntity{
    @TableId(type = IdType.AUTO)
    private Integer contactId;
    private String way;
    private String content;
    private Integer customerId;
    private Integer empId;
    @TableField(exist = false)
    private Customer customer;


}
