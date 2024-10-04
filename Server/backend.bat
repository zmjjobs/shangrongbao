D:
::cd D:\IdeaSpace\MySelf\shangrongbao\Server
::copy /y  nginx-srb.conf D:\MyServer\Nginx-1.14\conf\nginx.conf

::因使用了srb-gateway,故而在调用后端模块时不再使用nginx
::cd D:\MyServer\Nginx-1.14
::start nginx.exe

cd D:\MyServer\redis
start redis-server.exe
:: curl http://localhost

cd D:\IdeaSpace\MySelf\shangrongbao\Server\nacos-server-1.4.1\bin
startup.cmd -m standalone