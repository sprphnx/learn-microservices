# learn-microservices

# Docker
Run this from each micro-service to create docker image.
./mvnw spring-boot:build-image 

docker run --name discovery -d -it -p8761:8761 discovery-server:0.0.1-SNAPSHOT

docker run --name movie-catalog-service -d -it -p8081:8081 --link discovery:discovery movie-catalog-service:0.0.1-SNAPSHOT 

docker run --name movie-info-service -d -it -p8082:8082 --link discovery:discovery movie-info-service:0.0.1-SNAPSHOT

docker run --name rating-data-service -d -it -p8083:8083 --link discovery:discovery rating-data-service:0.0.1-SNAPSHOT

# Spring boot jars

update eureka.client.service-url.defaultZone=http://<eureke-server-ip>:8761/eureka/

# Reference
https://www.youtube.com/watch?v=y8IQb4ofjDo&list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas <main reference>

https://stackoverflow.com/questions/47539086/eureka-client-in-docker-not-connecting-with-eureka-server

https://docs.docker.com/network/links/


