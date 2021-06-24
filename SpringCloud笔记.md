微服务学习

# 微服务

## 什么是微服务
Microservice Architecture 是一种架构思想
Martin Fowler 2014年的一段话:
- 业界没有统一的标准的定义
- 但通常而言,微服务架构是一种架构模式,或者说是一种架构风格,他提倡将单一的应用程序划分成一组小的服务,每个服务运行在其独立的自己的进程内,服务之间互相协调,互相配置,为用户提供最终价值。   服务之间采用轻量级的通信机制互相沟通，每个服务都围绕具体的业务进行构建，并且能够被独立的部署到生产环境中，另外，应尽量避免统一的、集中式的服务管理体质，对具体的一个服务而言，应根据业务上下文，选择合适的语言、工具对其进行构建，可以有一个非常轻量级的集中式管理来协调这些服务，可以使用不同的语言来编写服务，也可以使用不同的数据存储

从技术维度理解： 微服务的核心就是将一站式应用，根据业务拆分成一个一个的服务，彻底地去耦合，每一个微服务提供单个业务功能的服务，一个服务做一件事情，从技术角度看就是一种小而独立的处理过程，类似进程的概念，能够自行单独启动或销毁，拥有自己独立的数据库。

## 微服务与微服务架构

**微服务** 

- 强调的是服务的大小，它关注的是某个点，是具体解决的某一个问题的一个服务应用
- 狭义的可以将微服务看作idea中一个个的微服务工程，或者一个个Module

```
Idea工具中使用Maven建立的一个个独立的module，它使用SpringBoot开发的一个小模块，一个模块只做一件事；
强调一个个的个体，每个个体完成具体的任务或者功能。
```

**微服务架构**

一种新的架构形式,Martin Forler 2014年提出。

## 微服务优缺点

**优点**

- 每个服务足够内聚，足够小，职责单一
- 开发简单，开发效率高，一个服务可能就是专一的只干一件事情
- 容易被2~5个人的小团队单独开发
- 微服务之间松耦合，是有功能意义的服务，无论是在开发阶段或部署阶段都是独立的
- 微服务使用不同的语言开发
- 易于和第三方集成，灵活的自动部署，通过持续集成工具，如Jenkins、Hudson、bamboo
- 易于被开发人员理解、修改和维护，小团队能够更关注自己的工作成果，无需通过合作才能体现价值
- 微服务允许使用和融合最新的技术
- **微服务只是业务逻辑代码，不会和html，css或其他界面混合**
- **每个微服务都有自己的存储能力，可以有自己的数据库**



**缺点**

- 开发人员要处理分布式系统的复杂性
- 运维难度随着服务的增加而增加
- 系统部署依赖
- 服务间通信成本
- 数据一致性
- 系统集成测试
- 性能监控



## 微服务技术栈



| 技术条目                               | 落地技术实现                                                 |
| -------------------------------------- | ------------------------------------------------------------ |
| 服务开发                               | SpringBoot、Spring、SpringMvc                                |
| 服务配置与管理                         | Netflix的Archaius、阿里的Diamond                             |
| 服务注册与发现                         | Eureka、Consul、Zookeeper                                    |
| 服务调用                               | Rest、RPC、gRPC                                              |
| 服务熔断                               |                                                              |
| 负载均衡                               |                                                              |
| 服务接口调用(客户端调用服务的简化工具) | Feign                                                        |
| 消息队列                               | Kafka/RabbitMQ/ActiveMQ                                      |
| 服务配置中心管理                       | SpringCloudConfig/Chef                                       |
| 服务路由(api网关)                      | Zuul                                                         |
| 服务监控                               | Zabbix、Nagios、Metrics、Specatator                          |
| 全链路追踪                             | Zipkin、Brave、Dapper                                        |
| 服务部署                               | Docker、OpenStack、Kubernetes                                |
| 数据流操作开发包                       | SpringCloud Stream（封装与Redis、Rabbit、Kafka等发送接收消息） |
| 事件消息总线                           | SpringCloud Bus                                              |



当前大公司的微服务架构

- 阿里： dubbo + HFS
- 京东：jsf + jmq
- 新浪: Motan
- 当当: DubboX

