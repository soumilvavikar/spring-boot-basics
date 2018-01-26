# Spring Boot Quick Help #

: Use Spring Initializer to create initial structure for Spring Boot: http://start.spring.io/

: Steps to generate an executable spring boot appln WAR for tomcat server:
    1. In pom.xml change the following:
        : packaging should be "war" in place of jar
        : add dependency for embedded tomcat
    2. Application.java (start up class) should extend --> SpringBootServletInitializer
    3. In Application.java override the "configure" method

: Build the war using mvnw package
: Run the application
    Option 1 -
        : Put the generated war in the webapps folder of tomcat and start tomcat
        : Here the name of the WAR is important, as tomcat uses the name of the WAR as the context path
        : Rename the WAR to spring-boot-web.war and then start the tomcat
        : URLs - http://localhost:8080/spring-boot-web | http://localhost:8080/spring-boot-web/hello

    Option 2 -
        : Start the application directly using - java -jar target/spring-boot-web.war
        : URLs: http://localhost:8080/ | http://localhost:8080/hello

    Option 3 -
        : Load Properties from Prod Config -
            SPRING_PROFILES_ACTIVE=production java -jar target/spring-boot-web.war
            SPRING_PROFILES_ACTIVE=production java -jar target/spring-boot-web-0.0.1-SNAPSHOT.war

    Option 4 -
        : Override properties using cmd line arguments
            java -jar target/spring-boot-web.war --message='Hello from a command line arg!'

: Reading properties from an external properties file -->
    - Check the implementation at the following location:
        - src/main/resources/application.properties
        - HelloController1.java --> helloMessage() and message variable


: Quick Help Links:
    :: https://spring.io/guides/gs/spring-boot/#scratch
    :: https://github.com/pivotal-education/apps-spring-boot-developer-code