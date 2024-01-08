enum Exp:
	case Value(n: Int) extends Exp
	case Plus(lhs: Exp, rhs: Exp) extends Exp
	case Mul(lhs: Exp, rhs: Exp) extends Exp
	case Minus(lhs: Exp, rhs: Exp) extends Exp
end Exp

// import Exp._ 

def evaluator(e: Exp) : Int = e match
	case Exp.Value(n) => n 
	case Exp.Plus(l, r) => evaluator(l) + evaluator(r)
	case Exp.Mul(l,r) => evaluator(l) * evaluator(r)
	case Exp.Minus(l,r) => evaluator(l) - evaluator(r)

// 5 + 3 === Plus(Value(5),Value(3))
val exp_case1 = Exp.Plus(Exp.Value(5),Exp.Value(3))

// ((5 + 3) + (6 + 2))
// Plus(Plus(5, 3), Plus(6, 2))

// ((5 + 3) * (6 - 2))
val exp_case2 = Exp.Mul(Exp.Plus(Exp.Value(5), Exp.Value(3)), Exp.Minus(Exp.Value(6), Exp.Value(2)))