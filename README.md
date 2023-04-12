# Documentation
Ce projet spring boot  application bancaire dans laquelle  des statistiques seront fournies et table0au de bord (dashbord).
Dans ce projet nous aurons recours JWT(Json Web token) token pour assurer la sécurité  .
L'utilisateur pourra effectuer des transactions ;des dépôts et transferts suivant un iban.

## Création projet
````
 https://start.spring.io/
````
# Installation  et configuration de maven
Vous devez ajouter télécharger maven depuis ici [https://maven.apache.org/download.cgi]

Vous pouvez utiliser pour nettoyer le projet Maven en supprimant le répertoire cible.
````
mvn clean install
````
Vous pouvez  installer le package dans le référentiel local, pour l'utiliser comme dépendance dans d'autres projets localement.
````
mvn install` 
````

# Configuration et gestion des dépendances
Ajouter des dépendances dans le projet dans le pom.xml
### Lombok
Vous pouvez utiliser lombok pour génèrer des annotations @Getter, @Setter ,@Builder ...
````  
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
`````
### Iban
``````
<!-- https://mvnrepository.com/artifact/org.iban4j/iban4j -->
<dependency>
    <groupId>org.iban4j</groupId>
    <artifactId>iban4j</artifactId>
    <version>3.2.4-RELEASE</version>
</dependency>
``````
Vous aurez besoin de des dépendances web et security pour le service d'authentifcation et la sécurité
### Spring boot starter web 
``````
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
``````
### Spring security
``````
<dependency> 
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-security</artifactId> 
</dependency> 
``````
### jsonwebtoken (JWt)
`````
 <dependency>
   <groupId>io.jsonwebtoken</groupId>
   <artifactId>jjwt</artifactId>
   <version>0.9.1</version>
 </dependency>
`````
# Usage
Vous pouvez modifier pour la connexion à la connexion à la base de donnée dans   application.yaml qui se trouve dans le 
repertoire src/main/ressources
````
spring:
  datasource:
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/db_name
    username: 
    password: 
  jpa:
    hibernate:
      ddl-auto: update
    database: postgresql
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    show-sql: true
````
Dans le cas ou choissez de nommez votre ressource en applicaction properties vous aurez la configuration suivant:
````
spring.datasource.driverClassName: org.postgresql.Driver
spring.datasource.url: jdbc:postgresql://localhost:5432/db_name
spring.datasource.username: 
spring.datasource.password: 
spring.jpa.show-sql: true
spring.jpa.hibernate.ddl-auto: update
spring.jpa.properties.database: postgresql
spring.jpa.properties.database-platform: org.hibernate.dialect.PostgreSQLDialect

````
