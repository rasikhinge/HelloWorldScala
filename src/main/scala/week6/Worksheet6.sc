 val multiplier = 2

implicit def value = {
  4
}


def multiply(implicit value: Int) = {
  value * multiplier
}


val result = multiply

