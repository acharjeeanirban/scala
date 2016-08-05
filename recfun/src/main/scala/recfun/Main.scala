package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    //def pascal(c: Int, r: Int): Int = ???
    def pascal(c: Int, r: Int): Int = {
      if (r == 0 || c == r || c == 0)
        1
      else
        pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    //def balance(chars: List[Char]): Boolean = ???

  def balance(chars: List[Char]): Boolean  = {
    def balanceUtil(chars: List[Char], numberOfbrackets: Int): Boolean = {
      if (chars.isEmpty) {
        numberOfbrackets == 0;
      } else {
        val headOfString = chars.head
        val num =
          if (headOfString == '(')
            numberOfbrackets + 1
          else if (headOfString == ')')
            numberOfbrackets -1
          else numberOfbrackets
        if (num >= 0)
          balanceUtil(chars.tail, num)
        else false
      }
    }

    balanceUtil(chars, 0)

  }
  
  /**
   * Exercise 3
   */
    //def countChange(money: Int, coins: List[Int]): Int = ???

    def countChange(money: Int, coins: List[Int]): Int = {
      def cointUtil(money: Int, coinsArray: List[Int], index: Int): Int = {
        if (money == 0 && index == 0)
          1
        else if (money != 0 && index == 0)
          0
        else if (money < 0)
          0
        else (cointUtil(money - coinsArray(index-1), coinsArray, index) + cointUtil(money, coinsArray, index-1))
      }
      cointUtil(money, coins, coins.toArray.length)

    }
  }
