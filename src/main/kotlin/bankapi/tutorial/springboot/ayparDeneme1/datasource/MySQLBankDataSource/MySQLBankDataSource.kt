package bankapi.tutorial.springboot.ayparDeneme1.datasource.MySQLBankDataSource

import bankapi.tutorial.springboot.ayparDeneme1.datasource.BankDataSource
import bankapi.tutorial.springboot.ayparDeneme1.datasource.MySQLBankDataSourceConnection.MySQLBankDataSourceConnection
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import org.springframework.stereotype.Repository

//import  bankapi.tutorial.springboot.ayparDeneme1.datasource.MySQLBankDataSource


@Repository("SQLDataSource")
class MySQLBankDataSource:BankDataSource {





    override fun retrieveBanks(): Collection<Bank> {
       return MySQLBankDataSourceConnection.getSQLListBanks("")
    }

    override fun retrieveBank(accountNumber: String): Bank {
        return MySQLBankDataSourceConnection.getSQLSingleBank(accountNumber)
    }

    override fun createBank(bank: Bank): Bank {
        return MySQLBankDataSourceConnection.insertSQLSingleBank(bank)
    }

    override fun updateBank( bank: Bank): Bank {
        return MySQLBankDataSourceConnection.updateSQLSingleBank( bank)
    }

    override fun removeBank(accountNumber: String) {
MySQLBankDataSourceConnection.deleteSQLSingleBank(accountNumber)
    }


}