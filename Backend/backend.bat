D:
cd D:\IdeaSpace\MySelf\shangrongbao\Server
copy /y  nginx-srb.conf D:\MyServer\Nginx-1.14\conf\nginx.conf

cd D:\MyServer\Nginx-1.14
start nginx.exe

cd D:\MyServer\redis
start redis-server.exe
:: curl http://localhost