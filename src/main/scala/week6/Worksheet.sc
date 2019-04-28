val array = Array(1, 2, 4, 5)
array map (x => x * 2)

val s = "Hello World"
s filter (e => e.isUpper)

val odds = Array(1, 3, 5, 7, 9)
val exists = odds.exists(e => e % 2 == 0)
val all = odds.forall(e => e % 2 != 0)

val zipPair = List(1,2,3) zip s
val unzip = zipPair.unzip
val (ints,chars) = unzip
println(ints)
println(chars)

s map (c => List(".",c))
s flatMap  (c => List(".",c))