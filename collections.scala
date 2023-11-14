package example
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import example.Helpers._
import BAccounts._
import scala.io.StdIn._
object Collections {

	def mycolls():Unit = {

		println("Open Account For Customer Name")
		println("*********************************")
      println("Enter Date")
		val date = readLine()
		println("Enter Customer Name")
      val customer = readLine()
      println("Enter Account Number")
      val accountno = readLine()
		println("Enter Email")
		val email = readLine()
      println("Enter BVN")  
		val bvn = readLine()
		println("Enter Opening Balance")
		val opbal = readDouble()

        

		val details = BAccounts.Accounts(date,customer,accountno,email,bvn,opbal,opbal)
			// Use a Connection String
     val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

// or provide custom MongoClientSettings

   val database: MongoDatabase = mongoClient.getDatabase("bankapp")
   val collection: MongoCollection[Document] = database.getCollection("accounts");
//val colls: MongoCollection[Document] = database.getCollection("users");
   val doc: Document = Document("date" -> details.date, "customername" -> details.customer,"accountno"->details.accountno,
                             "email" -> details.email,"bvn" -> details.bvn,"opbal"-> details.opbal,"balaance"-> details.balance)

//val docuser:Document = Document("username"->"suzzy","password"->"mookie","access"->"admin")

//collection.insertOne(doc)

val observable: Observable[Completed] = collection.insertOne(doc)
//val insertObservable: Observable[Completed] = colls.insertOne(docuser)



observable.subscribe(new Observer[Completed] {

  override def onNext(result: Completed): Unit = println("Inserted")

  override def onError(e: Throwable): Unit = println("Failed")

  override def onComplete(): Unit = println("Completed")
})

}
 //mycolls()
}