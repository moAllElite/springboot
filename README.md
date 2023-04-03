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
## Création du projet spring boot 
Run https://start.spring.io/
## Dépendance du projet
   <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.iban4j/iban4j -->
        <dependency>
            <groupId>org.iban4j</groupId>
            <artifactId>iban4j</artifactId>
            <version>3.2.4-RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>