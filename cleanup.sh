docker stop $(docker ps -a -q)

docker rm database-service dadata-service config-server postgres gateway consul

docker network rm cloudapp_default

docker rmi database-service dadata-service config-server postgres:alpine gateway consul

docker rmi $(docker images -qf "dangling=true")