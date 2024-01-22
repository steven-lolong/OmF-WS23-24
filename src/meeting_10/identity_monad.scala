trait Monad [M[_]] :
	def unit [A] (a: A) : M[A]
	def >>= [A,B] (a:M[A], f: A => M[B]) : M[B] // this is bind
end Monad

type Id[X] = X
object IdMonad extends Monad[Id]:
	override def unit[A] (a:A) : Id[A] = a
	override def >>= [A,B] (a:Id[A], f: A => Id[B]) : Id[B] = f(a)
end IdMonad 

def idF_1(i : Int) = i
def idF_2(i : Char) = i
def idMonadTest_1(id: Monad[Id]) = id.>>=(3,idF_1)
def idMonadTest_2(id: Monad[Id]) = id.>>=('2',idF_2)
