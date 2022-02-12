package bankapi.tutorial.springboot.ayparDeneme1.utility

import bankapi.tutorial.springboot.ayparDeneme1.model.BankEntity
import bankapi.tutorial.springboot.model.BankInput
import bankapi.tutorial.springboot.model.BankObject
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kotlin.reflect.full.memberProperties

//entity to obj
//input to entity serialization
object BankMapper {
    val mapper = jacksonObjectMapper()

    fun mapperBankEntityToBankObject(bankEntity: BankEntity):BankObject{
        return BankObject( bankEntity.accountNumber, bankEntity.trust!!.toBigDecimal() ,bankEntity.transactionFee,bankEntity.surname)
    }

    fun mapperBankObjectToBankEntity(bankObject: BankObject):BankEntity {
        return BankEntity(bankObject.accountNumber,bankObject.trust!!.toDouble(),bankObject.transactionFee,bankObject.surname)
    }
    fun mapperBankInputToBankEntity(bankInput: BankInput):BankEntity {
        return BankEntity(bankInput.accountNumber,bankInput.trust!!.toDouble(),bankInput.transactionFee,bankInput.surname)
    }

    fun mapperBankEntityToBankInput(bankEntity: BankEntity):BankInput{
        return BankInput( bankEntity.accountNumber, bankEntity.trust!!.toBigDecimal() ,bankEntity.transactionFee,bankEntity.surname)
    }
/*
    fun BankEntity.mapperBankEntityToBankObject() = with(::BankObject) {
        val propertiesByName=
            BankEntity::class.memberProperties.associateBy { it.name }
            callBy(parameters.associate { parameter ->
                parameter to when (parameter.name) {
                    BankObject::surname.name -> surname
                    BankObject::accountNumber.name -> accountNumber
                    BankObject::trust.name -> trust
                    BankObject::transactionFee.name -> transactionFee
                    else -> propertiesByName[parameter.name]?.get(this@mapperBankEntityToBankObject)
                }
        })
    }
 */
}