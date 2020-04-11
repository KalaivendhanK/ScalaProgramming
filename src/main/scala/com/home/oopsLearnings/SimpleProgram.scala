package com.home.oopsLearnings

trait ParentForMakeList{
  def apply(input: Int):List[Int]
  def anotherFunction : MakeList
  override def toString = "ParentForMakeList"
}

class MakeList  {
  def apply(input : Int) : List[Int] = (0 to input).toList
  override def toString = "MakeList"
}

object Main extends App {
//  println("Hey there!!")
  val parentForMakeList: ParentForMakeList = new ParentForMakeList {
    override def apply(input: Int): List[Int] = (0 to input).map(_*2).toList
    override def anotherFunction : MakeList = new MakeList
  }
  val newList :List[Int] = parentForMakeList.apply(10)
  println(parentForMakeList)
  newList.foreach(println)
  println(new MakeList)
  parentForMakeList.anotherFunction.apply(10).foreach(println)
}

