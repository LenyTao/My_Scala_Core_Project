package com.neoflex.scalacore.patternmatching

import com.neoflex.scalacore.caseclasses.CaseClasses._
import com.neoflex.scalacore.scalacollections.TrainSchedule._

object PatternMatching extends App {

  private def matchSeq[A](seq: Seq[A]) = seq match {
    case Seq(1, 2, 3) => "1 to 3"
    case x +: Nil     => s"Only element $x"
    case _ :+ x       => s"Last elm $x"
    case Nil          => "Empty seq"
  }

  private val match1 = matchSeq(Seq(1, 2, 3))
  private val match2 = matchSeq(List(1, 2, 3))
  private val match3 = matchSeq(List(1))
  private val match4 = matchSeq(List(1, 2, 3, 4, 5))
  private val match5 = matchSeq(Seq.empty)

  private case class Train(number: Int, schedule: Seq[(Time0, Station)])

  private val station1 = Station("VolgaRiverStation")
  private val station2 = Station("LooStation")
  private val station3 = Station("SaratovLadaStation")
  private val station4 = Station("SaratovTrainStation")

  private val stations1 = Seq(station1, station2, station3)
  private val stations2 = Seq(station4, station2, station3)

  private val times1 =
    Seq(
      Time0(8),
      Time0(8, 15),
      Time0(8, 30)
    )
  private val schedule  = times1.zip(stations1)
  private val schedule2 = times1.zip(stations2)
  private val trains    = Set(Train(88, schedule), Train(55, schedule))

  private class JourneyPlanner(trains: Set[Train]) {

    def isShortTrip(from: Station, to: Station): Boolean = {
      trains.exists(
        _.schedule.map(x => x._2).dropWhile(_ != from) match {
          case `from` +: `to` +: _      => true
          case `from` +: _ +: `to` +: _ => true
          case _                        => false
        }
      )
    }
  }

  private val jp            = new JourneyPlanner(trains)
  private val jpTripIsShort = jp.isShortTrip(station1, station2)
}
