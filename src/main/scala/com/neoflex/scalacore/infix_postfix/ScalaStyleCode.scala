package com.neoflex.scalacore.infix_postfix

import scala.language.postfixOps

object ScalaStyleCode extends App {

  private val prefix  = !true == true.unary_!
  private val infix   = "Wolf Fox".split(" ")
  private val postfix = "Wolf".length

  private val useScalaStyle1 = "I am Wolf" split " " map (x => x + "_")
  private val useScalaStyle2 = "I am Wolf".split(" ").map(x => x + "_")
  private val useScalaStyle3 = "I am Wolf" split " " length

  private class Time(val hours: Int, val minutes: Int) {

    val asMinutes: Int = hours * 60 + minutes
    var sec            = 0

    def minus(newTime: Time): Int = {
      val result = this.asMinutes - newTime.asMinutes
      result
    }

    def -(newTime: Time): Int = minus(newTime)
    println(s"Your Time: $hours:$minutes")
  }

  private val time1 = new Time(5, 55)
  private val time2 = new Time(10, 5)

  private val difference1 = time2 - time1
  private val difference2 = time2 minus time1

  private val equal = difference1 == difference2
}
