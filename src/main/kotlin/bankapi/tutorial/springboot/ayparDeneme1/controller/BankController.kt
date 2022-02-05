package bankapi.tutorial.springboot.ayparDeneme1.controller

//import bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource.JpaBankRepository
import bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource.JpaBankRepository
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import bankapi.tutorial.springboot.ayparDeneme1.model.jpaBankEntity
//import bankapi.tutorial.springboot.ayparDeneme1.model.jpaBankEntity
import bankapi.tutorial.springboot.ayparDeneme1.service.BankService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController// consider this as bean
@RequestMapping//("/api/banks")
class BankController(private val service: BankService, val  jpaBankRepository: JpaBankRepository) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundFunc(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequestFunc(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)


    @GetMapping("/id/{accountNumber}")
    fun getBank(@PathVariable accountNumber: String): jpaBankEntity {
        return service.getBank(accountNumber)
    }
    @GetMapping("/getdata")
    fun getBankData()= service.getBanks()

    @PostMapping("/posted")
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank :jpaBankEntity): jpaBankEntity = service.addBank(bank)


    @PatchMapping
    @ResponseStatus(HttpStatus.FOUND)
    fun updateBank(@RequestBody bank: jpaBankEntity) :jpaBankEntity =service.updateBank(bank)



    @GetMapping("/surname/{surname}")
    fun getBankBySurname(@PathVariable surname: String):List <jpaBankEntity> = service.getBankBySurname(surname)

@DeleteMapping("/{accountNumber}")
fun removeBank(@PathVariable accountNumber: String):Unit = service.removeBank(accountNumber)

}
//@DeleteMapping("/{accountNumber}")
//fun removeBank(@PathVariable accountNumber: String):Unit = service.removeBank(accountNumber)

    // @PatchMapping
   // @ResponseStatus(HttpStatus.FOUND)
   // fun updateBank(@RequestBody bank: Bank) :Bank =service.updateBank(bank)


//service.getBank(accountNumber)


    /*
    @GetMapping("/getdata")
    fun getBankData() :Collection<Bank>{
        //return jpaBankRepository.findAll()
        return  service.getBanks()

    }

       @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        fun addBank(@RequestBody bank :Bank): Bank = service.addBank(bank)

        @PatchMapping
        @ResponseStatus(HttpStatus.FOUND)
        fun updateBank(@RequestBody bank: Bank) :Bank =service.updateBank(bank)


        @DeleteMapping("/{accountNumber}")
        fun removeBank(@PathVariable accountNumber: String):Unit = service.removeBank(accountNumber)

 }

     */
