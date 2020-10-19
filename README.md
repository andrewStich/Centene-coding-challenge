# Centene Coding Challenge: Back End
My submisssion for the back end coding challenge giving by Centene. We were asked to create a simple database microservice capable of CRUD operations.

## Technologies Used:
* Spring/MVC
* JPA/Hibernate
* MYSQL
* Postman

[Source Code](https://github.com/andrewStich/Centene-coding-challenge/tree/master/src/main/java/com/nagazlabs/challenge)

### Shortcommings
* The main issue I ran into during this project was my lack of experience using mongoDB. The first itteration of this solution used Mongo as it's DB instead of MYSQL, but I spent a good portion of 2 days just trying to integrate it with spring. I ended up cutting my losses and hastily creating a version using MYSQL, but ran out of the allotted time to do proper testing of the API.
* I also spent time trying to implement this as a eureka client, as this challenge was to deliver a microservice. After a few hours of tinkering, I was also unable to get the microservice to communicate with the eureka server.
