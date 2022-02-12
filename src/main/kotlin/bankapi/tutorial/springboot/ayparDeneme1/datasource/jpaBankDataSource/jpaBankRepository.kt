package bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource

//import bankapi.tutorial.springboot.ayparDeneme1.model.JpaBankEntity



import bankapi.tutorial.springboot.ayparDeneme1.model.BankEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository


@Repository
interface JpaBankRepository : JpaRepository <BankEntity, String>, JpaSpecificationExecutor<BankEntity> {
        fun findBySurname (surname:String): List<BankEntity>
    }

