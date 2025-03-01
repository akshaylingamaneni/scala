package org.acl

import org.scalatest.funsuite.AnyFunSuite

class DivideSpec extends AnyFunSuite {

  test("Divide should divide two numbers") {
    val divideInstance = new Divide()
    assert(divideInstance.divide(Some(4), Some(2)) == 2)
    assert(divideInstance.divide(Some(4), Some(3)) == 1)
  }

  test("Divide should handle null values") {
    val divideInstance = new Divide()

    assertThrows[NullPointerException] {
      divideInstance.divide(Some(4), None)
    }
    assertThrows[NullPointerException] {
      divideInstance.divide(Some(4), Some(0))
    }
  }
}
