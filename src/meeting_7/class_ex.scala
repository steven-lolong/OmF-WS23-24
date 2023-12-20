// class Dog:
// 	var eyeColor : String = ""
// 	def ability() : String = "walk"
// end Dog

// var dogA = Dog()
// var dogB = Dog()


class Dog(ability_ : String):
	var abili_ = ability_
	var eyeColor : String = ""
	def ability() : String = abili_
end Dog

var dogA = Dog("walk")
var dogB = Dog("Jump")

class Cat(var eyeColor: String, private var color: String)

var catA = Cat("blue", "black")
println(catA.eyeColor)
// println(catA.color)

class Snake(var eyeColor: String, skinColor : String)

class Cobra(var length: Int) extends Snake("black", "marble")

var babyCobra = new Cobra(5)