# Documentation

# Contents

* Introduction
* Tech stack
* Setup Instruction
* Api Documentation
* Testing

  ## Introduction
  The Wishlist Management System is an innovative web application designed to empower users in their pursuit of desires. With its intuitive interface, users can effortlessly create, organize, and monitor personalized wishlists. Whether dreaming of a new gadget, a travel adventure, or a cozy book, this system provides a digital canvas for capturing aspirations. The RESTful API endpoints facilitate seamless interactions, allowing users to add, edit, or delete wishlist items
  ## Tech stack Used
  * Spring boot :- It provides framework to backend application you can refer from here / https://spring.io/projects/spring-boot/
  * Spring Security:- It is help to Secure and authenticate the endpoint you can refer from / https://spring.io/projects/spring-security
  * MySQL:-it help to store data in database you can refer from here / https://www.mysql.com/
  * JUnit and Mockito:-It is used write unit test cases /https://junit.org/junit5/

  ## Setup Instruction
  * clone this repository or project from github
  * opne in any IDE like vsCode, intelize , etc
  * build connection of database craete database in mySQL and make connection
  * Run project using maven
  * now you can test api from postman

  ##  Api Documentation
  ### The following API endpoints are available:
  
* POST /user/sign-in: Create a new user.
* POST /auth/login: Authenticates the user or login as user.
* GET /api/get-wishlist: Retrieve a user's wishlist.
* POST /api/addItem: Create a new wishlist item.
* DELETE /api/deleteItem/{id}: Remove a wishlist item by ID.
  
 ###   You can test APIs using Postman.
 * for post user sign-in
   - Create a new request in Postman.
   - Set the request URL to http://localhost:8088/user/sign-in.
   - Choose the POST HTTP method.
   - Go to body->raw then select "JSON" from the type dropdown. After that provide user details in JSON form like username and password and other deatails.
   - Send the request.
 * for post user login
   - Create a new request in Postman.
   - Set the request URL to http://localhost:8088/auth/login.
   - Choose the POST HTTP method.
   - Go to body->raw then select "JSON" from the type dropdown. After that provide user details in JSON form like username and password.
   - Send the request.
 * for Get user's wishlist 
   - Create a new request in Postman.
   - Set the request URL to http://localhost:8088/api/get-wishlist.
   - Choose the POST HTTP method.
   - Go to Param-> and give key as 'username' and value is your actual username like key->username, value->"alok".
   - Send the request.
 * for Delete  wishlist item 
   - Create a new request in Postman.
   - Set the request URL to http://localhost:8088/api/deleteItem/{id}.
   - Choose the POST HTTP method.
   - give id as url like http://localhost:8088/api/deleteItem/1  here id is 1 so we get wishlist whose user id 1.
   - Send the request.
  
 * for post user sign-in
   - Create a new request in Postman.
   - Set the request URL to http://localhost:8088/api/addItem.
   - Choose the POST HTTP method.
   - Go to body->raw then select "JSON" from the type dropdown. After that provide item details in JSON form like product name, description, price etc
   - Send the request.
 ## Testing
  Unit tests are a fundamental aspect of software development. They serve as the first line of defense against defects, ensuring that individual components of an application function correctly. Here’s an elaboration on the paragraph you provided
  Unit tests are automated tests designed to verify the correctness of small, isolated units of code (usually functions or methods) in isolation.
   They validate whether each unit behaves as expected, adhering to its specified functionality.
  Unit tests isolate specific code segments, allowing developers to focus on individual units without considering the entire system.

  
