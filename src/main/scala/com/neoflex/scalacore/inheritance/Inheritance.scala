package com.neoflex.scalacore.inheritance

import com.neoflex.scalacore.scalacollections.TrainSchedule._

object Inheritance extends App {
  private case class Station(station: String)

  private case class Time(hours: Int, minutes: Int) extends Ordered[Time] {
    override lazy val toString = f"$hours%02d:$minutes%02d"

    private val asMinutes = {
      hours * 60 + minutes
    }

    override def compare(that: Time): Int = this.asMinutes - that.asMinutes
  }

  private val time1 = Time(9, 30)

  private case class Train(info: TrainInfo, schedule: Seq[(Time, Station)])

  private sealed abstract class TrainInfo {
    def number: Int
  }

  private case class InterCityExpress(number: Int, hasWiFi: Boolean = false) extends TrainInfo {}

  private case class RegionalExpress(number: Int) extends TrainInfo {}

  private val train1 = Train(InterCityExpress(66, hasWiFi = true), Seq((Time(8, 0), Station("Loo"))))
  private val time2  = Time(1, 30).compare(Time(1, 20))
}
