# movie-rating-project-fullstack-backend

This is the backend of the movie rating project.

It is a Spring Boot microservice that uses MongoDB as database.
The Spring Boot and MongoDB are both dockerized and can be found on DockerHub here: https://hub.docker.com/repository/docker/leoqu/movie-rating-project/general

There are two images: mongo and movie-rating-backend-docker-image. 

In addition, I used Docker Compose to link up these two images to simplify the process of running containers from the image.
