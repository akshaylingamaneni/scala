package org.acl

import org.scalatest.funsuite.AnyFunSuite

class SumSpec extends AnyFunSuite {
  test("Sum should add two numbers") {
    val sumInstance = new Sum()
    assert(sumInstance.sum(Some(1), Some(2)) == 3)
  }
  test("Sum should handled null values") {
    val sumInstance = new Sum()
    assert(sumInstance.sum(Some(1), None) == 1)
    assert(sumInstance.sum(None, Some(2)) == 2)
    assert(sumInstance.sum(None, None) == 0)
  }
}
