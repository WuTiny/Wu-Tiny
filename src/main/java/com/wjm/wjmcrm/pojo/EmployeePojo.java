package com.wjm.wjmcrm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePojo {
    private String deptName;
    private Integer empId;
    private String roleName;
    private String empName;
    private String permName;
    private String permission;
    private String age;
    private String sex;
    private String phone;
    private String address;
    private String createTime;
    private String updateTime;
}