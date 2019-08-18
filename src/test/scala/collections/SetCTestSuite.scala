package com.home.testing

import org.scalatest.{ FunSuite, Matchers }
import com.home.collections.SetC

class SetCTestSuite extends FunSuite with Matchers {
  private def set = SetC
  /**
    * Tests to check the empty set funcionality
    */
  test("Checking an elemnt in an empty set should return false") {
    set.empty shouldBe a[SetC]
  }

  /**
    * Test to check the add functionality on emptysets
    */
  test("adding an element on an empty set should produce a NonEmpty set") {
    val first = randomString
    val second = randomString
    set.empty.add(first) shouldBe a[SetC]
    set.empty.add(first) shouldBe a[SetC.NonEmpty]

    val setWithOneElement = set.empty.add(first)
    setWithOneElement(first) shouldBe true
    setWithOneElement(second) shouldBe false

    val setWithTwoElements = set.empty.add(first).add(second)
    setWithTwoElements(first) shouldBe true
    setWithTwoElements(second) shouldBe true
  }

  /**
    * Test to check the remove functionality on emptysets
    */
  test("remove on an empty set should produce an Empty set") {
    val first = randomString
    val second = randomString
    val third = randomString
    val fourth = randomString

    set.empty.remove(first).size(0) shouldBe 0

    val removedOneElement = set.empty.add(first).remove(first)
    removedOneElement(first) shouldBe false
    removedOneElement(second) shouldBe false

    val removedTwoElements = set.empty.add(first).add(second).remove(first)
    removedTwoElements(first) shouldBe false
    removedTwoElements(second) shouldBe true

    val setToCheckTheNullElements = set.add(first).add(second).add(second).add(third).add(fourth)
    // setToCheckTheNullElements(null) shouldBe false
    setToCheckTheNullElements.size(0) shouldBe 4
    println(setToCheckTheNullElements.size(0))

  }
  /**
    * Test to check the duplicate handling in SetC
    */
  test("Duplicate elements should not exists in Sets") {
    val first = randomString
    val second = randomString

    val setWithDuplicates = set.empty.add(first).add(first).add(second)
    setWithDuplicates.size(0) shouldBe 2
  }

  test("calling empty on a NonEmpty set should yield an empty Set") {
    val first = randomString
    val second = randomString

    val nonEmptySet = set.add(first).add(second)
    val nonEmptyTurnedEmpty = nonEmptySet.empty

    nonEmptySet(first) shouldBe true
    nonEmptySet(second) shouldBe true
    nonEmptyTurnedEmpty(first) shouldBe false
    nonEmptyTurnedEmpty(second) shouldBe false
    nonEmptyTurnedEmpty.size(0) shouldBe 0
  }

  def randomString: String = scala.util.Random.alphanumeric.take(5).mkString
}