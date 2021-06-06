package com.neoflex.scalacore.scalacollections

object Collections extends App {

  private val list = List(1, 2, 3)

  private val listHead        = list.head
  private val listLast        = list.last
  private val listInit        = list.init
  private val listTail        = list.tail
  private val listTake3       = list.take(3)
  private val listTakeAllOr10 = list.take(10)

  private val list2 = List("1-", "2-", "3-")

  private val newList = list2.zip(list)

  private val list3 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  private val OddAndOven              = list3.groupBy(x => x % 2 == 0)
  private val optionHead: Option[Int] = list3.headOption

  private val list4 = List(1, 1, 2, 3, 4, 5, 5)

  private val nonDuplicateList = list4.distinct

  private val list5 = List(1, 2, 3, 4, 5)

  private val listAddStart = 0 +: list5
  private val listAddEnd   = list5 :+ 0
}
