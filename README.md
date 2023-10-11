## Projekat za Udruženje paraplegičara Podgorice - Code For Cause 2023

### Kako ranovati aplikaciju:
1. Potrebno je skinuti JDK 17 i setovati JAVA_HOME env varijablu
da pokazuje na jdk koji smo skinuli. Putanja treba da upućuje na root folder unutar kod je bin folder. 
2. U projektu postoji Gradle wrapper koji možemo koristiti da izbildamo i podignemo aplikaciju.

Unutar projekta ranujemo sledeće komande:

#### Linux
./gradlew build <br> 
./gradlew bootRun

#### Windows
./gradlew.bat build <br>
./gradlew.bat bootRun

Korisne informacije o gradle wrapper-u: 
https://docs.gradle.org/current/userguide/gradle_wrapper.html
https://www.youtube.com/watch?v=gKPMKRnnbXU&ab_channel=MarcoCodes

### Ranovanje testova 
(koje trenutno nemamo xD)
#### Linux
./gradlew test

#### Windows
./gradlew.bat test

<br>

#### Napomene:
Prilikom prvog podizanja aplikacije automatski će biti kreirani određeni testni podaci - kategorije, elementi pristupačnosti i par lokacija koje možemo iskoristiti da istestiramo osnovne funkcionalnosti. 
