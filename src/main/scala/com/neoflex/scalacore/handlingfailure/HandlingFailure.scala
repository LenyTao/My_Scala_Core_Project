package com.neoflex.scalacore.handlingfailure

import play.api.libs.json._
import scala.util.Try

object HandlingFailure extends App {
  private val failCase    = Try("a".toInt).toOption
  private val successCase = Try("5".toInt).toOption

  private case class Time(hours: Int, minutes: Int) {

    def fromJSon(js: JsValue): Option[Time] = {
      val result = for {
        hours   <- Try((js \ "hours").as[Int])
        minutes <- Try((js \ "minutes").as[Int])
      } yield Time(hours, minutes)
      result.toOption
    }

    def toJSon: JsValue = JsObject(
      Map("hours" -> JsNumber(hours), "minutes" -> JsNumber(minutes))
    )
  }

  private val js   = Time(1, 10).toJSon
  private val time = Time(0, 0).fromJSon(js)
}
