package com.home.collections

trait SetC extends (String => Boolean) {
  def add(input: String): SetC
  def remove(input: String): SetC
  def size(currentSize: Int): Int
  def empty = SetC.Empty
}

object SetC {
  case object Empty extends SetC {
    override def apply(input: String): Boolean =
      false

    final override def add(input: String): SetC =
      NonEmpty(input, this)

    final override def size(currentSize: Int = 0) = 0

    def remove(input: String): SetC =
      this
  }

  /*private[this]*/ case class NonEmpty(element: String, otherElements: SetC) extends SetC {
    override def apply(input: String): Boolean =
      input == element || otherElements(input)

    final override def add(input: String): SetC =
      if (input == element || input == otherElements(element))
        this
      else
        NonEmpty(input, otherElements.add(element))

    final override def size(currentSize: Int = 0): Int = {
      var elementCount = 0
      if (otherElements.isInstanceOf[Empty.type])
        elementCount = currentSize + 1
      else if (otherElements.isInstanceOf[NonEmpty]) {
        elementCount = currentSize + 1
        elementCount = otherElements.size(currentSize = elementCount)
      }
      elementCount
    }

    def remove(input: String): SetC =
      if (input == element)
        otherElements
      else
        NonEmpty(element, otherElements.remove(input))

  }
  final def empty: SetC = Empty
  final def add(input: String): SetC =
    NonEmpty(input, SetC.Empty)
}