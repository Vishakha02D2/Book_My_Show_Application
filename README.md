# Book_My_Show_Application

Book My Show is a web application for booking movie tickets online. It provides users with the convenience of browsing movies, selecting show timings, and booking tickets from the comfort of their homes. The application is built using Java, Spring Boot, and Maven, and utilizes APIs, SQL Database, Spring Data JPA, Model Mapper, Mail Sender, and Swagger UI.

Features : 
Book My Show offers the following features:

Browse movies and view their details
View show timings for a movie
Book tickets for a show
Add new movies to the system
Add new show timings for a movie
Swagger UI for API documentation

Schema Design : https://user-images.githubusercontent.com/120273836/225565201-96cd7c67-769c-44cc-8a4f-bca064646b6a.png

APIs :
The project includes the following APIs:

/movies - GET: Get a list of all movies
/movies/{id} - GET: Get details of a movie by its ID
/movies - POST: Add a new movie
/movies/{id}/shows - GET: Get show timings for a movie by its ID
/shows - POST: Add a new show
/shows/{id}/book - POST: Book tickets for a show by its ID

Getting Started :
Getting Started: To run the application, clone the repository and run the following command:

Copy code mvn spring-boot:run This will start the application on localhost:9999.

To view the Swagger UI documentation, navigate to localhost:9999/swagger-ui.html.

https://user-images.githubusercontent.com/120273836/225565301-b94c910c-fe7b-43df-8610-86891bed0d6d.png

Contributors
Vishakha.. 





