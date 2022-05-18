package com.tensquare.entity;

/**
 * @Description: 返回结果
 * @Author: cmj
 * @Date: 2022-03-02 16:28
 * @Version: V1.0
 */
public class Result {
    //是否成功
    private boolean flag;
    // 返回码
    private Integer code;
    //返回信息
    private String message;
    // 返回数据
    private Object data;

    public Result() {
    }

    public Result(boolean flag, Integer code, String message, Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
