package bankapi.tutorial.springboot.ayparDeneme1.service.mapper

import bankapi.tutorial.springboot.ayparDeneme1.model.OzgurEntity
import bankapi.tutorial.springboot.model.OzgurOperationInput
import bankapi.tutorial.springboot.model.OzgurOperationObject
import org.springframework.stereotype.Service

@Service
class OzgurMapper {
    fun toOzgurOperationObject(ozgurEntity: OzgurEntity): OzgurOperationObject {
        return OzgurOperationObject(ozgurEntity.name, ozgurEntity.message)
    }

    fun toOzgurOperationEntity(ozgurOperationInput: OzgurOperationInput): OzgurEntity {
        return OzgurEntity.of(ozgurOperationInput.name, null)
    }

}