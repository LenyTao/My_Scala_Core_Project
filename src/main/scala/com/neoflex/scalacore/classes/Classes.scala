package com.neoflex.scalacore.classes

object Classes extends App {

  private class Man {
    println("Displays current exercise instruction.")
  }

  private val man = new Man

  private class Train(number: Int)

  private val train = new Train(8)

  private class Person(name: String, age: Int) {
    println(s"I am $name. I am $age")
  }

  private class Person2(val name: String, val age: Int) {
    println(s"I am $name. I am $age")
  }

  private val person1 = new Person("Tanya", 25)

  private val person2 = new Person2("Tanya", 25)

  private val agePerson = person2.age

  private class Time(val hours: Int, val minutes: Int) {
    val asMinutes: Int = hours * 60 + minutes
    var sec            = 0

    def minus(newTime: Time): Int = {
      val result = this.asMinutes - newTime.asMinutes
      result
    }

    //TODO comment: Verify that hours is within 0 and 23
    //TODO comment: Verify that minutes is within 0 and 59

    println(s"Your Time: $hours:$minutes")
  }

  private val myTime = new Time(8, 20)

  private val myTime2 = new Time(3, 20)

  private val second = myTime.sec

  private val minutes = myTime.asMinutes

  private val differenceBetweenTime = myTime minus myTime2
}
