
# Delivery API

This repository is about my simple project using Spring Boot. 
So Delivery API is a simple API for order a delivery service.

This project is using Spring, H2, JWT.

now this repos is on https://delivapi.herokuapp.com/

## API Reference
response : 
```
{
    "ok": Boolean,
    "statusCode": String,
    "statusMessage": String,
    "payload": ...
}
```
### Authentication
At first we have to sign in as user before using the provided endpoints

#### Log in

```http
  POST /api/auth/login
```
body eg : 
```
{
    "email":"nansamgr@gmail.com",
    "password":"thisissecret"
}
```
you will get a token and **you have to add that token on header request  with key "Authorization" and value "Bearer your_token" when you try access any other endpoints.**


but if dont have any account yet, you can create new one in signup endpoint
#### Sign up

```http
  POST /api/auth/signup
```
body eg : 
```
{
    "fullName":"I Putu Nanda Amanta",
    "email":"nansamgr@gmail.com",
    "password":"thisissecret",
    "phoneNumber":"089999999999"
}
```


### Data
#### Province
To get all provinces data.
```http
  GET /api/data/provinces
```


To get 1 province data

```http
  GET /api/data/provinces/{id}
```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |


#### City

To get all Cities data.
```http
  GET /api/data/cities
```



#### Check Price

To check delivery cost andcheck courier availbility.
```http
  GET /api/pricing
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `originCityId`      | `string` | **Required**. Id of origin city |
| `destinationCityId`      | `string` | **Required**. Id of destination city |
| `courier`      | `string` | **Required**. courier : pos, tiki, jne |
| `packageWeight`      | `string` | **Required**. your package weight |


### Order

To get all orders logged user.
```http
  GET /api/order
```

To create new order.
```http
  POST /api/order
```

body eg :
```
{
    "packageWeight": 12,
    "courier": "jne",
    "recipientName": "dodo",
    "recipientNumber": "0899990009",
    "destinationCityId": "1",
    "originCityId" : "2"
}
```

| field | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `destinationCityId`      | `string` | **Required**. city_id, you can get it from /api/data/cities|
| `originCityId`      | `string` | **Required**. city_id, you can get it from /api/data/cities|


## Acknowledgements

 - [City, Province and Pricing Data](https://rajaongkir.com/)


