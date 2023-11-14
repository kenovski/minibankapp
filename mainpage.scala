package example
import scala.io.StdIn._
import example.BAccounts._
import example.Collections._
import example.Pconn._
object mainPage{
    //connection to mongodb instance
    //Pconn.myconn()
    Collections.mycolls()

	def mpage(): Unit = {

         println("WELCOME TO JUX BANK, SELECT OPERATION TO CARRY OUT")
          val xp:Int = readInt
          println("1): Account Opening")
          println("2): Deposits ")
          println("3): Withdrawals")
          xp match{

          	case 1 => println("Account Opening")
          	case 2 => println("Deposits")
          	case 3 => println("Withdrawals")
          	case 4 => println("Balance Check")
          	case _	 => println("Invalid Entry")
          }
		


	}
}