import sbt._

object Dependencies {
  val scalaCompat = "2.13.5"

  private object Version {
    val scalaTest     = "3.2.7"
    val jSonConverter = "2.9.2"
  }

  object Testing {
    val ScalaTest = "org.scalatest" %% "scalatest" % s"${Version.scalaTest}" % "test"
  }

  object JSonConverter {
    val Converter = "com.typesafe.play" %% "play-json" % s"${Version.jSonConverter}"
  }
}
