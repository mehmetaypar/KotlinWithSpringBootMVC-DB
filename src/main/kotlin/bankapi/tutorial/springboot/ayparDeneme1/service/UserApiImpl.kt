package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.api.UserApiService
import bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource.JpaBankRepository
import bankapi.tutorial.springboot.model.*
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice

@Service
@ControllerAdvice
class UserApiImpl(val jpaBankRepository: JpaBankRepository): UserApiService  {
    override fun deleteBankById(id: String): DeletedMessage {
        TODO("Not yet implemented")
    }

    override fun getAllBanks(): List<JpaBankEntity> {
        TODO("Not yet implemented")
    }

    override fun getBankById(id: String): JpaBankEntity {
        TODO("Not yet implemented")
    }

    override fun getBanksBySurname(surname: String): JpaBankEntity {
        TODO("Not yet implemented")
    }

    override fun postBank(inlineObject1: InlineObject1): CreatedMessage {
        TODO("Not yet implemented")
    }

    override fun putBank(inlineObject: InlineObject): CreatedMessage {
        TODO("Not yet implemented")
    }

}