import scala.collection.immutable
trait Monad [M[_]] :
	def unit [A] (a: A) : M[A]
	def >>= [A,B] (a:M[A], f: A => M[B]) : M[B] // this is bind
end Monad


def fCPS[R](n: Int) : (String => R) => R = (f: String => R) => f(n.toString())

def gCPS[R](x: String): (Boolean => R) => R = (f: Boolean => R) => f(x == "7")

def hCPS[R](x: Boolean): (Int => R) => R = (f: Int => R) => if x then f(7) else sys.error("it is not 7")

trait KontMonad[R] extends Monad[[A] =>> (A => R) => R ]:
	type Cont[X] = (X => R) => R

	override def unit[A](a: A): (A => R) => R = k => k(a)
	override def >>=[A, B](a: (A => R) => R, 
	f: A => (B => R) => R): 
		(B => R) => R = k => a(m => f(m) (k))

end KontMonad

object KontInt extends KontMonad[Int]

def km_e1[A](m: KontMonad[A]) = m.>>=(m.unit(7), (i: Int) => fCPS(i))

// m.unit(7) >>> (7 => R) => R //a
// f >>> (i: Int) => fCPS(i) // (String => R) => R 
// Int => (String => R) => R

def km_e2[A](m: KontMonad[A]) = 
	m.>>=(fCPS(7), (x: String) =>
		m.>>=(gCPS(x), (b: Boolean) => hCPS(b)))

km_e2(KontInt)(x => x + 3)

def fA(s: String) : String = "hai " + s
def fB(s: String) : Int = s.toInt + 1

// val eString = fCPS[String](7)
// eString(fA)

// val eInt = fCPS[Int](7)
// eInt(fB)

