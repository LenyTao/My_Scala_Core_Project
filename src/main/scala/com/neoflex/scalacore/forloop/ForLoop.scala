package com.neoflex.scalacore.forloop

import com.neoflex.scalacore.caseclasses.CaseClasses._
import com.neoflex.scalacore.scalacollections.TrainSchedule._

object ForLoop extends App {
  private val set = Set(1, 2, 3, 4, 5)

  private val loop1: Unit = for (i <- set) println(i)

  private val loopComprehension1 = for (i <- set) yield {
    i * 2
  }

  private val loopComprehension2 = for {
    i <- 1 to 3
    m <- 1 to i
  } yield {
    i * m
  }

  private val loopComprehension3 = for {
    i <- 1 to 3 if i % 2 == 0
    m <- 1 to i
  } yield {
    i * m
  }

  private val setTimes = Set(
    Time0(8, 15),
    Time0(10, 15),
    Time0(5, 20)
  )

  private val loopComprehension4 = for {
    x     <- setTimes
    hours = x.hours if hours > 7
  } yield {
    (hours + 0) + " now"
  }

  private val loopComprehension5 =
    for (keyAndValue <- Vector(1 -> "a", 2 -> "b"))
      yield keyAndValue._1 + keyAndValue._2

  private val loopComprehension6 =
    for ((key, value) <- Vector(1 -> "a", 2 -> "b"))
      yield key + value

  private case class Train(number: Int, schedule: Seq[(Time0, Station)])

  private val station1 = Station("VolgaRiverStation")
  private val station2 = Station("LooStation")
  private val station3 = Station("SaratovLadaStation")
  private val station4 = Station("SaratovTrainStation")

  private val stationsSeq1 = Seq(station1, station2, station3)
  private val stationsSeq2 = Seq(station4, station2, station3)

  private val seqTimes =
    Seq(
      Time0(8),
      Time0(8, 15),
      Time0(8, 30)
    )
  private val schedule  = seqTimes.zip(stationsSeq1)
  private val schedule2 = seqTimes.zip(stationsSeq2)

  private val trains = Set(Train(88, schedule), Train(55, schedule))

  private class JourneyPlanner(trains: Set[Train]) {
    private val stations: Set[Station] = trains.flatMap(x => x.schedule.map(x => x._2))
    def stopsAt(station: Station): Set[(Int, Time0)] = {
      for {
        trainNumber    <- trains.map(x => x.number)
        timeAndStation <- trains.flatMap(x => x.schedule) if timeAndStation._2 == station
      } yield {
        (trainNumber, timeAndStation._1)
      }
    }
  }
  private val jp        = new JourneyPlanner(trains)
  private val stopPlace = jp.stopsAt(Station("LooStation"))
}
