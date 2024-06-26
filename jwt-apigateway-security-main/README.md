# jwt-apigateway-security

## Regist an user

```
curl --location --request POST 'http://localhost:8080/auth/register' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D' \
--data-raw '{
    "name":"Aloke",
    "password":"Pwd1",
    "email":"alokebd@gmail.com"
}'

```

## Generate token

```
curl --location --request POST 'http://localhost:9898/auth/token' \
--data-raw '{
    "username":"Aloke",
    "password":"Pwd1"
}'
```
## Access Doordash-app

```
curl --location --request GET 'http://localhost:8080/doordash/37jbd832' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU4MDIsImV4cCI6MTY3OTA1NzYwMn0.Q0bwS5_16q1Z8K-p_flpmyRoJNFCyOhU2AMKSNYh66o' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D'
```

## Access Restaurant-service

```
curl --location --request GET 'http://localhost:8080/restaurant/orders/status/37jbd832' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU1MDcsImV4cCI6MTY3OTA1NzMwN30.9nNAW1rx8RoTIrhn5Abtzg7RplvT9_d-U5EOwUcJZq8' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D'
```
## DB 
CREATE TABLE `usercredential` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Jwt tokents'

CREATE TABLE `restaurantorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderId` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `qty` int NOT NULL,
  `price` double NOT NULL,
  `orderDate` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `estimateDeliveryWindow` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
