package com.tensquare.entity;

/**
 * @Description: 状态码实体类
 * @Author: cmj
 * @Date: 2022-03-02 16:38
 * @Version: V1.0
 */
public class StatusCode {

    //成功
    public static final int OK = 20000;
    //失败
    public static final int ERROR = 20001;
    //用户名或密码错误
    public static final int LOGINERROR = 20002;
    //权限不足
    public static final int ACCESSERROR = 20002;
    //远程调用失败
    public static final int REMOTEERROR = 20004;
    //重复操作
    public static final int REPERROR =20005;

}
