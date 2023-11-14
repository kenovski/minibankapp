package example
import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import example.Helpers._
object Pconn {

	def myconn():Unit = {

			// Use a Connection String
         val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

         // or provide custom MongoClientSettings

         val database: MongoDatabase = mongoClient.getDatabase("bankapp")

         val collection: MongoCollection[Document] = database.getCollection("accounts")

         println("connected to database")
	}
}