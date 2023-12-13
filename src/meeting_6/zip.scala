def zipIt[A,B](a: List[A])(b: List[B]) : List[(A,B)] = (a,b) match
	case (Nil, _) => Nil case (_, Nil) => Nil
	case ((x :: xs), (y :: ys)) => (x,y) :: zipIt(xs)(ys)

val listA = List.range(1,5) 
val listB = List.range(4,7)
val listC = List.range(4,9)

zipIt[Int,Int] (listA)(listB)
zipIt (listA)(listB)
zipIt (listA)(listC)