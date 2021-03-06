Тестовое приложение на стеке:
- **Spring Cloud Consul**
- **Spring Cloud Gateway**
- **Spring Cloud Config**
- **Feign**

Также использовалась база данных **PostgreSQL**

В инфраструктуре было поднято два сервиса:
- **database-service** - получает данные по объектам России по коду КЛАДР из локальной базы данных, которая содержит 1117 объектов
- **dadata-service** - использует предоставляемый https://dadata.ru/ API для поиска объектов по коду КЛАДР

Доступ к поиску осуществляется, через шлюз API Spring Cloud Gateway.

**Скрипт cleanup удаляет сеть cloudapp_default, контейнеры и образы приложения, и все dangling образы**

**Скрипт start упаковывает приложение с помощью mvn clean package и вызывает docker-compose для старта приложения**

Сервисы регистрируются в Consul по адресу http://localhost:8500

Поиск доступен по адресу http://localhost:8080/search/city/*

Пример запроса: http://localhost:8080/search/city/0100000200000

Ответ:
`{
    "postal_code":385200,
    "address":"null,
    "country":"Россия",
    "federal_district":"Южный",
    "region_type":"Респ",
    "region":"Адыгея",
    "area_type":null,
    "area":null,
    "city_type":"г",
    "city":"Адыгейск",
    "settlement_type":null,
    "settlement":null,
    "kladr_id":"0100000200000",
    "fias_id":"ccdfd496-8108-4655-aadd-bd228747306d",
    "fias_level":"4",
    "capital_marker":0,
    "okato":"79403000000",
    "oktmo":"79703000001",
    "tax_office":"0107",
    "timezone":null,
    "geo_lat":"44.878414",
    "geo_lon":"39.190289",
    "population":null,
    "foundation_year":null
}`

**config-server** предназначен для доступа и изменения файла конфигурации во время работы приложения.

Файл конфигурация для доступа к dadata API находится здесь: https://github.com/Zergfromhell/CloudConfig/tree/master

Обновить конфигурацию можно перейдя по адресу: http://localhost:8080/search/config/refresh

Если dadata API не доступен данные по объекту поднимаются из локальной базы данных.
