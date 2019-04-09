# spring-boot-microservices-example

- discovery eureka server
- zuul gateway
- docker images are build via dockerfile-maven-plugin
- jms activemq server
- micro services talk via RestTemplate
- micro services talk via JmsTemplate






### Docker
To use dockerfile-maven-plugin you must add your docker server server to .m2/setting.xml under the servers tag:

```
<server>
  <id>docker.io</id>
  <username><user id></username>
  <password><password></password>
</server>
```
, and in your pom add these properties:

```
<properties>
    <docker.image.prefix>oajamfibia</docker.image.prefix>
    <project.build.finalName>${project.artifactId}-${project.version}</project.build.finalName>
    <dockerfile-maven-version>1.4.10</dockerfile-maven-version>
</properties>
```
and the 

#### maven-dependency-plugin
Unpack the jar to prepare for the dependencies to be added separately to the docker image. 
 
#### dockerfile-maven-plugin
Build the docker image 
 
, ```<useMavenSettingsForAuth>``` to use the server credentials in .m2/setting.xml 

Also add the Dockerfile.

#### Docker in maven life cycle

Docker build and upload is now part of maven lifecycle

```mvn deploy```    , does

- build the jar
- unpack the jar (to add the dependencies separately to the docker image)
- build the docker image
- upload the docker image to the docker repository server, in this case docker.io

#### Running in local docker container 
To run the image named my-docker-id/my-image:0.0.1 in a local docker container, naming the container my-image-container and open port 8080
```
docker run --name my-image-container -p 8080:8080 -d my-docker-id/my-image:0.0.1
```