package bankapi.tutorial.springboot.ayparDeneme1.datasource

import bankapi.tutorial.springboot.ayparDeneme1.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>

    fun retrieveBank( accountNumber:String): Bank

    fun createBank(bank: Bank):Bank

    fun updateBank(bank: Bank):Bank

    fun removeBank (accountNumber: String):Unit
}