通讯录后端项目 - 832302210
Git 仓库链接
前端仓库链接： https://github.com/1064103005/832302210_concacts_frontend
后端仓库链接： https://github.com/1064103005/832302210_concacts_backend

项目简介
本项目是《第一次作业——前后端分离通讯录编程》的后端实现部分。基于 Spring Boot + MySQL 技术栈，提供完整的 RESTful API 接口，支持通讯录系统的所有数据操作。

本项目严格遵守 前后端分离 架构，所有接口返回标准 JSON 格式数据，支持跨域请求，确保前端能够安全、高效地调用后端服务。

功能实现
本项目实现了作业要求中的所有基本功能：

功能点	状态	描述
功能 1: 添加 (C)	✅ 完成	通过 POST 接口接收联系人数据并持久化到 MySQL 数据库
功能 2: 修改 (U)	✅ 完成	通过 PUT 接口更新联系人信息，确保从数据库读取最新数据
功能 3: 删除 (D)	✅ 完成	通过 DELETE 接口从数据库删除指定联系人
读取 (R)	✅ 完成	提供多个GET接口用于查询联系人数据
数据验证	✅ 完成	完整的业务逻辑验证和数据完整性检查
技术栈
框架： Spring Boot 2.7.0

数据持久化： Spring Data JPA + Hibernate

数据库： MySQL 8.0

构建工具： Maven

API文档： 自描述RESTful接口

API 接口文档
后端提供完整的 RESTful API，基础路径为 /api。

功能	HTTP 方法	URL 路径	请求体	响应
获取列表	GET	/api/contacts	-	200 + 联系人列表
添加联系人	POST	/api/contacts	联系人JSON	201 + 新联系人
获取详情	GET	/api/contacts/{id}	-	200 + 联系人详情
修改联系人	PUT	/api/contacts/{id}	联系人JSON	200 + 更新后联系人
删除联系人	DELETE	/api/contacts/{id}	-	200 + 成功消息
搜索联系人	GET	/api/contacts/search	?keyword=搜索词	200 + 搜索结果
健康检查	GET	/api/contacts/health	-	200 + 状态信息
项目结构
text
832302210_concacts_backend/
├── src/main/java/com/example/contacts/
│   ├── ContactsApplication.java     # Spring Boot 主应用类
│   ├── config/
│   │   ├── CorsConfig.java          # 跨域配置
│   │   └── DataInitializer.java     # 数据初始化
│   ├── controller/
│   │   └── ContactController.java   # REST 控制器
│   ├── entity/
│   │   └── Contact.java             # JPA 实体类
│   ├── repository/
│   │   └── ContactRepository.java   # 数据访问层
│   └── service/
│       └── ContactService.java      # 业务逻辑层
├── src/main/resources/
│   ├── application.properties       # 应用配置文件
│   └── schema.sql                   # 数据库初始化脚本
├── pom.xml
├── README.md
└── codestyle.md
数据库设计
sql
CREATE TABLE contacts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(100),
    address VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
核心特性
✅ 完整的CRUD操作 - 支持联系人的增删改查所有操作

✅ 数据验证 - 电话号码唯一性验证，数据完整性检查

✅ 异常处理 - 统一的错误处理机制和友好的错误信息

✅ 跨域支持 - 完整的CORS配置，支持前端跨域访问

✅ 实时数据 - 所有修改操作都直接操作数据库，不使用缓存

本地运行步骤
环境要求
Java 8+

MySQL 8.0+

Maven 3.6+

数据库配置
创建数据库：

sql
CREATE DATABASE contacts_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
配置数据库连接：
修改 src/main/resources/application.properties：

properties
spring.datasource.url=jdbc:mysql://localhost:3306/contacts_db
spring.datasource.username=root
spring.datasource.password=your_password
运行后端服务
克隆仓库：

bash
git clone https://github.com/f2x1/832302210_concacts_backend.git
cd 832302210_concacts_backend
使用Maven运行：

bash
# 方式一：使用Maven Wrapper
./mvnw spring-boot:run

# 方式二：打包后运行
mvn clean package
java -jar target/contacts-backend-1.0.0.jar
验证服务：
访问 http://localhost:8080/api/contacts/health 查看服务状态

接口测试示例
添加联系人
bash
curl -X POST http://localhost:8080/api/contacts \
  -H "Content-Type: application/json" \
  -d '{
    "name": "张三",
    "phone": "13800138000",
    "email": "zhangsan@example.com",
    "address": "北京市朝阳区"
  }'
搜索联系人
bash
curl "http://localhost:8080/api/contacts/search?keyword=张"
注意事项
确保MySQL服务已启动并正常运行

首次运行会自动创建数据库表结构

服务默认运行在 http://localhost:8080

