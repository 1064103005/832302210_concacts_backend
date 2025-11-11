# 832302210-Concacts-Frontend  

&gt; 第一次作业：前后端分离通讯录 · 前端仓库  
&gt; 学号：832302210 | 姓名：陈祺嵘

---

## 1. 项目简介  
纯原生 HTML/JS 实现的前端通讯录，通过 Fetch 与后端 Spring-Boot API 无缓存交互，完成全部基础 CRUD 与搜索功能。  

---

## 2. 技术栈  
- HTML5 + CSS3（Flex & Grid）  
- ES6+ JavaScript（无框架）  
- 异步数据：Fetch API  
- 运行环境：任意静态 Web 服务器  

---

## 3. 快速开始  
```bash
# 1. 克隆
git clone https://github.com/f2x1/832302210_concacts_frontend.git
cd 832302210_concacts_frontend

# 2. 启动静态服务器（任选）
python -m http.server 8000   # Python
npx http-server src -p 8000 # Node
浏览器访问 http://localhost:8000/contacts.html 即可

## 4. 目录结构
832302210_concacts_frontend/
├─ src/
│  ├─ contacts.html   # 主页面
│  ├─ css/style.css   # 样式
│  └─ js/app.js       # 业务逻辑
├─ README.md
└─ codestyle.md       # 代码规范




