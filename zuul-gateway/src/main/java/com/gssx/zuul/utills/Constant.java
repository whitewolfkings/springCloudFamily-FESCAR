package com.gssx.zuul.utills;
/**
 *
 * 功能描述: 通用的code码和变量封装
 *
 * @param:
 * @return:
 * @auther: mamengkai
 * @date: 2018-12-01 10:48
 */
public class Constant {
   //接口访问成功
    public static final int SUCCESS_CODE =200;
    //接口访问成功的消息
    public  static final   String SUCCESS_MESSAGE ="访问成功";
    //成员账户名不能重复
    public static final int  USER_NAME_EXIT_CODE=20002;
    //成员账户名不能重复的消息
    public static final String USER_NAME_EXIT_MESSAGE="成员账户名不能重复";
    //成员名不能重复
    public static final int USER_REAL_NAME_EXIT_CODE =20003;
    //成员名不能重复的消息
    public static final String USER_REAL_NAME_EXIT_MESSAGE="成员名不能重复";
    //账户余额不足
    public static final int BALANCE_ERROR_CODE=20004;
    //账户不足的消息
    public static final String BALANCE_ERROR_MESSAGE="你的账户余额不足";
    //token不存在
    public static final int TOKEN_IS_NULL_CODE = 20005;
    //token不存在的消息
    public static final String TOKEN_IS_NULL_MESSAGE = "安全认证不通过,重新登录";
    //token认证失败
     public static final int TOKEN__IS_ERROR_CODE =20006;
     //token认证失败的消息
     public static final String TOKEN_IS_ERROR_MESSAGE="安全认证失败，请重新登录";
    //权益认证失败
    public static final int AUTH_ERROR_CODE=30001;
    //权限认证失败的消息
     public static final String AUTH_ERROR_MESSAGE="权限不足";
     //访问接口失败
     public static  final int ERROR_CODE=404;
     //访问接口失败的消息
    public static final String ERROR_MESSAGE="请检查访问的地址是否正确";
    //访问超时
    public static final int TIME_OUT_CODE=40001;
    //访问超时的消息
    public static final String TIME_OUT_MESSAGE="访问超时，请重试";
    //系统错误
    public static final int  SYSTEM_ERROR_CODE=500;
    //系统错误的消息
    public static final String SYSTEM_ERROR_MESSAGE="系统错误，请联系管理员重试";
    //数据插入失败的
    public static final int INSERT_ERROR_CODE=50001;
    //数据插入失败返回的消息
    public static final String INSERT_ERROR_MESSAGE="数据插入失败";
    //数据查询失败
    public static final int QUERY_ERROR_CODE=50002;
    //数据查询失败返回的消息
    public static final String QUERY_ERROR_MESSAGE="数据查询失败";
    //数据更新失败
    public static final int UPDATE_ERROR_CODE=50003;
    //数据更新失败返回的消息
    public static final String UPDATE_ERROR_MESSAGE="数据更新失败";
    //数据删除失败
    public static final int DEL_ERROR_CODE=50004;
    //数据删除失败返回的消息
    public static final String DEL_ERROR_MESSAGE="数据删除失败";
    //用户登录失败1
    public static final int LOGIN_USERNAME_ERROR_CODE = 50005;
    //用户名不存在
    public static final String LOGIN_USERNAME_ERROR_MESSAGE = "用户名不存在";
    //用户登录失败2
    public static final int LOGIN_PASSWORD_ERROR_CODE = 50006;
    //密码错误
    public static final String LOGIN_PASSWORD_ERROR_MESSAGE = "用户密码错误";

}
