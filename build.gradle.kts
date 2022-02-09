import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
	id("org.springframework.boot") version "2.7.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("org.openapi.generator") version "5.3.1"
	id("maven-publish")
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"

}

group = "bankapi.tutorial.springboot"
version = "0.0.1"

java {
	sourceCompatibility = JavaVersion.VERSION_11
	withSourcesJar()
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation( files("build/libs/mysql-connector-java-8.0.20.jar"))

	implementation("org.hibernate:hibernate-core:5.6.5.Final")
	implementation("org.hibernate:hibernate-entitymanager:5.6.4.Final")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.5.9")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("io.swagger:swagger-annotations:1.6.4")

	implementation("org.springdoc:springdoc-openapi-kotlin:1.5.0")

	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
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
	main.java.srcDirs("src/main/java", "src/main/kotlin", "$buildDir/generated/src/main/kotlin")
}
tasks.getByName("sourcesJar") {
	dependsOn(tasks.named("openApiGenerate"))
}

tasks.named<GenerateTask> ("openApiGenerate"){
	setProperty("generatorName","spring")
	setProperty("templateDir","${rootDir.absolutePath}/swagger/template")
	setProperty("inputSpec","${rootDir.absolutePath}/swagger/swagger.yaml")
	setProperty("configOptions",mapOf(
			Pair("title","ayparsDenemeClientLib"),
			Pair("datelib","java8"),
			Pair("useBeanValidation","false"),
			Pair("hideGenerationTimestamp","true"),
			Pair("swaggerAnnotations","false"),
			Pair("useTags","false")
		)
	)
}

tasks.withType<Jar> { duplicatesStrategy = DuplicatesStrategy.EXCLUDE }

tasks.compileJava {
	dependsOn(tasks.named("openApiGenerate"))
}

