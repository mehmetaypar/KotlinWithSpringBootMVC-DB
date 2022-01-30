package bankapi.tutorial.springboot.ayparDeneme1.service

import bankapi.tutorial.springboot.ayparDeneme1.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BankServiceTest{
    private val dataSource:BankDataSource=  mockk(relaxed=true)
//every and verify are needed for mock objects
    private val bankService= BankService(dataSource)

    @Test
    fun `should call ist datasource to retrieve Banks` () {
        // given==arrange
        //checks every  mock OBJ that returns emptyList
        //if we dont care what it returns then use mockk(relaxed=true)
        //every { dataSource.retrieveBanks() } returns emptyList()
        //when==act
         bankService.getBanks()
        //then==assert
        //checks if those did called,called only once
        verify(exactly = 1) { dataSource.retrieveBanks() }

    }
}