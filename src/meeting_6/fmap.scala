def fMap(dList: List[Int])(fOptr:(Int) => Int) : List[Int] = dList match
	case Nil => Nil
	case (x :: xs) => fOptr(x) :: fMap(xs)(fOptr)

val exList = List(1,2,3,4,5)

fMap(exList)((a) => a + 2)

// (x = 1 :: (2,3,4,5)) ==> ((1) => 1 + 2) :: (fMap(2,3,4,5)((a) => a + 2))
// 				==> 3 :: ((2) ==> 2 + 2) :: (famp (3,4,5) ()((a) => a + 2)))
// 				... 
// 				==> 3 :: 4 :: 5 :: 6 :: 7 :: Nil
// 				==> (3,4,5,6,7)

def fMapV [A, B](dList: List[A])(fOptr:(A) => B) : List[B] = dList match
	case Nil => Nil
	case (x :: xs) => fOptr(x) :: fMapV(xs)(fOptr)

