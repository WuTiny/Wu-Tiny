package com.wjm.wjmcrm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("business")
public class Business extends BaseEntity {
    @TableId(type = IdType.AUTO)
    private Integer businessId;
    private String businessName;
    private String head;
    private String telphone;
    private String description;
}
