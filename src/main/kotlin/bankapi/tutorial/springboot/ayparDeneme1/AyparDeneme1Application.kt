package bankapi.tutorial.springboot.ayparDeneme1

import bankapi.tutorial.springboot.ayparDeneme1.datasource.MySQLBankDataSourceConnection.MySQLBankDataSourceConnection
import bankapi.tutorial.springboot.ayparDeneme1.model.Bank
import bankapi.tutorial.springboot.ayparDeneme1.swaggerconfig.SwaggerConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AyparDeneme1Application

fun main(args: Array<String>) {
	//SwaggerConfig()
//MySQLBankDataSourceConnection.connection()
//  println(	MySQLBankDataSourceConnection.getSQLSingleBank("222").toString())
//	println(	MySQLBankDataSourceConnection.getSQLListBanks("Where accountNumber<100").toString())
//	println(	MySQLBankDataSourceConnection.insertSQLSingleBank(Bank("111",3.3,4)).toString())
//	println(	MySQLBankDataSourceConnection.deleteSQLSingleBank("111"))
//	println(	MySQLBankDataSourceConnection.updateSQLSingleBank(Bank("121",3.8,4)).toString())

	runApplication<AyparDeneme1Application>(*args)
}
