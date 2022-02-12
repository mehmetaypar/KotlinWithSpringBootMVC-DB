package bankapi.tutorial.springboot.ayparDeneme1.utility

import bankapi.tutorial.springboot.ayparDeneme1.model.BankEntity
import bankapi.tutorial.springboot.model.BankObject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankMapperTest{

    @Test
    fun `maps User to UserResponse using extension function`() {
        val mapper=BankMapper
        val p = BankEntity("12ed3",22.2,3,"hassan")
        val bankObject:BankObject = mapper.mapperBankEntityToBankObject(p)
        println(bankObject.toString())
 //       assertUserView(bankObject)
    }
}