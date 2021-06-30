package com.neoflex.scalacore.optionaltype

import com.neoflex.scalacore.scalacollections.TrainSchedule._

object OptionalType extends App {

  private case class Time(hours: Int, minutes: Int) {
    override def toString: String = s"$hours:$minutes"
  }

  private val mySchedule =
    Seq(
      (Time(8, 0), Station("Loo")),
      (Time(8, 15), Station("VolgaRiver")),
      (Time(8, 30), Station("TrainStation"))
    )

  private case class Train(schedule: Seq[(Time, Station)]) {

    def timeAt(station: Station): Option[Time] = {
      val result = schedule.find(x => x._2 == station) match {
        case Some(x) => Some(x._1)
        case _       => None
      }
      result
    }
  }

  private val train1 = Train(mySchedule)

  private val timeStopStation = train1.timeAt(Station("VolgaRiver"))
}
