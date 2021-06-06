package com.neoflex.scalacore.variables

object Variables extends App {

  private val a = "Six"
  private var b = "Six"

  private val successEqual = a == b
  b = "Seven"
  private val failedEqual = a == b

  private val blockValue = {
    val x = 2
    val y = 3
    x + y
  }

  private def personName(firstName: String = "_", lastName: String = "_") = {
    firstName + " " + lastName
  }

  private val fullName  = personName("James", "Bond")
  private val fullName2 = personName(lastName = "Bond", firstName = "James")

  private case class Time0(h: Int, m: Int)

  private val (morning, highNoon) = Time0(6, 10) -> Time0(12, 15)
  private val (morning2, _)       = Time0(6, 10) -> Time0(12, 15)
}
