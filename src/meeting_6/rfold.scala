def rFoldTV1 [A](dList: List[A])(dIdent: A) (f: (A, A) => A) :A=
dList match
	case Nil => dIdent
	case (x :: xs) => f(x, rFoldTV1(xs)(dIdent)(f))

val exList = List(1,2)

rFoldTV1[Int](exList)(1)(_ * _)

// 1:
// 	case (1 :: (2,Nil)) => f(1, rFoldTV1((2,Nil))(1)(_ * _))
// 2: 
// 	case (2 :: (Nil)) => f(1, f(2, rFoldTV1((Nil))(1)(_ * _))	
// 3: 
// 	case Nil  => f(1, f(2, 1))
// 4:
// 	f(1,f(2,1)) => f (_ * _)
// 	(1 * (2 * 1))
// 	(1 * 2)
// 	2