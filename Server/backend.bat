D:
cd D:\IdeaSpace\MySelf\shangrongbao\Server
copy /y  nginx-srb.conf D:\MyServer\Nginx-1.14\conf\nginx.conf

cd D:\MyServer\Nginx-1.14
start nginx.exe

cd D:\MyServer\redis
start redis-server.exe
:: curl http://localhost

cd D:\IdeaSpace\MySelf\shangrongbao\Server\nacos-server-1.4.0\bin
startup.cmd -m standalone