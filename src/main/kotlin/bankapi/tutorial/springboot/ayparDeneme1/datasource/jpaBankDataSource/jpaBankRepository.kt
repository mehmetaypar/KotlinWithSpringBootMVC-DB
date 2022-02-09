package bankapi.tutorial.springboot.ayparDeneme1.datasource.jpaBankDataSource

import bankapi.tutorial.springboot.ayparDeneme1.model.jpaBankEntity



import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository


@Repository
interface JpaBankRepository : JpaRepository <jpaBankEntity, String>, JpaSpecificationExecutor<jpaBankEntity> {
        fun findBySurname (surname:String): List<jpaBankEntity>
    }

