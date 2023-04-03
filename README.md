# Projet spring boot application bancaire stastitiques et dashboard 
# Installation de maven

https://maven.apache.org/download.cgi

## Maven clean

Run `mvn clean install` pour nettoyer le projet Maven en supprimant le répertoire cible.

## Maven install

Run `mvn install` installe le package dans le référentiel local, pour l'utiliser comme dépendance dans d'autres projets localement.

## Mvn verify

Run `mvn verify` génère le projet, exécute tous les cas de test et vérifie les résultats des tests d'intégration pour s'assurer que les critères de qualité sont respectés 

## Mvn compile
Run `mvn compile`compile les classes Java source du projet.
# Spring boot 
## Création projet 
Run https://start.spring.io/
## Ajout des dépendances dans le projet
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