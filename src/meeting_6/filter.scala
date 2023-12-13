def filter (dList: List[Int])(fFilter: Int => Boolean) : List[Int] = dList match 
	case Nil => Nil
	case (x :: xs) => fFilter(x) match
		case true => x :: filter(xs)(fFilter)
		case false => filter(xs)(fFilter)

val exList = List(1,2,3,4,5,6)
val dEven = filter(exList)((a) => (a % 2) match 
	case 0 => true
	case _ => false)

def filter2 [A] (dList: List[A])(fFilter: A => Boolean) : List[A] = dList match 
	case Nil => Nil
	case (x :: xs) => fFilter(x) match
		case true => x :: filter2(xs)(fFilter)
		case false => filter2(xs)(fFilter)

val dEven2 = filter2(exList)((a) => (a % 2) match 
	case 0 => true
	case _ => false)



