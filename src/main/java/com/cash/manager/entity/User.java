package com.cash.manager.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 用户信息
 * @author 86151
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer sex;
    private Timestamp createTime;
}
