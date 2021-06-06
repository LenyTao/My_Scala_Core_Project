package com.neoflex.scalacore.tailrecursion

import scala.annotation.tailrec

object TailRecursion extends App {

  private def factorial(n: Int): BigInt = {
    assert(n >= 0, "число не может быть отрицательным")
    assert(n <= 50000, "число слишком большое")

    @tailrec
    def factorialLogics(n: Int, acm: BigInt = 1): BigInt = {
      if (n > 0) {
        factorialLogics(n - 1, acm * n)
      } else {
        acm
      }
    }
    factorialLogics(n)
  }
  private val factorial2 = factorial(512)
}
