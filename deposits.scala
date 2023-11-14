package example
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import example.Helpers._
import BAccounts._
import scala.io.StdIn._
import example.Helpers._
//import scala.concurrent.Future
import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._


object Deposits{

	def deposits{

	//println("Open Account For Customer Name")
	//println("*********************************")
	
	//println("Enter Account Number")  
	//val accountno = readLine()
	//println("Enter Amount To Deposit")
	//val opbal = readDouble()
	//println("thats all")

	    val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

// or provide custom MongoClientSettings

   val database: MongoDatabase = mongoClient.getDatabase("bankapp")
   val collection: MongoCollection[Document] = database.getCollection("accounts");
   println("ALL BANK ACCOUNTS")
   println("-----------------------------------")
   collection.find().printResults()
   println("-----------------------------------")

   //println("Open Account For Customer Name")
	println("*********************************")
	
	println("Enter Account Number")  
	val accountno:String = readLine()
	println(accountno)

   //collection.find(equal("accountno",accountno)).printHeadResult()

   
   val fx = Future(collection.find(equal("accountno",accountno)).printHeadResult())
   
   Await.result(fx, 1.second)
   println(fx)

   
   
   println("Hit Enter To Continue.....................")
   readLine()
   
}
}