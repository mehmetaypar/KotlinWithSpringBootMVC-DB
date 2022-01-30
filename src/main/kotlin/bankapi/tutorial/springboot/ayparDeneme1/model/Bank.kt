package bankapi.tutorial.springboot.ayparDeneme1.model

data class Bank ( val accountNumber:String, //default is public
             val trust:Double,
             val transactionFee: Int)


//data class already includes standart implementation of .equals .hashcode .toString
/*

{


/*create customizable constructor
    private val accountNumber:String
    //    get()=field  custumizable getter
    private val trust:Double
    private val transactionFee: Int
constructor(accountNumber:String,trust:Double,transactionFee: Int){
    this.accountNumber=accountNumber
    this.trust=trust
    this.transactionFee=transactionFee
}*/


 /* How getters usually done with var accountNumber var trust
    fun getAccountNumber (accountNumber:String){
        this.accountNumber=accountNumber
    }
    fun getTrust ():Double=trust
*/
}
*/
