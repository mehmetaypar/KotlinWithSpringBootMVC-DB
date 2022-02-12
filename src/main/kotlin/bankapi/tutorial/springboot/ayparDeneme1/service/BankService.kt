package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource.JpaBankRepository
import bankapi.tutorial.springboot.ayparDeneme1.model.BankEntity
import org.springframework.stereotype.Service

//also
//let
//else throw

@Service//makes this bean/obj available at runtime
//can be injected as a dependency injection to other classes/objects
//calls DS'es, handle/maps exceptions, performs data transformations (bussiness logic)
class BankService (val jpaBankRepository: JpaBankRepository){//,val dataSource: BankDataSource){
// TODO: 2/5/2022 EMPTY HERE AND Carry bussiness logic to İMPLEMENT BankDataSource:jpaBankRepository FUNCTİONS OVERLOAD
    fun getBank(accountNumber: String): BankEntity {
    TODO()
}//= jpaBankRepository.getById(accountNumber)

    fun getBankBySurname(surname: String): List<BankEntity> {
        TODO()
    }//= jpaBankRepository.findBySurname(surname)

    fun getBanks():List<BankEntity> {
        TODO()
    }//= jpaBankRepository.findAll()

    fun addBank(bank : BankEntity):BankEntity{
        TODO()
    }
    /*{
        val checker: Optional<JpaBankEntity> =
            bank.accountNumber?.let { jpaBankRepository.findById(it) } as Optional<JpaBankEntity>
        if (checker.isPresent){
            throw  IllegalArgumentException ("Bank with accountNumber ${bank.accountNumber} already exists")
        }else{
        jpaBankRepository.save(bank)}
    return bank
}

     */

    fun updateBank (bank : BankEntity):BankEntity   {
        TODO()
    }
/*{
    val checker: Optional<JpaBankEntity> =
        bank.accountNumber?.let { jpaBankRepository.findById(it) } as Optional<JpaBankEntity>
    if (checker.isEmpty){
        throw  NoSuchElementException ("Bank with accountNumber ${bank.accountNumber} does not exists")
    }else{
        jpaBankRepository.save(bank)
    }
    return bank
}

 */

fun removeBank (accountNumber : String)   {
        TODO()
    }
/*{
try {
    val checker: JpaBankEntity? = jpaBankRepository.getById(accountNumber)
    if (checker != null) {
        jpaBankRepository.delete(checker)
    }

} catch (e: Exception) {
    throw  NoSuchElementException("Bank with accountNumber $accountNumber does not exists")
}

}

 */
}


