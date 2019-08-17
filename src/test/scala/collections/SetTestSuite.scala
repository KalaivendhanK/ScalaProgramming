package com.home.testing

import org.scalatest._
import com.home.collections._

class SetTestSuite extends FunSuite with Matchers {
  /**
    * Tests to check the empty set funcionality
    */
  test("Checking an elemnt in an empty set should return false") {
    FunctionSet.empty(randomString) shouldBe false
  }

  /**
    * Tests to check the add functionality
    */
  test("Taking the added element should return the true if it is in the set") {
    val first = randomString
    val second = randomString
    val third = randomString

    val set = FunctionSet.empty.add(first).add(second)

    set(first) shouldBe true
    set(second) shouldBe true
    set(third) shouldBe false
  }

  /**
    * Test to check the remove functionality
    */
  test("Check the remove function with various use cases") {
    val first = randomString
    val second = randomString
    val third = randomString
    val fourth = randomString

    val completeSet = FunctionSet.empty.add(first).add(second).add(third)
    val firstRemovedSet = completeSet.remove(first)
    val secondRemovedSet = completeSet.remove(second)
    val firstAndSecondRemovedSet = completeSet.remove(first).remove(second)

    completeSet(first) shouldBe true
    completeSet(second) shouldBe true
    completeSet(third) shouldBe true

    firstRemovedSet(first) shouldBe false
    firstRemovedSet(second) shouldBe true
    firstRemovedSet(third) shouldBe true

    secondRemovedSet(first) shouldBe true
    secondRemovedSet(second) shouldBe false
    secondRemovedSet(third) shouldBe true

    firstAndSecondRemovedSet(first) shouldBe false
    firstAndSecondRemovedSet(second) shouldBe false
    firstAndSecondRemovedSet(third) shouldBe true

    completeSet(fourth) shouldBe false
    firstRemovedSet(fourth) shouldBe false
    secondRemovedSet(fourth) shouldBe false
    firstAndSecondRemovedSet(fourth) shouldBe false
  }

  def randomString: String = scala.util.Random.alphanumeric.take(8).mkString
}
