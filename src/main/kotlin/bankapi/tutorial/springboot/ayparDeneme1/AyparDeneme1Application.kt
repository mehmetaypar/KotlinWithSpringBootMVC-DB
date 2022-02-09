package bankapi.tutorial.springboot.ayparDeneme1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@OpenAPIDefinition
@SpringBootApplication
class AyparDeneme1Application

fun main(args: Array<String>) {
	//SwaggerConfig()

	runApplication<AyparDeneme1Application>(*args)
}