| 功能点/<br />服务框架 | Netflix/SpringCloud                                          | Motan                                                  | gRpc    | Thrift   | Dubbo      |
| --------------------- | ------------------------------------------------------------ | ------------------------------------------------------ | ------- | -------- | ---------- |
| 定位                  | 完整的微服务框架                                             | Rpc框架,整合ZK或consul实现集群环境基本的服务注册和发现 | Rpc框架 | Rpc框架  | 服务框架   |
| 支持rest              | 是,Ribbon支持多种可插拔的序列化选择                          | 否                                                     | 否      | 否       | 否         |
| 支持Rpc               | 否                                                           | 是(Hession2)                                           | 是      | 是       | 是         |
| 负载均衡              | 是(服务端Zuul+客户端Ribbon),zuul服务,动态路由,云端负载均衡Eureka(针对中间层服务器) | 是(客户端)                                             | 否      | 否       | 是(客户端) |
| 服务配置              | NetflixArchaius,SpringCloudConfigServer集中配置              | 是(zookeeper)                                          | 否      | 否       | 否         |
| 服务调用链监控        | 是(zuul 提供边缘服务,api网关)                                | 否                                                     | 否      | 否       | 否         |
| 高可用/容错           | 是(服务端Hystrix+客户端Ribbon)                               | 是(客户端)                                             | 否      | 否       | 是(客户端) |
| 典型应用              | Netflix                                                      | Sina                                                   | Google  | Facebook |            |



# SpringCloud

Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state). Coordination of distributed systems leads to boiler plate patterns, and using Spring Cloud developers can quickly stand up services and applications that implement those patterns. They will work well in any distributed environment, including the developer’s own laptop, bare metal data centres, and managed platforms such as Cloud Foundry.

提供开箱即用的功能

- Distributed/versioned configuration	分布式或版本化的配置
- Service registration and discovery 服务注册和发现
- Routing 路由
- Service-to-service calls 服务调用
- Load balancing 负载均衡
- Circuit Breakers 断路器
- Global locks 全局锁
- Leadership election and cluster state 领导人选举和集群状态
- Distributed messaging 分布式消息通信

简单易懂,易部署和易维护的分布式系统开发工具包

## SpringCloud和SpringBoot的关系

- SpringBoot专注于开发单个微服务个体(比如一个个的jar包)
- SpringCloud关注全局的微服务协调治理框架,它将SpringBoot开发的个体微服务整合并管理起来,为各个微服务之间提供各种集成服务,比如:配置管理,服务发现,断路器,路由,微代理,事件总线,全局锁,决策竞选,分布式会话等等集成服务.
- SpringBoot可以离开SpringCloud独立使用,但SpringCloud离不开SpringBoot,即SpringCloud依赖SpringBoot
- SpringBoot专注快速/方便的开发个体微服务,SpringCloud关注全局的服务治理框架

## Dubbo和SpringCloud技术选型

1.  分布式+服务治理 Dubbo

-  人 ->网站 =>

  人->CDN->负载均衡->Nginx->tomcat服务器集群() 

- 服务器需要与文件系统交互,单机就是我们的电脑=>

人->CDN->负载均衡->Nginx->tomcat服务器集群 <=> 分布式文件系统

- tomcat需要非常多的服务(tomcat是服务消费者),需要向服务注册中心申请并获取服务 =>

  人->CDN->负载均衡->Nginx->tomcat服务器集群(<=> 分布式文件系统)  ->  注册中心

- 服务的提供者 向中心注册

  人->CDN->负载均衡->Nginx->tomcat服务器集群(<=> 分布式文件系统)  ->  注册中心 -> 服务提供者(dubbo-admin)

- 后台数据库,

  - 数据库不够用需要拆分, 水平拆分(读数据库),垂直拆分(写数据库),这就是读写分离 (水平和垂直之间可以通过mycat管理数据同步)

- 高频的读取比如微博热搜,需要添加缓存

  服务提供者 -> 缓存 -> 数据库

  缓存是redis或者redis集群

- 海量数据操作,需要使用mq消息中间件异步队列

  服务提供者->mq -> 缓存redis

  

2. Dubbo和SpringCloud 

社区活跃度:

https://github.com/spring-cloud

https://github.com/dubbo

结果:

| 对比项       | Dubbo         | Spring                      |
| ------------ | ------------- | --------------------------- |
| 服务注册中心 | Zookeeper     | SpringCloud Netflix Eureka  |
| 服务调用方式 | RPC           | REST API                    |
| 服务监控     | Dubbo-monitor | Spring Boot Admin           |
| 断路器       | 不完善        | SpringCloud Netflix Hystrix |
| 服务网关     | 无            | SpringCloud Netflix Zuul    |
| 分布式配置   | 无            | SpringCloud Config          |
| 服务跟踪     | 无            | SpringCloud Sleuth          |
| 消息总线     | 无            | SpringCloud Bus             |
| 数据流       | 无            | SpringCloud Stream          |
| 批量任务     | 无            | SpringCloud Task            |

