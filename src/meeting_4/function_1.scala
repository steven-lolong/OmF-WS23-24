def multiply (fstNum: Int, sndNum: Int) : Int = 
    val returnValue = fstNum * sndNum
    returnValue

val nine = multiply(3,3)

def idFun [A] (a: A) : A = a 
val nineIsNine = idFun(9) //9

val mulFun = idFun(multiply(3,3)) //9

idFun [Int] ('9')
// def idFun (a : Int) : Int = a

// idFun [Int] ("Hello")
idFun [Character] ('9')

// def typeVar [A, B] (a: A) : B = a

// typeVar[Character, Int] ('9')
// typeVar[Int, Int] (9)

/* c style
int abc(int b) {
    return b;
}

void abc(int b) {

}
*/

def multThenSquare(a: Int, b: Int) : Int =
    def squareIt(x: Int) : Int =
        x * x
    
    squareIt(a * b)

val _36 = multThenSquare(2,3)