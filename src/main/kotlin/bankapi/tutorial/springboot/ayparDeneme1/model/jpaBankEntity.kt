package bankapi.tutorial.springboot.ayparDeneme1.model

import javax.persistence.*

@Table(name="banksdb")
@Entity
data class jpaBankEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountNumber", nullable = false)
    val accountNumber: String? = null,
//    @Column(name = "trust", nullable = false)
    val trust: Double? = null,
 //   @Column(name = "name", nullable = false)
    val transactionFee: Int? = null,


)
