package bankapi.tutorial.springboot.ayparDeneme1.datasource.mockDataSource

import org.assertj.core.api.Assertions// good lib
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest {

    private val MockDataSource:MockBankDataSource= MockBankDataSource()

@Test
fun `should provide a not empty collection of banks` () {
    // given==arrange

    //when==act
val banks=MockDataSource.retrieveBanks()
    //then==assert
Assertions.assertThat(banks).isNotEmpty
}
@Test
    fun `should provide a collection of +2 banks` () {
        // given==arrange

        //when==act
        val banks = MockDataSource.retrieveBanks()
        //then==assert
        Assertions.assertThat(banks.size).isGreaterThanOrEqualTo(2)
    }

    @Test
    fun `should provide some mock data` () {
        // given==arrange

        //when==act
        val banks = MockDataSource.retrieveBanks()

        //then==assert
        Assertions.assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        Assertions.assertThat(banks).anyMatch { it.trust != 0.0 }
        Assertions.assertThat(banks).allMatch { it.transactionFee != 0 }

    }

}