最大的区别:

SpringCloud基于Http的Rest方式通信,而没有采用Dubbo使用的rpc通信方式

两种方式各有优劣,Rest方式牺牲了服务的调用性能,但也避免了原生rpc的一些问题,而且rest相比rpc更灵活,服务提供方和调用方的依赖只需要一纸契约,不存在代码级别的强依赖,这在强调快速演化的微服务环境下显得更合适.



两者解决的问题域不一样: Dubbo定位是一款rpc通信框架,SpringCloud的目标是微服务架构下的一站式解决方案.

## SpringCloud能干啥

[Spring Cloud](https://spring.io/projects/spring-cloud)

Spring Cloud focuses on providing good out of box experience for typical use cases and extensibility mechanism to cover others.

Spring Cloud侧重于为典型用例提供良好的开箱即用体验，并提供覆盖其他用例的可扩展性机制。

- Distributed/versioned configuration 分布式/版本控制配置
- Service registration and discovery 服务注册和发现
- Routing 路由
- Service-to-service calls 服务到服务的调用
- Load balancing 负载均衡
- Circuit Breakers 断路器
- Global locks 全局锁
- Leadership election and cluster state 领导人选举和群集状态
- Distributed messaging 分布式消息

## 微服务项目总体介绍

- 创建一个consumer消费者模块和provider服务提供者模块,consumer(Client)通过rest调用provider提供者(Server)提供的服务

- 父工程下有3个子模块

  - api模块 封装entity、接口和公共配置

  - provider-8001模块 服务提供者

  - consumer-80模块 服务消费者

  - SpringBoot与SpringCloud版本要兼容

    如果目前有一个Spring Boot应用程序，要将Spring Cloud添加到该应用程序中，第一步是确定您应该使用的Spring Cloud版本。你在应用程序中使用的版本将取决于你正在使用的Spring Boot版本。具体查看地址[Spring Cloud](https://spring.io/projects/spring-cloud)

    | Release Train                                                | Boot Version                          |
    | :----------------------------------------------------------- | :------------------------------------ |
    | [2020.0.x](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-2020.0-Release-Notes) aka Ilford | 2.4.x, 2.5.x (Starting with 2020.0.3) |
    | [Hoxton](https://github.com/spring-cloud/spring-cloud-release/wiki/Spring-Cloud-Hoxton-Release-Notes) | 2.2.x, 2.3.x (Starting with SR5)      |
    | [Greenwich](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Greenwich-Release-Notes) | 2.1.x                                 |
    | [Finchley](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Finchley-Release-Notes) | 2.0.x                                 |
    | [Edgware](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Edgware-Release-Notes) | 1.5.x                                 |
    | [Dalston](https://github.com/spring-projects/spring-cloud/wiki/Spring-Cloud-Dalston-Release-Notes) | 1.5.x                                 |

## 创建项目和各个模块

![image-20210624081837517](SpringCloud%E7%AC%94%E8%AE%B0.assets/image-20210624081837517.png)

父pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>dmy-springcloud-study</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>springcloud-api</module>
        <module>springcloud-provider-8001</module>
        <module>springcloud-consumer-80</module>
    </modules>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <spring.cloud-version>Hoxton.SR4</spring.cloud-version>
        <spring.boot-version>2.3.4.RELEASE</spring.boot-version>
        <mysql-version>8.0.22</mysql-version>
        <mybatis-version>2.1.4</mybatis-version>
        <log4j-version>1.2.17</log4j-version>
        <junit-version>4.13.1</junit-version>
        <lombok-version>1.18.12</lombok-version>
        <logback.core-version>1.2.3</logback.core-version>
    </properties>
    <dependencyManagement>
        <dependencies>
            <!--SpringCloud依赖-->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring.cloud-version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <!--springboot依赖-->
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring.boot-version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <!--mybatis的springboot启动器-->
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis-version}</version>
            </dependency>
            <!--数据库-->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql-version}</version>
            </dependency>
            <!--日志-->
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j-version}</version>
            </dependency>
            <!--日志测试-->
            <dependency>
                <groupId>ch.qos.logback</groupId>
                <artifactId>logback-core</artifactId>
                <version>${logback.core-version}</version>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit-version}</version>
                <scope>test</scope>
            </dependency>

            <!--lombok-->
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <version>${lombok-version}</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
    <build>
        <!--打包插件-->
    </build>
</project>
```

### springcloud-api

### springcloud-provider-8001

### springcloud-consumer-80
