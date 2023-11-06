var yA = for i <- 1 to 10 yield i

def foo(n: Int, v: Int) = 
	for i <- 0 until n
	j <- 0 until n if i + j == v 
	yield i+j

