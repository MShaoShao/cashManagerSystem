package com.cash.manager.utill;

/**
 * json转换工具
 */
public class Tool {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 是否成功/状态
     */
    private Boolean isSuccess;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据对象
     */
    private Object result;

    /**
     * 构造函数
     */
    public Tool() {
        super();
    }

    /**
     * 返回标准的Json格式数据其中包括（是否成功、状态码、消息、内容）
     *
     * @param success 成功标志
     * @param code    状态码
     * @param message 消息内容
     */
    public Tool(Boolean success, Integer code, String message, Object result) {
        super();
        this.isSuccess = success;
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

}
