# springCloudFamily-FESCAR
springCloud微服务全家桶和分布式事务
# springCloudFamily-FESCAR
-   写这个的初衷：目前没有全套的微服务的项目实战，网上博客也没用那么详细，所以写出一个直接就可以使用的架子，为大家提供方便快捷
- 准备工作
1、阅读官方文档Quick Start，并成功启动fescar-server
2、初始化数据库，工程中的springcloud.sql

---
- springCloud微服务全家桶和分布式事务
- zuul-gateway 网关服务（用户登录不需要安全验证，调用别的接口需要安全认证）
- provider-user 用户服务（Fegin）其中会调用积分服务进行查询积分
- provider-internal 积分服务
- provider-equity	权益服务目前没有用到
- fescar-config 分布式事务配置
- eureka-server 注册中心集群
- config-server 基于git分布式配置中心（用到消息总线）
- config-client 配置客户端（用到消息总线）
---
- 上面这些服务实现了通过网关调用各服务
- 登录接口
```
参数：userName (String) 
    password  (String)
localhost:9527/provider-user/login
请求方式post
成功返回信息：
{
    "code": 200,
    "message": "登录成功"
}
失败返回信息：
{
    "code": 20001,
    "message": "您输入的用户名或者密码错误"
}

```

- 查询接口根据用户Id查询积分
```
参数：userId (int)
      token (String)
localhost:9527/provider-user/getInternalByUserId
请求方式：get
成功返回信息：
{
    "code": 200,
    "data": {
        "inId": 1, （j积分Id）
        "userId": 1, (用户Id)
        "balance": 1000 (积分余额)
    },
    "message": "访问成功"
}
断路器返回信息
{
    "code": 5001,
    "message": "熔断器启动进行服务降级"
}
```
----------------------------
分布事务模拟场景
- account-service：用户账户服务，仅提供用户账户的扣减接口，
- business-service：上层业务服务，提供下单接口，
- order-service：订单服务，仅提供订单创建接口，
- storage-service：库存服务，仅提供库存扣减接口
- ps.真实分布式场景会是四个不同的数据源，这里在四个工程下使用同一数据源，也能模拟四个不同数据源的效果，另外，需要注意端口占用问题。
（如果出现jar包报红，记得先将spring-cloud-fescar-config工程打包进本地仓库）
- 分别启动这个四个服务使用接口工具调用
- 默认环境下：

url: http://localhost:11112/business

method: PUT

header: contentType = application/json

requestBody:

{ "userId":"U100001", "commodityCode":"C00321", "orderCount":2 }

程序设计效果
在每个服务调用时均有1/10的概率会调用失败
当库存不足或用户余额不足时会报业务异常
期望效果
程序正常执行，请求成功，响应码200，查看数据库，各个表的数据一致
程序执行失败，请求失败，响应码500，查看数据库，各个表的数据一致
