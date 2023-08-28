### INITIALISATION OF MICROSERVICES  
1. Create all needed modules
2. Create "Application" classes in all modules and declare as "SpringBootApplication" and "EnableDiscoveryClient" for show what it's "Service Discovery"
3. Create ["application.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\application.yml) and made it as main configuration for all project 
4. Create another ["application.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\application.yml) where will be declared general settings for all services
5. Create "bootstrap.yml" in all modules of the project except "config-service" because its general service
6. Create configuration files for all services 
   - ["account-service.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\account-service.yml)
   - ["bill-service.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\bill-service.yml)
   - ["deposit-service.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\deposit-service.yml) Here will be part with "rabbitmq" settings because they're connected  
   - ["gateway.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\gateway.yml)
   - ["notification-service.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\notification-service.yml) Here will be part with the "rabbitmq" settings because they're connected
   - ["registry.yml"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\config-service\src\main\resources\services\registry.yml) Here will be part's with the "hystrix", "ribbon", "zuul" settings because they're connected

7. Next need configure "build.gradle" files and add dependencies
   - ["build.gradle" for "account-service"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\account-service\build.gradle)
   - another "build.gradle" files have the same logic construct but with own libraries and main classes

### BUSINESS LOGIC

1. Create controller, dto, entity, repository and service for all modules
2. Create ["MailConfig"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\notification-service\src\main\java\com\javastart\notification\config\MailConfig.java) and ["mail-props.properties"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\notification-service\src\main\resources\mail-props.properties)
3. Create ["RabbitMQConfig"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\notification-service\src\main\java\com\javastart\notification\config\RabbitMQConfig.java)
4. Create ["DepositMessageHandler"](C:\Users\Vegas\IdeaProjects\spring-cloud-microservices\notification-service\src\main\java\com\javastart\notification\service\DepositMessageHandler.java) for handling messages which comes from RabbitMQ
5. 
