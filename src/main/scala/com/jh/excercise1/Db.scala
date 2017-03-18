package com.jh.excercise1

case class Record(id: Int, name: String, age: Int, balance: Double)

class Db {
  private var clients = Seq[Record]()

  def avgAge(): Double =  {
    val sumLenTuple = clients.foldLeft((0.00, 0)) ((acc, record) => (acc._1 + record.age, acc._2+1))
    sumLenTuple._1 / sumLenTuple._2
  }

  def getFewRecordsWithMaxBalance(recordsAmount : Int) =
    clients.sortWith(_.balance > _.balance).take(recordsAmount)

  def getFewRecordsWithMinBalance(recordsAmount : Int) =
    clients.sortWith(_.balance < _.balance).take(recordsAmount)

  def add(record: Record) : Unit = clients = record +: clients

  def update(record: Record) : Unit = clients = clients.map {
    x =>
      if (x.id == record.id)
        record
      else
        x
  }

  def getById(id: Int) : Record = clients.filter(_.id == id).head

}
