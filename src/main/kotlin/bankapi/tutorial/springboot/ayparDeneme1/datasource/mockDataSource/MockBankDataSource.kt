package bankapi.tutorial.springboot.ayparDeneme1.datasource.mockDataSource

import bankapi.tutorial.springboot.ayparDeneme1.datasource.BankDataSource
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException

@Repository("MockDatasource") //marks this class as a spring boot bean ; Initializes this object/bean in run time
//defines its a repo: which has other implications.. (retrieves , stores data and access entities)
class MockBankDataSource :BankDataSource {

    val banks= mutableListOf(Bank("123456789",0.1,1),
        Bank("223456789",0.1,3),
        Bank("323456789",6.0,1))

    override fun retrieveBanks(): Collection<Bank> =banks

   override fun retrieveBank( accountNumber:String): Bank {
return banks.firstOrNull(){it.accountNumber == accountNumber}
    ?: throw NoSuchElementException("could not find a bank with account number $accountNumber")
   // Bank(accountNumber,0.1,3)
   }

    override fun createBank(bank: Bank): Bank {
        if (banks.any{it.accountNumber==bank.accountNumber}){
            throw IllegalArgumentException ("Bank with accountNumber ${bank.accountNumber} already exists")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
     val currentbank= banks.firstOrNull(){it.accountNumber== bank.accountNumber}?:throw NoSuchElementException ("could not find a bank with account number $bank.accountNumber")
        banks.remove(currentbank)
        banks.add(bank)
        return  bank
    }

    override fun removeBank(accountNumber: String):Unit {
        val currentbank= banks.firstOrNull(){it.accountNumber == accountNumber}?:throw NoSuchElementException ("could not find a bank with account number $accountNumber")

        banks.remove(currentbank)
    }

}