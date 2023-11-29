def abc (a: Int, b: Int) = a + b 

def abc_curr (a: Int) (b: Int) = a + b

val a = abc(3, _) // error
// val a = abc(3, 2)

val a_curr  = abc_curr(3)

// val a_curr == def abc_curr(b : Int) = 3 + b
// val uncurr2curr = abc(3, _) 
// val uncurr2curr = abc(_ , 5)