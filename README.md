# Elasticsearch using Spring Data
This repository contains a demo project showcasing CRUD operations using spring-data-elasticsearch.
This project was initially created using [spring initializr](https://start.spring.io/). 

## Requirements
* Java
* Gradle
* Docker (optional)
* Elasticsearch
    * [Install and Run Elasticsearch (Docker)](https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html)
    * [Install and Run Elasticsearch (OS)](https://www.elastic.co/guide/en/elasticsearch/reference/current/getting-started-install.html)

## Reference Documentation
For further reference, please consider the following sections:
* [Spring Data Elasticsearch](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-elasticsearch)
* [Manage Elasticsearch mappings and index (Postman Collection)](https://www.getpostman.com/collections/1ce1ccb3d99ef8acd697)
* [spring-data-examples](https://github.com/spring-projects/spring-data-examples/tree/master/elasticsearch)

## k8s - MiniKube

1. Enter the nix shell:
```
nix-shell
```
2. Build image:
```
./gradlew bootBuildImage --imageName=np.com.ashimregmi/spring-data-elasticsearch-example
```
3. Load image into minikube:
```
minikube image load np.com.ashimregmi/spring-data-elasticsearch-example
```
4. Apply k8s config YAMLs:
```
minikube kubectl -- apply -f k8s/
```
5. Check the logs of spring-boot app:
```
minikube kubectl -- logs -f -l app=main
```
6. Check the url of the main service:
```
minikube service main --url
```
7. Command to clean:
```
minikube kubectl -- delete -f k8s/
```