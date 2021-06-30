package com.neoflex.scalacore.preconditions

object Preconditions extends App {

  /**
   * Assert указывает условие, которое статическая проверка должна попытаться доказать.
   * Компилятор доказывает сам себе подходит ли условие или нет.
   */
  private def ageTest(age: Int): Int = {
    assert(age > 18)
    val res = age * 7
    println(s"Если бы ты был кошкой то тебе сейчас было бы: $res")
    res
  }

  private val successCase1 = ageTest(20)
  private val failCase1    = ageTest(15)

  /**
   * Assume должен использоваться для условия, которое проверка может считать выполненным.
   * Компилятор принимает заданное правило просто как истину без доказательств.
   */
  private def ageTest2(age: Int): Int = {
    assume(age > 18)
    val res = age * 7
    println(s"Если бы ты был кошкой то тебе сейчас было бы: $res")
    res
  }

  private val failCase2    = ageTest2(15)
  private val successCase2 = ageTest2(20)

  /**
   * Require указывает условие, которое вызывающий должен обеспечить.
   * Компилятор считает что тот кто вызывает функцию косячит и гворит в ошибке что не подходящий аргумент.
   */
  private def ageTest3(age: Int): Int = {
    require(age > 18)
    val res = age * 7
    println(s"Если бы ты был кошкой то тебе сейчас было бы: $res")
    res
  }

  private val failCase3    = ageTest3(15)
  private val successCase3 = ageTest3(20)

  /**
   * Ensuring указывает условие которое проверяется после выполнения программы.
   * Компилятор смотрит на условие после выполнения программы, обычно применяется для лимитов, чтобы понять не превышен ли он.
   */
  private def ageTest4(age: Int): Int = {
    require(age > 18)
    val res = age * 7
    println(s"Если бы ты был кошкой то тебе сейчас было бы: $res")
    res
  } ensuring (age * 7 < 100)

  private val failCase4    = ageTest4(15)
  private val successCase4 = ageTest4(20)

  class Time(val hours: Int = 0, val minutes: Int = 0) {
    require(hours >= 0 && hours < 24, "hours must be >= 0 and must be < 24")
    require(minutes >= 0 && minutes < 60, "minutes must be >= 0 and must be < 60")

    val asMinutes: Int = hours * 60 + minutes

    def minus(newTime: Time): Int = {
      val result = this.asMinutes - newTime.asMinutes
      result
    }

    def -(newTime: Time): Int = minus(newTime)
    println(s"Your Time: $hours:$minutes")
  }

  private val successCaseTime1 = new Time(25, 53)
  private val failCaseTime1    = new Time(25, 53)
  private val failCaseTime2    = new Time(22, 61)
}
