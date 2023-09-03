### INITIALISATION OF MICROSERVICES
1. Create all needed modules
2. Create "Application" classes in all modules and declare as "SpringBootApplication" and "EnableDiscoveryClient" for show what it's "Service Discovery"
3. Create ["application.yml"](../spring-cloud-microservices/config-service/src/main/resources/application.yml) and made it as main configuration for all project
4. Create another ["application.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/application.yml) where will be declared general settings for all services
5. Create "bootstrap.yml" in all modules of the project except "config-service" because its general service
6. Create configuration files for all services
   - ["account-service.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/account-service.yml)
   - ["bill-service.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/bill-service.yml)
   - ["deposit-service.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/deposit-service.yml) Here will be part with "rabbitmq" settings because they're connected
   - ["gateway.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/gateway.yml)
   - ["notification-service.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/notification-service.yml) Here will be part with the "rabbitmq" settings because they're connected
   - ["registry.yml"](../spring-cloud-microservices/config-service/src/main/resources/services/registry.yml) Here will be part's with the "hystrix", "ribbon", "zuul" settings because they're connected

7. Next need configure "build.gradle" files and add dependencies
   - ["build.gradle" for "account-service"](../spring-cloud-microservices/account-service/build.gradle)
   - another "build.gradle" files have the same logic construct but with own libraries and main classes

### BUSINESS LOGIC

1. Create controller, dto, entity, repository and service for all modules
2. Create ["MailConfig"](../spring-cloud-microservices/notification-service/src/main/java/com/javastart/notification/config/MailConfig.java) and ["mail-props.properties"](../spring-cloud-microservices/notification-service/src/main/resources/mail-props.properties)
3. Create ["RabbitMQConfig"](../spring-cloud-microservices/notification-service/src/main/java/com/javastart/notification/config/RabbitMQConfig.java)
4. Create ["DepositMessageHandler"](../spring-cloud-microservices/notification-service/src/main/java/com/javastart/notification/service/DepositMessageHandler.java) for handling messages which comes from RabbitMQ

### DOCKER CONTAINERS

1. Specify the location (IP address) of the local machine in all ".yml" files of services accessing the database
2. Create "Dockerfile" for all modules
   - ["Dockerfile" for "account-service"](../spring-cloud-microservices/account-service/Dockerfile)
   - ["Dockerfile" for "bill-service"](../spring-cloud-microservices/bill-service/Dockerfile)
   - ["Dockerfile" for "config-service"](../spring-cloud-microservices/config-service/Dockerfile)
   - ["Dockerfile" for "deposit-service"](../spring-cloud-microservices/deposit-service/Dockerfile)
   - ["Dockerfile" for "gateway"](../spring-cloud-microservices/gateway/Dockerfile)
   - ["Dockerfile" for "notification-service"](../spring-cloud-microservices/notification-service/Dockerfile)
   - ["Dockerfile" for "registry"](../spring-cloud-microservices/registry/Dockerfile)
3. Create ["docker-compose"](../spring-cloud-microservices/docker-compose.yml) for all project. This file will specify the startup procedure of the application modules using Docker.
4. Create "wait-for.sh" files for all modules except "config-service". It's script for startup Docker containers . It can be changed to "docker swarm" or "k8s".
   - ["wait-for.sh" for "account-service"](../spring-cloud-microservices/account-service/wait-for.sh)
5. Make next
   - clean/build for all project in gradle tasks
   - in terminal print command "docker-compose build" for building docker containers of the application
   - in terminal print command "docker-compose up" for start all docker containers
6. After successful startup, check all services in "Eureka" at address "localhost:8761"
7. Check all queries in the "Postman"