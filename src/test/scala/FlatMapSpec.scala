package org.acl

import FlatMap.Item

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

import scala.collection.immutable.List

class FlatMapSpec extends AnyFunSuite with BeforeAndAfter {
  var flatMapInstance: FlatMap = _
  // Use FlatMap#Order to reference the inner type
  var orders: List[FlatMap.Order] = _
  before {
    flatMapInstance = new FlatMap()
    // Initialize the orders list with some sample data
    orders = List(
      FlatMap.Order("order1", List(FlatMap.Item("item1", 10.0, 2),
        FlatMap.Item("item2", 20.0, 0))),
      FlatMap.Order("order2", List(FlatMap.Item("item3", 30.0, 1),
        FlatMap.Item("item4", 40.0, 3)))
    )
  }

  test("FlatMap should flatten orders into a single list of items") {
    val flattenedItems = flatMapInstance.flatMapOrders(orders)
    assert(flattenedItems.size == 4)
    assert(flattenedItems.contains(Item("item1", 10.0, 2)))
    assert(flattenedItems.contains(Item("item2", 20.0, 0)))
    assert(flattenedItems.contains(Item("item3", 30.0, 1)))
    assert(flattenedItems.contains(Item("item4", 40.0, 3)))
  }

  test("Filter out items with zero quantity") {
    val filteredItems = flatMapInstance.filterZeroQuantityItems(flatMapInstance.flatMapOrders(orders))
    assert(filteredItems.size == 3)
    for (item <- filteredItems) {
      assert(item.quantity > 0)
    }
  }

  test("Transform each items to get total price of each item") {
    val transformedItems = flatMapInstance.transformToTotalPrice(flatMapInstance.filterZeroQuantityItems(flatMapInstance.flatMapOrders(orders)))
    assert(transformedItems.size == 3)
    for (item <- transformedItems) {
      assert(item > 0)
    }
    assert(transformedItems.contains(20))
    assert(transformedItems.contains(30))
    assert(transformedItems.contains(120))
  }
}
