package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.api.UserApiService
import bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource.JpaBankRepository
import bankapi.tutorial.springboot.ayparDeneme1.model.BankEntity
import bankapi.tutorial.springboot.model.*
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice


//Delete  \springboot\ayparDeneme1\model\BankEntity.kt
//Delete Bankservice
@Service
@ControllerAdvice
class UserApiImpl(val jpaBankRepository: JpaBankRepository): UserApiService {
    override fun deleteBankById(id: String): DeletedMessage {
        TODO("Not yet implemented")
    }

    override fun getAllBanks(): List<BankObject> {
        TODO("Not yet implemented")
    }

    override fun getBankById(id: String): BankObject {
        TODO("Not yet implemented")
    }

    override fun getBanksBySurname(surname: String): List<BankObject> {
        TODO("Not yet implemented")
    }

    override fun postBank(bankInput: BankInput): CreatedMessage {
        TODO("Not yet implemented")
    }

    override fun putBank(bankInput: BankInput): CreatedMessage {
        TODO("Not yet implemented")
    }


}