package com.cash.manager.entity;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private String password;
    private String sex;
    private String createTime;
}
