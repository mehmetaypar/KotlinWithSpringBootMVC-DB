package bankapi.tutorial.springboot.ayparDeneme1.model


import javax.persistence.*

@Table(name="banks_table")
@Entity
 class jpaBankEntity (
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false)//    @Column(name = "name", nullable = false)
    var accountNumber: String? = null,
    @Column( nullable = false)
    var trust: Double? = null,
    @Column( nullable = false)
    var transactionFee: Int? = null,
    @Column( nullable = false)
    var surname: String? = null

)


