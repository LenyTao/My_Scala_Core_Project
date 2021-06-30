package com.neoflex.scalacore.caseclasses

object CaseClasses extends App {

  case class Time0(hours: Int = 0, minutes: Int = 0)

  private class Time1(hours: Int, minutes: Int) {}

  private class Time2(hours: Int = 3, minutes: Int = 15) {
    private val h: Int = hours
    val m: Int         = minutes
  }

  private class Time3(val hours: Int = 3, val minutes: Int = 15)

  private val time1 = new Time1(8, 15)

  private val time2 = new Time2(8)

  private val minutesTime2 = time2.m

  private val time3 = new Time3(8)

  private val minutesTime3 = time3.minutes

  private val time0 = Time0(8, 15)

  private val minutesTime0 = time3.minutes

  private val newTime0 = time0.copy(5)
}
