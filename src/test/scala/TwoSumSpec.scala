package org.acl

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class TwoSumSpec extends AnyFunSuite with BeforeAndAfter {
  var twoSumInstance: TwoSum = _
  var nums: Array[Int] = _
  var target: Int = _
  before {
    twoSumInstance = new TwoSum()
    nums = Array(2, 7, 11, 15)
    target = 9
  }

  test("TwoSum should return the correct indices for a valid input") {
    val result = twoSumInstance.twoSum(Some(nums), Some(target))
    assert(result.length == 2)
    assert(result(0) == 0)
    assert(result(1) == 1)
  }
  test("TwoSum should return -1, -1 for an invalid input") {
    val result = twoSumInstance.twoSum(Some(nums), Some(100))
    assert(result.length == 2)
    assert(result(0) == -1)
    assert(result(1) == -1)
  }

  test("TwoSum should throw NullPointerException for null input") {
    assertThrows[NullPointerException] {
      twoSumInstance.twoSum(null, Some(target))
    }
  }
}
