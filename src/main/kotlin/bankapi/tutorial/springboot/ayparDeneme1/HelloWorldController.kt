package bankapi.tutorial.springboot.ayparDeneme1

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/hello")
class HelloWorldController {

    @GetMapping("/obivan")
    fun myFirstFunction ():String = "Hello there, young one";

//below wont take input
    @PostMapping("/çarpıcıFunc")
fun mySecondFunction (val1:Int):Int = val1*7;
}