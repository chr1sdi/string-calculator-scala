package test.scala

import main.scala.Calculator
import org.specs.Specification
import org.specs.util.DataTables

class CalculatorTests extends Specification with DataTables {
  "String Calculator " should {

    "should return 0 for empty string" in {
      Calculator.add("") must be equalTo 0
    }

    "should return the same value if only 1 is passed in, 18 for 18" in {
      Calculator.add("18") must be equalTo 18
    }

    "should return sum for two inputs, 9 for 2 and 7" in {
      Calculator.add("2,7") must be equalTo 9
    }

    "should return sum for unknown amount of numbers" in {
      "input" | "result" |>
        "1,2,3,4,5" ! 15 |
        "100,150" ! 250 |
        "5,10,15,20" ! 50 | {
        (input, result) => {
          Calculator.add(input) must be equalTo (result)
        }
      }
    }

    "should handle new lines between input" in {
      Calculator.add("1\n2,3") must be equalTo 6
    }

    "should support different delimiters like: ;" in {
      Calculator.add("//;\n1;2;5") must be equalTo 8
    }

    "should not sum up negatives" in {
      Calculator.add("1,-4,1") must throwA[Exception]
    }

  }
}

