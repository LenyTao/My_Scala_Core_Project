package com.neoflex.scalacore.scalacollections

object TrainSchedule extends App {

   case class Station(station: String)

  private case class Train(schedule: Seq[Station]) {
    require(schedule.take(2).size == 2, "Schedule must have minimum 2 elm")
  }

  private val station1 = Station("VolgaRiverStation")
  private val station2 = Station("LooStation")
  private val station3 = Station("SaratovLadaStation")

  private val schedule  = Seq(station1, station2, station3)
  private val schedule2 = Seq(station1)

  private val train1 = Train(schedule)
}
