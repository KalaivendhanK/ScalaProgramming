package com.home.oopsLearnings

import scala.annotation.meta.param


trait ParentForMakeList {
  def apply(input: Int): List[Int]

  def anotherFunction: MakeList

  override def toString = "ParentForMakeList"
}

class MakeList {
  def apply(input: Int): List[Int] = (0 to input).toList

  override def toString = "MakeList"
}

trait Person {
  def hasHome:Boolean
  def salaryCalculator(salary:Double):Double = salary * 10
}
trait Parent{
  def doesHouseKeeping: Boolean
}
class Doctor(name:String) extends Person with Parent{
  override def hasHome: Boolean = true
  override def doesHouseKeeping: Boolean = true
  override def toString() = s"Hi my name is $name and Homeflag = $hasHome and houseKeeping flag = $doesHouseKeeping"
}
object Doctor{
  def apply(name:String) = new Doctor(name)
}

object Main extends App {
//    Codes.workBlock1(args = args)
//    Codes.testFunctions
    Codes.testFunctions2

  object Codes {
    def workBlock1(args: Array[String]): Unit = {
      //  println("Hey there!!")
      val parentForMakeList: ParentForMakeList = new ParentForMakeList {
        override def apply(input: Int): List[Int] = (0 to input).map(_ * 2).toList

        override def anotherFunction: MakeList = new MakeList
      }
      type ~>[A, B] = PartialFunction[A, B]
      type ==>[A1, B] = Function[A1, B]
      val partialFunciton: Int ~> String = {
        case _ => "Its partial function here !"
      }
      val function: (Int, Int) => String = (a: Int, b: Int) => "Its normal function here !"
      println(partialFunciton(5))
      println(function(5, 6))
      //  val newList :List[Int] = parentForMakeList.apply(10)
      //  println(parentForMakeList)
      //  newList.foreach(println)
      //  println(new MakeList)
      //  parentForMakeList.anotherFunction.apply(10).foreach(println)
    }

    def testFunctions = {
      import scala.Function.uncurried
      def functionReturnsAnotherFunction: (Int => Int => String) = {
        x => (y => x.toString + " " + y.toString)
      }

      print(uncurried {
        functionReturnsAnotherFunction
      }(234, 2384))
    }

    def testFunctions2: Unit ={
      val bob = Doctor("bob")
      print(bob)
    }

  }

}

