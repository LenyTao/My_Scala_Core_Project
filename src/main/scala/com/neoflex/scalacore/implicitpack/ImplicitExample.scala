package com.neoflex.scalacore.implicitpack

object ImplicitExample extends App {
  implicit val implInt: Int = 55

  object Impl {

    def multiplyOn3(x: Double)(implicit z: Int): Double = {
      x * z
    }
    val useMultiply: Double = multiplyOn3(10.0)
  }
}
