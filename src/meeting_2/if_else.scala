import scala.io.StdIn._

def numberChecking() =
	val inputNum = readLine("Input a number: ")
	if inputNum.toInt % 2 == 0  then
		println("Your inputed number is even")
	else
		println("Odd")
