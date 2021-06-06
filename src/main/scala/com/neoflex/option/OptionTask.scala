package com.neoflex.option

import scala.util.control.Exception.allCatch

object OptionTask extends App {

  private val firstValue = Some("1")

  private def stringToInt(elm: String) = allCatch.opt(elm.toInt)

  private val res1: Int = firstValue.flatMap(x => stringToInt(x)).getOrElse(0)

  private val secondValue: Some[Some[String]] = Some(Some("1"))

  private val res2: Int = secondValue.flatMap(x => stringToInt(x.getOrElse("----"))).getOrElse(0)

  private val thirdValue = List(Some("1"), Some("2"), Some("m"))

  private val res3: Int = thirdValue.flatMap(x => stringToInt(x.getOrElse("----"))).sum

  private val opList1: Option[List[Option[Option[String]]]] =
    Some(
      List(
        Some(Some("k")),
        Some(Some("2")),
        Some(Some("3")),
        Some(Some("4"))
      )
    )

  private val res4: Option[Int] =
    opList1
      .map(x => x.flatten)
      .map(x => x.flatten)
      .map(x => x.map(x => stringToInt(x).getOrElse(0)))
      .map(x => x.sum)

  private val opList2: Option[List[Option[Option[Int]]]] =
    Some(
      List(
        Some(Some(1)),
        Some(None),
        Some(Some(3)),
        Some(Some(4)),
        None
      )
    )

  private val res5: Option[Int] =
    opList2
      .map(x => x.flatten)
      .map(x => x.flatten)
      .map(x => x.sum)

  private val fivethValue =
    Some(
      Some(
        List(
          Some("1"),
          Some("b"),
          Some("3")
        )
      )
    )

  private val res6 =
    fivethValue.flatten
      .map(x => x.map(x => stringToInt(x.getOrElse("---")).getOrElse(0)))
      .map(x => x.map(x => x % 2).sum)

  private def divideXByY(x: Int, y: Int): Either[String, Int] = {
    if (y == 0) Left("Dude, can't divide by 0") else Right(x / y)
  }

  private def foo(a: Int): Either[String, Either[String, Int]] = {
    if (a < 5) Left("Exam failed")
    else
      Right(
        if (a != 10) Left("No maximum ball") else Right(5)
      )
  }

  private val res7 = foo(10).flatten.getOrElse(0)

  private val either1 = Right("1")

  private def stringToIntEither(elm: String) = {
    try {
      Right(elm.toInt)
    } catch {
      case _: Throwable => Left("Error")
    }
  }

  private val resEith1 = either1.flatMap(x => stringToIntEither(x)).getOrElse(0)

  private val either2 = Right(Right("5"))

  private val resEith2 = either2
    .flatMap(x => x)
    .map(x => stringToIntEither(x).getOrElse(0))
    .getOrElse(0)

  private val either3 = List(Right("1"), Right("2"), Right("m"))

  private val resEith3 = either3
    .map(x => x.getOrElse("--"))
    .map(x => stringToIntEither(x).getOrElse(0))
    .sum

  private val either4 = Right(
    List(
      Right(Right("k")),
      Right(Right("2")),
      Right(Right("3")),
      Right(Right("4"))
    )
  )

  private val resEith4: Either[Nothing, Int] = either4
    .map(x => x.map(x => x.flatten))
    .map(x => x.map(x => x.getOrElse("---")))
    .map(x => x.map(x => stringToIntEither(x)))
    .map(x => x.map(x => x.getOrElse(0)))
    .map(x => x.sum)

  private val either5 =
    Right(
      List(
        Right(Right(1)),
        Right(Left()),
        Right(Right(3)),
        Right(Right(4)),
        Left()
      )
    )

  private val resEith5 = either5
    .map(x => x.map(x => x.flatten))
    .map(x => x.map(x => x.getOrElse(0)))
    .map(x => x.sum)

  private val either6 =
    Right(
      Right(
        List(
          Right("1"),
          Right("b"),
          Right("3")
        )
      )
    )

  private val resEith6 = either6.flatten
    .map(x => x.map(x => stringToIntEither(x.getOrElse("---")).getOrElse(0) % 2))
    .map(x => x.sum)

  private val someLst = List(Some(1), None, Some(2))

  private val resSome = someLst.map(x => x.getOrElse(0))

  private val eithList: List[Either[String, Int]] =
    List(
      Left("Error"),
      Right(5),
      Left("Error2"),
      Right(6),
      Left("Error3"),
      Right(10)
    )

  private val resEithLeft = eithList.filter(_.isLeft)

  private val resEithRight = eithList.filter(_.isRight)

  private val emptyEith: Either[String, Int] = Left("")

  private val leftEith: Either[Either[String, String], Int] = Left(Left("8"))
}
