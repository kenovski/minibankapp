package example
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import example.Helpers._
object Conn{

	def connect():Unit = {

	// Use a Connection String
val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

// or provide custom MongoClientSettings

val database: MongoDatabase = mongoClient.getDatabase("bankapp")

//val collection: MongoCollection[Document] = database.getCollection("accounts");
val colls: MongoCollection[Document] = database.getCollection("users");

//val doc: Document = Document("date" -> "2023-04-01", "customername" -> "Kenneth St.Francis",
                             //"email" -> "eze@gmail.com","bvn" -> "234567899999","opbal"-> 0.0,"balaance"-> 0.0)

val docuser:Document = Document("username"->"suzzy","password"->"mookie","access"->"admin")

//collection.insertOne(doc)

//val observable: Observable[Completed] = collection.insertOne(doc)
val insertObservable: Observable[Completed] = colls.insertOne(docuser)



insertObservable.subscribe(new Observer[Completed] {

  override def onNext(result: Completed): Unit = println("Inserted")

  override def onError(e: Throwable): Unit = println("Failed")

  override def onComplete(): Unit = println("Completed")
})


//insertObservable.subscribe(new Observer[Completed] {

  //override def onNext(result: Completed): Unit = println("Inserted")

  //override def onError(e: Throwable): Unit = println("Failed")

  //override def onComplete(): Unit = println("Completed")
//})


}
}