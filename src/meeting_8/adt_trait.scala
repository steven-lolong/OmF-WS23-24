
// 5; Integer
// 5,5 ; Double/ Float/ Real
// 'a'; Charater
// "abc"; String
// false or true; 
// 5 + 3; expression

trait Exp
case class Value(n: Int) extends Exp
case class Plus(lhs : Exp, rhs : Exp) extends Exp
case class Mul(lhs : Exp, rhs : Exp) extends Exp
case class Minus(lhs : Exp, rhs : Exp) extends Exp

def evaluator(e: Exp) : Int = e match
	case Value(n) => n 
	case Plus(l, r) => evaluator(l) + evaluator(r)
	case Mul(l,r) => evaluator(l) * evaluator(r)
	case Minus(l,r) => evaluator(l) - evaluator(r)

// 5 + 3 === Plus(Value(5),Value(3))
val exp_case1 = Plus(Value(5),Value(3))

// ((5 + 3) + (6 + 2))
// Plus(Plus(5, 3), Plus(6, 2))

// ((5 + 3) * (6 - 2))
val exp_case2 = Mul(Plus(Value(5), Value(3)), Minus(Value(6), Value(2)))

