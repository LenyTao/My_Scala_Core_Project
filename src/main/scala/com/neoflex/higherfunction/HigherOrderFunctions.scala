package com.neoflex.higherfunction

object HigherOrderFunctions extends App {

  private def anonFunc = { (x: Int) => (y: Int => Double) =>
    y(x)
  }

  private val divide2 = (x: Int) => x / 2.0

  anonFunc(8)(divide2)

  private def myMap[A, B](f: A => B, seq: Seq[A]): Seq[B] = {
    for (x <- seq) yield {
      f(x)
    }
  }

  private val useMyMap = myMap(divide2, Seq(2, 4, 6))

  private def highFunction =
    (x: Int) => (y: Int) => (f: (Int, Int) => Double) => f(x, y)

  private def lightFunction = (x: Int, y: Int) => x * y * 1.0

  private val base     = highFunction(8)
  private val basePart = base(5)
  private val func     = lightFunction

  private val baseCurry = highFunction(8)(5)

  private class Person {

    def functionPlus[T, A](a: T): (T => A) => A = { (f: T => A) =>
      f(a)
    }
  }

  private val person = new Person

  private def f(a: Int) = {
    a.toDouble
  }

  private val useFunctionPlus = person.functionPlus(8)(f)

  private def lFunc(a: Int) = {
    a.toDouble
  }

  private def flmap[A, B](f: A => B, seq: Seq[Seq[A]]): Iterable[B] = {
    val map = for {
      x <- seq
    } yield {
      for {
        y <- x.indices
      } yield {
        f(x(y))
      }
    }
    val flatten = for {
      x <- map
      y <- x.indices
    } yield {
      x(y)
    }
    flatten
  }

  private val useMyFlMap =
    flmap(
      lFunc,
      Seq(
        Seq(1, 2),
        Seq(3, 4, 5),
        Seq(6, 7, 8, 9, 10)
      )
    )

  private def myFilter[A](predicat: A => Boolean, seq: Seq[A]) = {
    for {
      x      <- seq.indices
      newSeq = seq(x) if predicat(seq(x))
    } yield {
      newSeq
    }
  }

  private def lfilt(x: Int) = {
    x > 3
  }

  private val useMyFilter = myFilter(lfilt, List(3, 4, 1, 5, 10))
}
