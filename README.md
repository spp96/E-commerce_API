<!-- <h1 align="center">eShopify API...!!</h1> -->
<h1 align="center"><img align="center" height="45" src="https://user-images.githubusercontent.com/102204260/224464817-55d9a792-44bf-4b73-9406-7f1c4c815071.png"> &nbsp;eShopify API...!! </h1>

A backend system for an online shopping application with APIs for all relevant functionalities including user and admin registration, log in and CRUD functionalities for both admin and customer as per user eligibility. 

## Tech Stack and Tools:

* Java
* Maven
* Spring Framework
* Hibernate
* Spring Boot
* Spring Data JPA
* Lombok
* MySQL
* Postman
* Swagger

<!-- <p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="java" />
  <img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white" alt="mysql" />
</p> -->



## More about the project -
![eShopify API](https://user-images.githubusercontent.com/102204260/224464918-f0be9856-a3cd-4073-ae90-08dca8309e16.png)
<br />

## Controllers -

This project has following controllers:

- Admin AuthController
- Admin Controller
- Customer AuthController
- Customer Controller
- Payment Controller

### 🚀 Admin AuthController Features -
- Admin Login
- Admin Logout

### 🚀 Admin Controller Features -
- Add an admin
- Update admin details
- Get all products 
- add new product
- update product
- Get all customer details

### 🚀 Customer AuthController Features -
- Customer Login
- Customer Logout
- Add a customer
- Update customer details 

### 🚀 Customer Controller Feature -
- Add a product to cart

### 🚀 Payment Controller Feature -
- Check payment status


## Installation & Run -

* Before running the API server, you should update the database config inside the [application.properties](https://github.com/spp96/E-commerce_API/blob/main/E-Commerce_RestAPI/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8888
    spring.datasource.url=jdbc:mysql://localhost:3306/e_commercedb
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint -
```
https://localhost:8888/
```
```
http://localhost:8888/swagger-ui/index.html
```
