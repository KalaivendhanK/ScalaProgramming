package com.home.collections

sealed trait Set[A] extends (A => Boolean) {

  // def getItem: A = item
}

object Set {
  class Empty[A] extends Set[A] {
    override def apply(isItem: A): Boolean =
      false

    override def toString = "Set.Empty"
  }

  /**
    * Empty Object
    */
  object Empty {
    final def apply[A]: Empty[A] = new Empty[A]
  }
  // def empty[A] //TODO

  /**
    * Non Empty Class
    * @type {[Can be of any type]}
    */
  case class NonEmpty[A](elem: A, linkElem: Set[A]) extends Set[A] {
    override def apply(isItem: A): Boolean =
      elem == isItem
  }

  def apply[A](): Set[A] = new Empty[A]
  def apply[A](item: A*): Set[A] = ???

  // private final case class

}
//com.home.collections.Set$Empty$@184f6be2
object Run extends App {
  val newSet = Set.Empty[String](new String("something"))
//  println(newSet)
  val someVariable : Int => String = input => "got it"
  println(someVariable(14))
}