### INITIALISATION OF MICROSERVICES  
1. Create all needed modules
2. Create "Application" classes in all modules and declare as "SpringBootApplication"
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
   - 
8.