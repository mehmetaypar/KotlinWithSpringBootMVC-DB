package bankapi.tutorial.springboot.ayparDeneme1.controller

import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import bankapi.tutorial.springboot.ayparDeneme1.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController// consider this as bean
@RequestMapping("/api/banks")
class BankController(private val service: BankService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundFunc(e: NoSuchElementException):ResponseEntity<String> = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequestFunc (e: IllegalArgumentException):ResponseEntity<String> = ResponseEntity(e.message,HttpStatus.BAD_REQUEST)


    @GetMapping("/getdata")
    fun getBankData() :Collection<Bank>{return  service.getBanks() }

    @GetMapping("/id/{accountNumber}")
  fun getBank(@PathVariable accountNumber:String):Bank=service.getBank(accountNumber)

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
fun addBank(@RequestBody bank :Bank): Bank = service.addBank(bank)

    @PatchMapping
    @ResponseStatus(HttpStatus.FOUND)
    fun updateBank(@RequestBody bank: Bank) :Bank =service.updateBank(bank)


    @DeleteMapping("/{accountNumber}")
    fun removeBank(@PathVariable accountNumber: String):Unit = service.removeBank(accountNumber)
}