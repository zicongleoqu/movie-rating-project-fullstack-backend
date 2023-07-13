# movie-rating-project-fullstack-backend 🎥

This is the backend of the movie rating project. The RESTful API endpoints enable the following actions:
- Create new movies
- Get all movies
- Get a movie by Id
- Get the average rating of a movie by Id
- Update a movie
- Delete a movie
- Create a new review
- Delete a review by Id

This is a Spring Boot microservice that uses MongoDB as a NoSQL database. 
- It stores two tables: movies and reviews. The Movies table contains details about the movie and all of its reviews. The Reviews table has a rating (out of 5), a comment, and the related movie's id.

See the OpenAPI Specification of all the endpoints and models here: http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/swagger-ui/index.html#/ (Note: Some response bodies are not accurate. Will update in the future)

# Dockerization
The Spring Boot and MongoDB are both dockerized and can be found on DockerHub here: https://hub.docker.com/repository/docker/leoqu/movie-rating-project/general

There are two images: mongo and movie-rating-backend-docker-image. 

In addition, I used Docker Compose to link up these two images to simplify the process of running containers from the image. Go to the resource folder where the Docker compose file is located and run this command: ```docker compose up```.

# Deployment

Deployed on local machine using Kubernetes Minikube.

Update: Stopped the instance because my free tier instance has reached the limit 😢
Deployed on an AWS EC2 instance. Accessible at http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/
- Try this URL to see the list of movies: http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/api/v1/movies
- Try this URL to get a specific movie: http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/api/v1/movies/tt3915174
- Try this URL to get the average rating of a specific movie: http://ec2-52-15-60-189.us-east-2.compute.amazonaws.com/api/v1/movies/64863c77cdf6f1dcceef0faf/average

# CI/CD pipeline with GitHub Actions

The pipeline does the following:
- Build the project with Maven
- Build Docker Image
- Push Docker Image to the DockerHub Repo here: https://hub.docker.com/repository/docker/leoqu/movie-rating-project/general (tag: latest_from_pipeline)
