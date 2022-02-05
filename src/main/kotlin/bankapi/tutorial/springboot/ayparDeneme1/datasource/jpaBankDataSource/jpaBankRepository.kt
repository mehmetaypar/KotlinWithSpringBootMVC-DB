package bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource

import bankapi.tutorial.springboot.ayparDeneme1.datasource.BankDataSource
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import bankapi.tutorial.springboot.ayparDeneme1.model.jpaBankEntity



import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository


@Repository //HOW TO İMPLEMENT OVERRİDE GETBANKS  ON BankDataSource
interface JpaBankRepository : JpaRepository <jpaBankEntity, String>,// : CrudRepository<jpaBankEntity, Long> {
    JpaSpecificationExecutor<jpaBankEntity> ,BankDataSource{
        fun findBySurname (surname:String): List<jpaBankEntity>
    }

