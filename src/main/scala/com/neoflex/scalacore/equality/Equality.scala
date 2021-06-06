package com.neoflex.scalacore.equality

object Equality extends App {
  private val equals1 = 5 == 5
  private val equals2 = 5 equals 5
  private val equals3 = "Hi" == "Hi"
  private val equals4 = new String("Hi") eq new String("Hi")
  private val equals5 = new String("Hi") ne new String("Hi")
}
