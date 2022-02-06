# springcloud-education
微服务，分布式，在线教育系统

微服务内部用ribbon，外部用nginx

eureka：服务注册与发现  
openFeign：服务接口调用  
hystrix:断路器，防止雪崩效应：，服务A，调用服务B，服务B调用C，然后全崩了。  
服务降级，服务熔断，接近实时的监控  
Hystrix官宣，停更进维，使用Sentinel替换