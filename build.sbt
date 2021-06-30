import Dependencies._
name := "My_Scala_Core_Project"

version := "0.1"

scalaVersion := s"$scalaCompat"

libraryDependencies ++= Seq(
  Testing.ScalaTest,
  JSonConverter.Converter
)
