package org.acl

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.BeforeAndAfter

class MapImplSpec extends AnyFunSuite with BeforeAndAfter {
  var mapInstance: MapImpl = _
  before {
    mapInstance = new MapImpl()
    mapInstance.addElement(1, 2)
    mapInstance.addElement(2, 3)
    mapInstance.addElement(3, 4)
  }

  test("should be able to get the map"){
    assert(mapInstance.getMap == Map(1 -> 2, 2 -> 3, 3 -> 4))
  }
  test("should be able to add an element"){
    mapInstance.addElement(4, 5)
    assert(mapInstance.isElementPresent(4))
  }
  test("should be able to check if an element is present"){
    assert(mapInstance.isElementPresent(1))
  }
  test("should be able to remove an element"){
    assert(mapInstance.isElementPresent(1))
    mapInstance.removeElement(1)
    assert(!mapInstance.isElementPresent(1))
  }
  test("should be able to get the first element"){
    assert(mapInstance.getFirstElement == (1, 2))
  }
  test("should be able to get the last element"){
    assert(mapInstance.getLastElement == (3, 4))
  }
  test("should be able to get the key of the first element"){
    assert(mapInstance.getKeyOfFirstElement == 1)
  }
  test("should be able to get the key of the last element"){
    assert(mapInstance.getKeyOfLastElement == 3)
  }
  test("should be able to get the size of the map"){
    assert(mapInstance.getSize == 3)
  }
  test("should be able to get the value of a key"){
    assert(mapInstance.getValueOfKey(1) == 2)
  }
}
