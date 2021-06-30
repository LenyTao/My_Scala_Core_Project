package com.neoflex.scalacore.objectcompanion

object ObjectCompanion extends App {

class Time(val hours: Int, val minutes: Int) {
    private val asMinutes: Int = hours * 60 + minutes
    private var sec            = 5

    def minus(newTime: Time): Int = {
      val result = this.asMinutes - newTime.asMinutes
      result
    }

    def -(newTime: Time): Int = minus(newTime)

    println(s"Your Time: $hours:$minutes")
  }

  object Time {

    def fromMinutes(min: Int): Time = {
      val hours   = min / 60
      val minutes = min % 60
      new Time(hours, minutes)
    }

    println("----" + new Time(10, 5).sec)
  }

  private val newCompanion  = Time.fromMinutes(100)
  private val newCompanion2 = new Time(10, 6)
}
