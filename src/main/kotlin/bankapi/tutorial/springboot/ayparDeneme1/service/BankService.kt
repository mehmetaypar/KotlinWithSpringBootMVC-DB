package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.ayparDeneme1.datasource.BankDataSource
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service//makes this bean/obj available at runtime
//can be injected as a dependency injection to other classes/objects
//calls DS'es, handle/maps exceptions, performs data transformations (bussiness logic)
class BankService (@Qualifier("SQLDataSource") private val dataSource:BankDataSource){

    fun getBanks():Collection<Bank> = dataSource.retrieveBanks()

    fun getBank(accountNumber: String):Bank = dataSource.retrieveBank(accountNumber)

    fun addBank(bank: Bank):Bank=dataSource.createBank(bank)

    fun updateBank (bank: Bank) = dataSource.updateBank(bank)

    fun removeBank (accountNumber: String) :Unit =dataSource.removeBank(accountNumber)
}