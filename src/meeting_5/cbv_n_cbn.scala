def loop : Int = loop


def exCbV (a: Int, b: Int) : Int = a 
def exCbN (a: Int, b: => Int) : Int = a

// val cbv = exCbV(4, loop)