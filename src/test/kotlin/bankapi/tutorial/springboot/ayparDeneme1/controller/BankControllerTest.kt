package bankapi.tutorial.springboot.ayparDeneme1.controller

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest// triggers the spring boot for initialize entire application context
//Starts the application for the test ,=> expensive
@AutoConfigureMockMvc//SpringBootTest only init its own application beans , this needed for init MockMvc
internal class BankControllerTest{

    @Autowired//bean
    lateinit var mockMvc: MockMvc //allows to make Req from REST-API without issuing any http req
//lateinit var, allows us to know that this is injected by a framework
/*
    @Test
    fun `should return all the banks` () {
        // when/then
mockMvc.get("/api/banks")
    .andDo { print() }
    //then
    .andExpect {
        status { isOk() }
        content { contentType(MediaType.APPLICATION_JSON) }
        jsonPath("$[0]accountNumber") {value("123456789") }
    }


    }
 */

}