package bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource

import bankapi.tutorial.springboot.ayparDeneme1.model.jpaBankEntity



import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface JpaBankRepository : JpaRepository <jpaBankEntity, String>,// : CrudRepository<jpaBankEntity, Long> {
    JpaSpecificationExecutor<jpaBankEntity> {
        fun findBySurname (surname:String): List<jpaBankEntity>

    //    fun updateBank(bank : jpaBankEntity): Boolean
}
