package com.neoflex.scalacore.functionalprogaraming.base

import com.neoflex.scalacore.scalacollections.TrainSchedule._
import com.neoflex.scalacore.preconditions.Preconditions._

object FunctionalProgramming extends App {
  private val vector = Vector(1, 2, 3, 4, 5)

  private def function(i: Int) = {
    i + 1
  }

  private val add1: Int => Int = (x: Int) => x + 1

  private val add1All      = vector.map(x => x + 1)
  private val addAll2      = vector.map(_ + 1)
  private val useFunction  = vector.map(x => function(x))
  private val useFunction2 = vector.map(function)
  private val anonFunction = vector.map(add1)

  private case class Train(number: Int, schedule: Seq[(Time, Station)]) {
    val stations: Seq[Station] = schedule.map(x => x._2)
  }

  private val station1 = Station("VolgaRiverStation")
  private val station2 = Station("LooStation")
  private val station3 = Station("SaratovLadaStation")
  private val station4 = Station("SaratovLadaStation")

  private val schedule1 = Seq(station1, station2, station3)
  private val schedule2 = Seq(station4, station2, station3)

  private val seqTimes1 =
    Seq(
      new Time(8, 0),
      new Time(8, 15),
      new Time(8, 30)
    )
  private val scheduleWithTimes = seqTimes1.zip(schedule1)

  private val scheduleWithTimes2 = seqTimes1.zip(schedule2)

  private val seqStations = scheduleWithTimes.map(x => x._2)

  private class JourneyPlanner(trains: Set[Train]) {
    val stations: Set[Seq[Station]] = trains.map(x => x.stations)

    def trainsAd(station: Station): Set[Int] = {
      trains.filter(x => x.stations.contains(station)).map(x => x.number)
    }

    def stopsAt(station: Station): Unit = {
      for {
        station <- trains.map(x => x.schedule.map(x => x._2))
        time    <- trains.map(x => x.schedule.map(x => x._1))
      } println(station + "------------" + time)
    }
  }

  private val jp = new JourneyPlanner(Set(Train(55, scheduleWithTimes), Train(88, scheduleWithTimes2)))

  private val jpStations    = jp.stations
  private val jpTrainsAdd   = jp.trainsAd(Station("VolgaRiverStation"))
  private val jpStops: Unit = jp.stopsAt(station1)
}
