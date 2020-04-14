package com.wjm.wjmcrm.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role_permission")
public class RolePerm extends BaseEntity {
    private Integer roleId;
    private Integer permId;
}
