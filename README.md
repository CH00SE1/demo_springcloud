# demo_springcloud


####自动识别nacos网关服务
```yaml
spring:
  application:
    name: api-gateway
  cloud:
    nacos:
      discovery:
        username: nacos
        password: nacos
        namespace: public
        server-addr: 127.0.0.1:8848
    # gateway的配置
    gateway:
      discovery:
        locator:
          # 是否自动识别nacos网关服务
          enabled: true
```