package main.scala

object Calculator {

  def add(input: String): Int = {
    if (input.isEmpty) return 0

    val numbers = takeNumbersFrom(input)
      .split(takeDelimitersFor(input) + "|\n")
      .map(_.toInt)

    val negatives = numbers.filter(_ < 0)
    if (negatives.isEmpty)
      numbers.sum
    else
      throw new Exception("Negatives are not allowed: " + negatives.map(_.toString + ", "))
  }

  private def takeNumbersFrom(input: String): String = {
    if (hasCustomDelimeters(input)) input.substring(4)
    else input
  }

  private def takeDelimitersFor(intput: String): String = {
    if (hasCustomDelimeters(intput)) intput.substring(2, 3)
    else ","
  }

  private def hasCustomDelimeters(intput: String): Boolean = {
    intput.startsWith("//")
  }
}
