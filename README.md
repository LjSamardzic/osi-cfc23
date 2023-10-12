## Projekat za Udruženje paraplegičara Podgorice - Code For Cause 2023

### Kako pokrenuti aplikaciju:
1. Potrebno je skinuti [JDK 17](https://adoptium.net/temurin/releases/)  i setovati JAVA_HOME env varijablu
da pokazuje na jdk koji smo skinuli. Putanja treba da upućuje na root folder unutar kod je bin folder.
   
2. U projektu postoji Gradle wrapper koji možemo koristiti da podignemo aplikaciju.

Unutar projekta izvršimo sledeće komande:

#### Linux
```bash
./gradlew bootRun
```

#### Windows
```bash
gradlew.bat bootRun
```

Korisne informacije o gradle wrapper-u:   

[https://docs.gradle.org/current/userguide/gradle_wrapper.html](http://localhost:8080/swagger-ui/index.html)    
[https://www.youtube.com/watch?v=gKPMKRnnbXU&ab_channel=MarcoCodes](http://localhost:8080/swagger-ui/index.html)

### Pokretanje testova 
(koje trenutno nemamo xD)
#### Linux
```bash
./gradlew test
```

#### Windows
```bash
./gradlew.bat test
```
<br>

#### Napomene:
Prilikom prvog podizanja aplikacije automatski će biti kreirani određeni testni podaci - kategorije, elementi pristupačnosti i par lokacija koje možemo iskoristiti da istestiramo osnovne funkcionalnosti. 

#### Aplikacija je dostupna na [http://localhost:8080](http://localhost:8080) a swagger UI na [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)`
