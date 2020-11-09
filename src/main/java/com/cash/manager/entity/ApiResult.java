package com.cash.manager.entity;

import com.google.common.base.MoreObjects;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author MiaoShaoDong
 * @date 11:51 2020/10/29
 */
@Data
public class ApiResult<T> {
    private Integer code = 0;
    private String msg;
    private Integer count = 100;
    private ArrayList data = new ArrayList();

    public static <T> ApiResult<T> okWithData(T data) {
        ApiResult<T> result = new ApiResult<>();
        result.setData((ArrayList) data);
        result.setCount(((ArrayList) data).size());
        return result;
    }

    public static <T> ApiResult<T> ok(T data) {
        return okWithData(data);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("code", code)
                .add("msg", msg)
                .add("count", count)
                .add("data", data)
                .toString();
    }
}
