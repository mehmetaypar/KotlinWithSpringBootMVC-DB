package bankapi.tutorial.springboot.ayparDeneme1.datasource.MySQLBankDataSourceConnection

import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.sql.*


object MySQLBankDataSourceConnection { //MAKE THIS OBJ PRIVATE TO MySQLBankDataSource CLASS
                                            //

    private const val  url:String="jdbc:mysql://localhost:3306/banksdb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey"
    private const val user:String="root"
    private const val password:String="123456"
 val objMapper =jacksonObjectMapper()

    private val setConnection:Connection=  DriverManager.getConnection(url,
        user,
        password
    )
    val dbSttmnt:Statement = setConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)

    @JvmStatic//for testing
    fun connection(){

        try {
            val r:ResultSet = dbSttmnt.executeQuery("Select * from banks_table")
            r.next()
            println(r.getString("accountNumber")+"-"
                    +r.getString("accountNumber")+"-"
                   )
            println("aaaaaaaaaaaaaaaaaaaaa")
        }catch (e:SQLException){
            e.printStackTrace();
        }
    }
    
    fun getSQLListBanks (querry:String):Collection<Bank>{ //THROW EXCEPTIONS TO CONTROLLER

       val QuerrySent="Select * from banksdb.banks_table "+querry+";"
        println(QuerrySent)
        val bankList=mutableListOf(Bank("123456789",0.1,1)) //SOLVE THIS
        bankList.removeAt(0)
        try {
            val r = dbSttmnt.executeQuery(QuerrySent)

            while (r.next()){
            var tempBank=Bank(r.getString("accountNumber"),r.getDouble("trust"),r.getInt("transactionFee")) //SERIALISE THIS
            bankList.add(tempBank)
     }

        }catch (e:SQLException){
            e.printStackTrace();
        }
            return bankList //REMOVE THIS
    }

    fun getSQLSingleBank (querry:String):Bank{
        val QuerrySent="Select * from banks_table WHERE accountNumber="+querry+";"
        println(QuerrySent)
        try {
            val r = dbSttmnt.executeQuery(QuerrySent)
            r.next()
            return Bank(r.getString("accountNumber"),r.getDouble("trust"),r.getInt("transactionFee"))
        }catch (e:SQLException){
            e.printStackTrace();
        }
        return Bank("1234",0.1,1)
    }

    fun insertSQLSingleBank (bank: Bank):Bank{
        val QuerrySent="INSERT INTO banksdb.banks_table (`accountNumber`, `trust`, `transactionFee`) VALUES ('${bank.accountNumber}', '${bank.trust}', '${bank.transactionFee}');"
        println(QuerrySent)
        try {
            val r = dbSttmnt.executeUpdate(QuerrySent)
        }catch (e:SQLException){
            e.printStackTrace();
        }
        return bank
    }

    fun updateSQLSingleBank (bank: Bank):Bank{
        val QuerrySent="UPDATE banksdb.banks_table SET `accountNumber` = '${bank.accountNumber}', `trust` = '${bank.trust}', `transactionFee` = '${bank.transactionFee}' WHERE (`accountNumber` = '${bank.accountNumber}');"
        println(QuerrySent)
        try {
            val r = dbSttmnt.executeUpdate(QuerrySent)
        }catch (e:SQLException){
            e.printStackTrace();
        }
        return bank
    }

    fun deleteSQLSingleBank (querry:String):String{
        val QuerrySent="DELETE FROM banksdb.banks_table WHERE  accountNumber = '$querry';"//(`accountNumber` = '44');
        println(QuerrySent)
        try {
            val r = dbSttmnt.executeUpdate(QuerrySent)

        }catch (e:SQLException){
            e.printStackTrace();
        }
        return querry
    }




}