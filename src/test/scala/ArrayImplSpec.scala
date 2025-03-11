package org.acl

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class ArrayImplSpec extends AnyFunSuite with BeforeAndAfter {
  var arrayInstance: ArrayImpl = _
  before {
    arrayInstance = new ArrayImpl()
  }

  test("Array should return the size of the array") {
    assert(arrayInstance.size == 10)
  }

  test("Array if element is present") {
    assert(!arrayInstance.isElementPresent(Some(1)))
  }

  test("Array should add an element to the array") {
    arrayInstance.addElement(Some(1))
    assert(arrayInstance.isElementPresent(Some(1)))
  }
  test("Add an element to a full array") {
    assertThrows[ArrayIndexOutOfBoundsException] {
      for (i <- 1 to 10) {
        arrayInstance.addElement(Some(i))
      }
    }
  }
  test("Add element to an empty array") {
    arrayInstance = new ArrayImpl()
    arrayInstance.addElement(Some(1))
    assert(arrayInstance.isElementPresent(Some(1)))
  }
  test("Array should remove an element from the array") {
    arrayInstance.addElement(Some(1))
    arrayInstance.removeElementAtIndex(0)
    assert(!arrayInstance.isElementPresent(Some(1)))
  }
  test("Remove an element from an empty array") {
    assertThrows[ArrayIndexOutOfBoundsException] {
      arrayInstance.removeElementAtIndex(0)
    }
  }
  test("Remove an element from an index greater than the size of the array") {
    assertThrows[ArrayIndexOutOfBoundsException] {
      arrayInstance.removeElementAtIndex(10)
    }
  }
}

