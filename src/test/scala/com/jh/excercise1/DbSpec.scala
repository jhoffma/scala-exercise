package com.jh.excercise1

import org.scalatest.{FlatSpec, Matchers}


class DbSpec extends FlatSpec with Matchers {

  behavior of "fake Db implementation"

  it should "be able to add record to db" in {
    //given
    val db = new Db()

    //when
    db.add(Record(1, "Ola", 5, 3.23))
    val result = db.getById(1)

    //then
    result should be(Record(1, "Ola", 5, 3.23))
  }

  it should "be able to update existing record" in {
    //given
    val db = new Db()
    populateDb(db)

    //when
    db.update(Record(1, "Ola", 5, 153.23))
    val result = db.getById(1)

    //then
    result should be(Record(1, "Ola", 5, 153.23))
  }

  it should "calculate average age of customers in db" in {
    //given
    val db = new Db()
    populateDb(db)

    //when
    val result = db.avgAge()

    //then
    result should be(6.666666666666667)
  }

  it should "get 2 accounts with the highest balance" in {
    //given
    val db = new Db()
    populateDb(db)

    //when
    val result = db.getFewRecordsWithMaxBalance(2)

    //then
    result should be(Seq(Record(2, "Ala", 8, 8.55), Record(1, "Ola", 5, 3.23)))
  }

  it should "get 2 accounts with the lowest balance" in {
    //given
    val db = new Db()
    populateDb(db)

    //when
    val result = db.getFewRecordsWithMinBalance(2)

    //then
    result should be(Seq(Record(3, "Kot", 7, 1.10), Record(1, "Ola", 5, 3.23)))
  }

  private def populateDb(db: Db) : Unit = {
    db.add(Record(1, "Ola", 5, 3.23))
    db.add(Record(2, "Ala", 8, 8.55))
    db.add(Record(3, "Kot", 7, 1.10))
  }

}
