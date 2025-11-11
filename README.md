# 832302210 后端通讯录 README

## 项目定位
第一次作业——前后端分离通讯录编程 **后端仓库**  
学号：832302210  
作者：f2x1  
技术栈：Spring Boot 2.7.0 + Spring Data JPA + MySQL 8.0

## 功能总览
| 功能 | 实现状态 | 接口方法 | 说明 |
|---|---|---|---|
| 新增联系人 | ✅ | POST /api/contacts | 写入 MySQL，返回 201 |
| 修改联系人 | ✅ | PUT /api/contacts/{id} | 先读库再更新，不用缓存 |
| 删除联系人 | ✅ | DELETE /api/contacts/{id} | 物理删除，返回 200 |
| 查询列表 | ✅ | GET /api/contacts | 分页可扩展 |
| 搜索联系人 | ✅ | GET /api/contacts/search | 多字段模糊匹配 |
| 健康检查 | ✅ | GET /api/contacts/health | 服务存活探测 |


## 快速开始
1. 克隆仓库  
   ```bash
   git clone https://github.com/f2x1/832302210_concacts_backend.git
   cd 832302210_concacts_backend
2. 创建数据库
 ```bash
 CREATE DATABASE contacts_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci
3. 配置连接
   修改
   ```bash
       src/main/resources/application.properties
       spring.datasource.url=jdbc:mysql://localhost:3306/contacts_db
       spring.datasource.username=root
       spring.datasource.password=061231
