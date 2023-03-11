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

## Understanding from project

- Gain excessive knowledge on application of Java, MySQL and springboot.
- Gain knowledge on creating and using API.
- Understanding of business requirement
- Enjoyed the process of learning and creating the application along with the team.

### 🚀 Overview of Application

## List of Controllers -

- ## **Admin AuthController** 
![Screenshot (202)](https://user-images.githubusercontent.com/102204260/224469956-40a45fdd-d797-4c88-9bda-39cd5c48b403.png)

- ## **Admin Controller**
![Screenshot (203)](https://user-images.githubusercontent.com/102204260/224470040-de96b590-af23-4045-8dd8-014a4eff3867.png)

- ## **Customer AuthController** 
![Screenshot (204)](https://user-images.githubusercontent.com/102204260/224470081-ab11748f-9577-41b4-9d81-570d8992b293.png)

- ## **Customer Controller**
![Screenshot (205)](https://user-images.githubusercontent.com/102204260/224470141-e5811672-3dcf-4d19-902a-b4203cf3f67c.png)

- ## **Payment Controller**
![Screenshot (206)](https://user-images.githubusercontent.com/102204260/224470171-1a2d1e5a-ed1c-4701-9109-c0b94bb070f9.png)

## Step by step flow -
- ## **First Register Admin**

![Screenshot (207)](https://user-images.githubusercontent.com/102204260/224470542-5221ee39-25a2-4ac3-af70-6beeb6bda3ae.png)

![Screenshot (208)](https://user-images.githubusercontent.com/102204260/224470550-3e6a6b08-d809-44db-a675-1e227615e5e4.png)

- ## **Login as Admin and you will get one uuid**

![Screenshot (209)](https://user-images.githubusercontent.com/102204260/224470834-886626de-da41-4955-9dd9-dfefb18884a8.png)

![Screenshot (210)](https://user-images.githubusercontent.com/102204260/224470840-b9301c0f-e053-4678-8218-c7a8639133c0.png)

- ## **Add product by the help of uuid**
- Note :- Only Admin can able to add, update product detalis

![Screenshot (211)](https://user-images.githubusercontent.com/102204260/224471119-e7b41bf8-a52a-4a79-a387-87ddc5414dab.png)

![Screenshot (212)](https://user-images.githubusercontent.com/102204260/224471147-6e7a7102-e9b0-45bd-9d5a-aae2fcf5bf71.png)

- ## **Register Customer**

![Screenshot (213)](https://user-images.githubusercontent.com/102204260/224471415-cac1d196-0012-481b-9d5f-8823eeb601ea.png)

![Screenshot (214)](https://user-images.githubusercontent.com/102204260/224471423-876983ec-5bc1-46a6-a35e-97b4c26e000c.png)

- ## **Login as Customer to purchase product**

![Screenshot (215)](https://user-images.githubusercontent.com/102204260/224471545-bc764d9b-1d63-46a1-b940-d40caa467e62.png)

![Screenshot (216)](https://user-images.githubusercontent.com/102204260/224471554-0b3aab43-d2a9-4ebf-98c4-02754b7b1d0a.png)

- ## **Add product to the cart**
- Note :- as you can see in below image their are 2 uuid one is for admin and another is for customer but here only user can able to add product to cart if admin try     it then application will through exception (see below image for better understanding)

![Screenshot (216)](https://user-images.githubusercontent.com/102204260/224471737-bd534b9e-e2db-41a8-9f32-1eccaf81df44.png)

![Screenshot (217)](https://user-images.githubusercontent.com/102204260/224471919-8ab1d10b-30e2-453f-9d9b-39346b83c771.png)

- Note :- to add product in cart use customer uuid as key

![Screenshot (218)](https://user-images.githubusercontent.com/102204260/224472068-38afbde4-4d02-4a0e-9b69-2b0e98cd4b39.png)

![Screenshot (219)](https://user-images.githubusercontent.com/102204260/224472083-938104ef-974d-47d9-b593-c938d5c4efe4.png)

- ## **Check your payment status**

![Screenshot (220)](https://user-images.githubusercontent.com/102204260/224472218-27d3d170-55bc-4c1d-b49d-5cde5ed77519.png)

![Screenshot (221)](https://user-images.githubusercontent.com/102204260/224472224-08011774-372d-4350-bb62-acc1c8b98f06.png)


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
