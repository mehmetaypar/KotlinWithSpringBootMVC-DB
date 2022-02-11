package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.api.OzgurApiService
import bankapi.tutorial.springboot.ayparDeneme1.model.OzgurEntity
import bankapi.tutorial.springboot.ayparDeneme1.service.mapper.OzgurMapper
import bankapi.tutorial.springboot.model.OzgurOperationInput
import bankapi.tutorial.springboot.model.OzgurOperationObject
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ControllerAdvice

@Service
@ControllerAdvice
class OzgurApiImpl(
    val ozgurMapper: OzgurMapper
    ): OzgurApiService {

    override fun postOperation(ozgurOperationInput: OzgurOperationInput): OzgurOperationObject {
        // ozgurRepo.getById(ozgurOperationInput.id)
        val myEntity = OzgurEntity.of(ozgurOperationInput.name, "this is my message")
        return ozgurMapper.toOzgurOperationObject(myEntity)
    }

    override fun putOperation(ozgurOperationInput: OzgurOperationInput): OzgurOperationObject {
        // ozgurRepo.getById(ozgurOperationInput.id)
        val myEntity = OzgurEntity.of(ozgurOperationInput.name + " updated", "this is my message")
        // ozgurRepo.save(myEntity)
        return ozgurMapper.toOzgurOperationObject(myEntity)
    }
}