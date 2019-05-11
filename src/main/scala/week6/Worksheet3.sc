val capitalsOfCountry = Map("India" -> "Delhi", "Australia" -> "Canberra", "USA" -> "Washington")

//capitalsOfCountry("US")
capitalsOfCountry get "US"
capitalsOfCountry get "USA"

def showCapital(country: String): String = {
  capitalsOfCountry get country match {
    case None => "No mapping country found !"
    case Some(capital) => capital
  }
}
showCapital("US")
showCapital("India")

val fruits = List("apple", "orange", "pineapple", "pear")
fruits sortWith ((f1, f2) => f1.length < f2.length)
fruits sortWith (_.length < _.length)

fruits sorted

fruits map (f => f.head)
fruits groupBy (f => f.head)
fruits groupBy (_.head)

val nums = List(1, 2, 3, 45, 6, 7)
nums.foldLeft(0)((n1, n2) => n1 + n2)

"ABC".toList :: "ABC".toList

for {
  i <- 1 to 3;
  j1 <- 4 to 6
} yield (i,j1)

1 :: List()