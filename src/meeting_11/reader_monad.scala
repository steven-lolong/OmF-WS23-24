import scala.collection.immutable
trait Monad [M[_]] :
	def unit [A] (a: A) : M[A]
	def >>= [A,B] (a:M[A], f: A => M[B]) : M[B] // this is bind
end Monad

// Int => Int => String 
def fRead(n: Int) : Int => String = (x: Int) => 
	print("fRead uses this env: " + x.toString() +  " for some purposes \n");
	n.toString()

// String => Int => Boolen
def gRead(s: String) : Int => Boolean = (x: Int) =>
	print("gRead uses this env: " + x.toString() +  " for some purposes \n");
	s == "7"

// Boolean => Int => Int
def hRead(s: Boolean) : Int => Int = (x: Int) =>
	print("hRead uses this env: " + x.toString() +  " for some purposes \n");
	if s then 7 + x else sys.error("it is not 14")


val res0 = fRead(7) // Int => String
val res1 = gRead("7")
val res2 = hRead(true)
// h(!g(f(8)))
// h . !g . f(8)

def clientCodeNewFun (env: Int) = hRead(gRead(fRead(7)(env))(env))(env)

// = >
// = > >
trait ReaderMonad[R] extends Monad[[A] =>> R => A]:
	override def unit[A](a: A): R => A = (_) => a
	override def >>=[A, B](a: R => A, f: A => R => B): R => B = r => f(a(r))(r)
end ReaderMonad

object ReaderMonad extends ReaderMonad[Int]

def clientReaderMonad(using rm: ReaderMonad[Int]) = (env: Int) => rm.>>=(fRead(8),
	(s: String) => rm.>>=(gRead(s), (b: Boolean) => hRead(!b)))(3)

def client1(using rm: ReaderMonad[Int]) = (env: Int) => rm.>>=(rm.unit(3), (i: Int) => fRead(i))(4)

clientReaderMonad(using ReaderMonad)(4)

