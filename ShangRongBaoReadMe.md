

# 1、目录介绍

```
D:\IdeaSpace\shangrongbao-------尚融宝项目根目录
	--Backend 后端
		 srb
	--Front 前端
		 srb-admin
		 srb-site
	--Server 服务器配置信息、数据库脚本等

```





# 2、系统配置

## 2.1、 srb后端系统

```bash
D:\IdeaSpace\srb\Backend\srb
```

```bash
springboot版本：  2.3.4.RELEASE
```

```bash
依赖层次：
 srb
 	srb-common
 		service-base
 			service-core
 			service-sms
```

```bash
git init
git remote add origin https://github.com/zmjjobs/srb.git
git push -u origin master
```



## 2.2、 srb前端系统

```bash
node -v
# v14.15.0
#经过下面的配置，以后所有的 npm install 都会经过淘宝的镜像地址下载
npm config set registry https://registry.npm.taobao.org 

#查看npm配置信息
npm config list

#vscode打开 D:\VSCodeWorkSpace

cd D:\VSCodeWorkSpace
#安装NPM,运行一次就可以
npm install

google浏览器扩展程序，添加 Vue.jsDevtools.zip
```





# 3、启动系统

## 3.1、 启动后端服务

```shell
#windows启动服务 如果不是管理员，需要右键以管理员身份运行
cd D:\IdeaSpace\MySelf\shangrongbao\Server
#目前运行程序：MySQL8、Nginx、Redis
mysql8需管理员身份.bat
backend.bat
```



## 3.2、 启动后端模块

```bash
com.zmj.srb.sms.ServiceCoreApplication
com.zmj.srb.sms.ServiceSmsApplication
```



## 3.3、 启动前端srb-admin模块

```bash
cd D:\IdeaSpace\MyFactory\ShangRongBaoSystem\Front\srb-admin
# .env.development文件中配置nginx地址
VUE_APP_BASE_API = 'http://localhost'

# mock-server.js修改原来的配置路径
    //url: new RegExp(`${process.env.VUE_APP_BASE_API}${url}`),
    url: new RegExp(`/dev-api${url}`),

#根据package.json里面的"scripts":{"dev": "vue-cli-service serve"...
npm run dev
```



## 3.4、 启动前端srb-site模块

```bash
cd D:\IdeaSpace\MySelf\shangrongbao\Front\srb-site
#根据package.json里面的"scripts":{"dev": "nuxt"...
npm run dev
```

# 4.访问

```http
# service-core的swagger2访问地址:
http://localhost:8110/doc.html
```

```http
# service-sms的swagger2访问地址:
http://localhost:8120/doc.html
```

```http
# srb-site站点
http://localhost:3000/
```

```http
# srb-admin站点
http://localhost:9528/
```

```http
# Nacos登录
http://localhost:8848/nacos
#用户名密码：nacos/nacos
```

```http
#RabbitMQ
http://192.168.0.139:15672/
```

