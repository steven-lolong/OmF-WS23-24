trait Monad [M[_]] :
	def unit [A] (a: A) : M[A]
	def >>= [A,B] (a:M[A], f: A => M[B]) : M[B] // this is bind
end Monad

type S[X] = X

object ComposeString extends Monad[S]:
	override def unit[A](a: A): S[A] = a
	override def >>=[A, B](a: S[A], f: A => S[B]): S[B] = f(a)
end ComposeString

def addNbN(s: String) = s + "\n b \n"
addNbN(" Hallo")

// monadic concat 
def monadicConcat(cs: Monad[S]) = cs.>>=(cs.>>=(" Hallo", addNbN), addNbN)
monadicConcat(ComposeString)