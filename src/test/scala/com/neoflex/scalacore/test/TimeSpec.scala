package com.neoflex.scalacore.test

import com.neoflex.scalacore.preconditions.Preconditions._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TimeSpec extends AnyWordSpec with Matchers {
  "Creating a time" should {
    "throw an IllegalArgumentException for hours within 0 and 23" in {
      an[IllegalArgumentException] should be thrownBy new Time(-1)
      an[IllegalArgumentException] should be thrownBy new Time(24)
    }
    "throw an IllegalArgumentException for minutes within 0 and 59" in {
      an[IllegalArgumentException] should be thrownBy new Time(minutes = -1)
      an[IllegalArgumentException] should be thrownBy new Time(minutes = 60)
    }
  }
  "Default argument for hours and minutes" should {
    "be equal to 0" in {
      val time = new Time()
      time.hours shouldEqual 0
      time.minutes shouldEqual 0
    }
  }

  "asMinutes" should {
    "be initialized correctly" in {
      new Time(1, 40).asMinutes shouldEqual 100
    }
  }
  "Calling minus" should {
    "be correctly" in {
      new Time(1, 40) minus new Time(1, 20) shouldEqual 20
      new Time(1, 40) - new Time(1, 20) shouldEqual 20
    }
  }
}
