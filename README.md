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