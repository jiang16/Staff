# 企业员工管理系统
---
## 前端
- 采用了一款名为INSPINIA的模板，集成Bootsrap，JQuery，CSS，LESS，SCSS和各种JS插件，方便易用
- 前端AJAX请求比较多，为的是增加界面友好度，提交请求后实现页面的不刷新
- 摒弃了传统的JSP模板，采用Spring boot官方推荐的Thymeleaf模板，功能更强大，且页面为html，不会存在各种JSP标签，影响可读性
- 表格插件实现报表的打印和下载，支持Excel和PDF两种格式

## 后端
- 采用企业级Java Web框架Spring boot，数据访问层采用MyBatis，两者完美结合，实现了经典的三层架构
- MyBatis底层自动防止SQL注入攻击
- Sping boot拦截器拦截请求，防止跨登录访问
- 自封装日志记录接口，每种涉及数据库信息更改的操作都将被记录
- 数据备份可实现备份数据库功能，防止数据库宕机后，系统无法使用
