package com.cash.manager.mapper.bean;

import lombok.Data;

/**
 * 连接信息类
 *
 * @author MiaoShaoDong
 * @date 14:48 2020/9/18
 */
@Data
public class LinkMsg {
    /**
     * 连接信息Id
     */
    private String linkId;
    /**
     * 连接类型
     */
    private String linkType;
    /**
     * 连接信息名称
     */
    private String linkName;
    /**
     * 连接信息描述
     */
    private String description;
    /**
     * 连接信息参数
     */
    private String linkParameters;
    /**
     * 连接类型版本
     */
    private String version;

}
