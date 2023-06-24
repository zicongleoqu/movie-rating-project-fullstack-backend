# movie-rating-project-fullstack-backend

This is the backend of the movie rating project. The RESTful API endpoints enable the following actions:
- Create new movies
- Get all movies
- Get a movie by Id
- Get the average rating of a movie by Id
- Update a movie
- Delete a movie
- Create a new review
- Delete a review by Id

This is a Spring Boot microservice that uses MongoDB as NoSQL database.

# Dockerization
The Spring Boot and MongoDB are both dockerized and can be found on DockerHub here: https://hub.docker.com/repository/docker/leoqu/movie-rating-project/general

There are two images: mongo and movie-rating-backend-docker-image. 

In addition, I used Docker Compose to link up these two images to simplify the process of running containers from the image. Go to the resource folder where the Docker compose file is located and run this command: ```docker compose up```.

# Deployment

Deployed on local machine using Kubernetes Minikube.

Deployed on an AWS EC2 instance. Accessible at http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/
- Try this URL to see the list of movies: http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/api/v1/movies
- Try this URL to get a specific movie: http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/api/v1/movies/tt3915174
