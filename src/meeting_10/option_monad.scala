trait Monad [M[_]]:
	def unit [A] (a: A) : M[A]
	def >>= [A,B] (a:M[A], f: A => M[B]) : M[B] // this is bind
end Monad

object OptionMonad extends Monad[Option]:
	override def unit[A](a: A): Option[A] = Some(a)
	override def >>=[A, B](a: Option[A], f: A => Option[B]): Option[B] = a match
		case None => None
		case Some(x) => f(x)
end OptionMonad 

def fop (i: Int) : Option[String] = if (i < 100) Some(i.toString()) else None
def gop (s: String): Option [Boolean] = Some(s == "7")
def hop (b: Boolean) : Option[Int] = if (b) Some (7) else None

// programming style 
// hop(gop(fop(27)))
// math 
// hop . gop . fop 27

def cl2Code (m: Monad[Option]) = m.>>=(fop(7), (x: String) => m.>>=(gop(x + "x"), (y: Boolean) => m.unit(!y)))

// val v : Option[Boolean] 