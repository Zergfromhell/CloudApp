Тестовое приложение на стеке:
- **Spring Cloud Consul**
- **Spring Cloud Gateway**

Также использовалась база данных **PostgreSQL**

В инфраструктуре было поднято два сервиса:
- **database-service** - получает данные по объектам России по коду КЛАДР из локальной базы данных, которая содержит 1117 объектов
- **dadata-service** - использует предоставляемый https://dadata.ru/ API для поиска объектов по коду КЛАДР или ФИАС

Доступ к ним осуществляется, через шлюз API Spring Cloud Gateway.

Сервисы регистрируются в Consul по адресу http://localhost:8500

Приложение запускается файлом `docker-compose.yml`. 

Database-service доступен по адресу http://localhost:8080/database/search/*

Dadata-service http://localhost:8080/dadata/search/*
