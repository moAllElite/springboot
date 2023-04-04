# Documentation
Ce projet spring boot application bancaire statistiques et dashboard
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
Pour compiler les classes Java source du projet.
````
mvn compile
````
# Configuration et gestion des dépendances
Ajouter des dépendances dans le projet dans le pom.xml
### Lombok

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