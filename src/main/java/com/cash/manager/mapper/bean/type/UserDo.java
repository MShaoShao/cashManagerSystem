package com.cash.manager.mapper.bean.type;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 用户数据库映射对象
 *
 * @author MiaoShaoDong
 * @date 17:40 2020/12/5
 */
@Data
public class UserDo {
    private Integer id;
    private String userName;
    private String password;
    private Integer sex;
    private Timestamp createTime;
}
