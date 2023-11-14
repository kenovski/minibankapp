package example
import scala.io.StdIn._
import example.BAccounts._
import example.Collections._
import example.Pconn._
import example.Deposits._

object Menu {

	def printMenu(){

		println(""" Select An Option:
			1. Account Opening
			2. Deposits
			3. Withdrawals
			4. Transfers
			5. Balance Check
			6. Accounts Closure
			7. Quit """

		)


	}


	def mainmenu(){

		var option = 0

		do {

			printMenu()
			option = readInt()

			option match{

				case 1 => Collections.mycolls()
				case 2 => Deposits.deposits
				case 3 => println("Withdrawals")
				case 4 => println("Transfers")
				case 5 => println("Balance Check")
				case 6 => println("Accounts Closure")
				case 7 => println("Good Bye")
				case _ => println("Invalid Entry, Try Again")
			}
		} while(option != 5)


       mainmenu()
	}
}