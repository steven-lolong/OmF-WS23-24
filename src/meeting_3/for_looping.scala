
def triangleStar(): Unit =
	for(a <- 1 to 5) do 
		for(b <- 1 to 5) do
			if(b <= a) then 
				print("*")
		println("")

def test1() = 
	for (i <- 1 to 10) do
		if(i % 2 == 0) then
			println(i)


def test2() = 
	for 
		i <- 1 to 10
		if i % 2 == 0
	do
		println(i)

def test3() = 
	for 
		i <- 1 to 10
		j <- 1 to 10
		if i % 2 == 0
	do
		println(j + i)

def test4() = 
	for i <- 1 to 10 
		if i % 2 == 0
		if i > 6 
	do
		println(i)


def test5() =
	for
		x <- 1 to 10
	do
		println(x)
		for
			y <- List("Hello", "World")
		do
			println(y)


def test6() =
	for
		x <- 1 to 10
		y <- List("Hello", "World")
	do
		println(x)
		println(y)