
val add = (a : Int, b : Int) => a + b
    //  _ lambda 

val seven = add(3, 4)

// FcF
def fCF1 (a: Int) = a + 3

// this is not a FcF, because it return another function
def hOF2 (a: Int) = (b : Int) => a + b


def pow(n: Int, pw: Int) : Int = pw match
    case 0 => 1
    case x if x < 0 => sys.error("It can only be raised to the power of positive numbers.")
    case 1 => n
    case x if x > 1 => n * pow(n, (pw-1))


// Higher order function
def hofArithOperator(a: Int, b: Int, f: (Int, Int) => Int) : Int = f(a,b)

def addOptr(a: Int, b: Int) : Int = a + b
def multOptr(a: Int, b: Int) : Int = a * b
def subtrOptr(a: Int, b: Int) : Int = a - b
def divOptr(a: Int, b: Int) : Int = b match
    case 0 => sys.error("arithmetic error, devide by zero")
    case _ => a /b 

val twoPlusThree = hofArithOperator(2,3,addOptr)
val twoPlusThree_ = hofArithOperator(2,3, (a,b) => a + b)

val twoMultThree = hofArithOperator(2,3,multOptr)
val twoMultThree_ = hofArithOperator(2,3, (a,b) => a * b)


def urlBuilder (ssl : Boolean , domainName : String) : (String ,String) => String =  
    val schema = if ssl then "https://" else "http://"
    (endPoint : String, query: String) => s"$schema$domainName/$endPoint?$query"

val domName = "www.uni-tuebingen.de"
def getUrl = urlBuilder(true, domName)
val endPoint = "users"
val query = "id=1"
val url = getUrl(endPoint, query)
