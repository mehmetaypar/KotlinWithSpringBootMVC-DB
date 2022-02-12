package bankapi.tutorial.springboot.ayparDeneme1.model


import javax.persistence.*

@Table(name="banks_table")
@Entity
 class BankEntity (
    @Id
    @Column( nullable = false)
    var accountNumber: String? = null,
    @Column( nullable = false)
    var trust: Double? = null,
    @Column( nullable = false)
    var transactionFee: Int? = null,
    @Column( nullable = false)
    var surname: String? = null

)


