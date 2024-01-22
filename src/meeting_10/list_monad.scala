import scala.collection.immutable
trait Monad [M[_]] :
	def unit [A] (a: A) : M[A]
	def >>= [A,B] (a:M[A], f: A => M[B]) : M[B] // this is bind
end Monad

object ListMonad extends Monad[List]:
	override def unit[A](a: A): List[A] = List(a)
	override def >>=[A, B](a: List[A], f: A => List[B]): List[B] = a.flatMap(f)
end ListMonad

def fList(n: Int) : List[String] = List(n.toString())
def gList(s: String) : List[Boolean] = List(s == "y")
def hList(b: Boolean) : List[Int] = if (b) then List(7) else List()

def elCode = fList(7).map(x => gList(x)).flatten.map(b => hList(b)).flatten

def monadicStyle_1 (m : Monad[List]) =m.>>=(m.>>=(fList(7), (s: String) => gList(s)), (b: Boolean) => hList(b))

monadicStyle_1(ListMonad)