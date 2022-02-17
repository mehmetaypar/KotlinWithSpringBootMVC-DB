import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.openapi.generator") version "5.3.1"
	id("maven-publish")
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"

}

group = "bankapi.tutorial.springboot"
version = "1.0.0"

java {
	sourceCompatibility = JavaVersion.VERSION_11
	withSourcesJar()
}

repositories {
	mavenCentral()
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.MappedSuperclass")
	annotation("javax.persistence.Embeddable")
}

dependencies {
	implementation("mysql:mysql-connector-java:8.0.15")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	implementation("org.hibernate:hibernate-core:5.6.5.Final")
	implementation("org.hibernate:hibernate-entitymanager:5.6.4.Final")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("io.swagger:swagger-annotations:1.6.4")

	implementation("org.springdoc:springdoc-openapi-data-rest:1.6.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.0")
	implementation("org.springdoc:springdoc-openapi-kotlin:1.6.0")

	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-json")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.mockk:mockk:1.10.4")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	val main by getting
	main.java.srcDirs("src/main/kotlin", "$buildDir/generated/src/main/kotlin")
}
tasks.getByName("sourcesJar") {
	dependsOn(tasks.named("openApiGenerate"))
}

tasks.getByName("openApiGenerate"){
	setProperty("generatorName","kotlin-spring")
	setProperty("templateDir","${project.rootDir}/swagger/template")
	setProperty("inputSpec","${project.rootDir}/swagger/swagger.yaml")
	setProperty("templateDir", "${project.rootDir}/swagger/template/")
	setProperty("configFile", "${project.rootDir}/swagger/template/config.yaml")
	setProperty("outputDir", "$buildDir/generated")
	setProperty("apiPackage", "bankapi.tutorial.springboot.api")
	setProperty("modelPackage", "bankapi.tutorial.springboot.model")
	setProperty("packageName", "bankapi.tutorial.springboot")
	setProperty("skipValidateSpec", true)
	setProperty("configOptions",mapOf(
		Pair("dateLibrary", "java8"),
		Pair("useBeanValidation", "true"),
		Pair("hideGenerationTimestamp", "false"),
		Pair("swaggerAnnotations", "true"),
		Pair("useTags", "true"),
		Pair("delegatePattern", "false"),
		Pair("interfaceOnly", "false"),
		Pair("serviceInterface", "true"),
		Pair("serviceImplementation", "false"),
		Pair("reactive", "false"),
		Pair("enumPropertyNaming", "UPPERCASE")
		)
	)
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

tasks.compileKotlin {
	dependsOn(tasks.named("openApiGenerate"))
}

