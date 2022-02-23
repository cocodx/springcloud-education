# springcloud-education
微服务，分布式，在线教育系统

微服务内部用ribbon，外部用nginx

eureka：服务注册与发现  
openFeign：服务接口调用  
hystrix:断路器，防止雪崩效应：，服务A，调用服务B，服务B调用C，然后全崩了。  
服务降级，服务熔断，接近实时的监控  
Hystrix官宣，停更进维，使用Sentinel替换

哪些情况会触发降级：
程序运行异常
超时自动降级
服务熔断触发服务降级
线程池，信号量打满也会导致服务降级
人工降级

服务熔断：服务降级->进而熔断->恢复调用链路

服务限流Flowlimit

https://www.bilibili.com/video/BV1f341167hQ?p=21  

后台  
1、讲师管理
2、课程分类管理
3、课程管理
4、统计分析

前台  
1、讲师信息列表、详情
2、课程信息列表、详情
3、注册、登录
   第三方注册登录、微信
4、视频播放
5、三方支付 微信  

springboot springcloud mybatis-plus  
mysql，redis，maven，easyexcel，jwt，oauth2  
vue、element-ui，axios，nodejs  
阿里云OSS、VOD、短信、微信扫码登录、扫码支付