package com.home.collections

trait FunctionSet extends (String => Boolean) {
  def add(input: String): FunctionSet = { elem =>
    input == elem || this(elem)
  }

  def remove(input: String): FunctionSet = { elem =>
    input != elem && this(elem)
  }
}
/**
  * Sample comment to check the commit
  */
object FunctionSet {
  def empty: FunctionSet = _ => false

}