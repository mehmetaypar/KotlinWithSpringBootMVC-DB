package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.ayparDeneme1.datasource.BankDataSource
import bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource.JpaBankRepository
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import bankapi.tutorial.springboot.ayparDeneme1.model.jpaBankEntity
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.sql.SQLException
import java.util.*

@Service//makes this bean/obj available at runtime
//can be injected as a dependency injection to other classes/objects
//calls DS'es, handle/maps exceptions, performs data transformations (bussiness logic)
class BankService (val jpaBankRepository: JpaBankRepository){//,val dataSource: BankDataSource){
// TODO: 2/5/2022 EMPTY HERE AND Carry bussiness logic to İMPLEMENT BankDataSource:jpaBankRepository FUNCTİONS OVERLOAD
    fun getBank(accountNumber: String): jpaBankEntity = jpaBankRepository.getReferenceById(accountNumber)

    fun getBankBySurname(surname: String): List<jpaBankEntity> = jpaBankRepository.findBySurname(surname)

    fun getBanks():List<jpaBankEntity> = jpaBankRepository.findAll()

    fun addBank(bank : jpaBankEntity):jpaBankEntity {
        val checker: Optional<jpaBankEntity> =
            bank.accountNumber?.let { jpaBankRepository.findById(it) } as Optional<jpaBankEntity>
        if (checker.isPresent){
            throw  IllegalArgumentException ("Bank with accountNumber ${bank.accountNumber} already exists")
        }else{
        jpaBankRepository.save(bank)}
    return bank
}

    fun updateBank (bank : jpaBankEntity):jpaBankEntity {
        val checker: Optional<jpaBankEntity> =
            bank.accountNumber?.let { jpaBankRepository.findById(it) } as Optional<jpaBankEntity>
        if (checker.isEmpty){
            throw  NoSuchElementException ("Bank with accountNumber ${bank.accountNumber} does not exists")
        }else{
            jpaBankRepository.save(bank)
        }
        return bank
    }

    fun removeBank (accountNumber : String) {
        try {
            val checker: jpaBankEntity? = jpaBankRepository.getReferenceById(accountNumber)
            if (checker != null) {
                jpaBankRepository.delete(checker)
            }

        } catch (e: Exception) {
            throw  NoSuchElementException("Bank with accountNumber $accountNumber does not exists")
        }

    }
}


