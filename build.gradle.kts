import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
	kotlin("jvm") version "1.8.22"
	kotlin("plugin.spring") version "1.8.22"
	kotlin("plugin.jpa") version "1.9.10"
}

group = "vegait.rs"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.4")
	implementation("mysql:mysql-connector-java:8.0.33")

//	implementation("org.hibernate.orm:hibernate-core:6.1.7.Final")
	compileOnly("org.hibernate.orm:hibernate-jpamodelgen:6.2.6.Final")
	implementation("com.blazebit:blaze-persistence-core-api-jakarta:1.6.9")
	runtimeOnly("com.blazebit:blaze-persistence-core-impl-jakarta:1.6.9")
	implementation("com.blazebit:blaze-persistence-integration-hibernate-6.2:1.6.9")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	
//	implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.1")
//	implementation("com.sun.xml.bind:jaxb-impl:4.0.3")
//	implementation("jakarta.transaction:jakarta.transaction-api:2.0.1")
//	implementation("jakarta.activation:jakarta.activation-api:2.1.2")
//	implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")

	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
