package org.acl

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class ListSpec extends AnyFunSuite with BeforeAndAfter {
var listInstance: ListImpl = _
before {
  listInstance = new ListImpl()
  listInstance.addElement(Some(1))
  listInstance.addElement(Some(2))
  listInstance.addElement(Some(3))
}
  test("List should return the first element") {
    assert(listInstance.isElementPresent(Some(1)))
  }
  test ("List should return the last element") {
   assert(listInstance.isElementPresent(Some(3)))
  }
  test("List should return the index of the element") {
   assert(listInstance.getIndexOfElement(Some(2)) == 1)
  }
}
