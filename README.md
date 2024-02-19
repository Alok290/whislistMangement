# Documentation

# Contents

* Introduction
* Tech stack
* Setup Instruction
* Api Documentation
* Testing
* Api screenShot

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

  
