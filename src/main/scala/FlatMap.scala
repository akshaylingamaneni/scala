package org.acl

import org.acl.FlatMap.Item

import scala.collection.immutable.List

object FlatMap {
  case class Item(name: String, price: Double, quantity: Int)

  case class Order(id: String, items: List[Item])
}

class FlatMap {
  /**
   * Problem: Process a list of orders where each order contains a list of items.
   * Requirements:
   * 1. Extract all items from all orders into a single flat list
   * 2. Filter out items with zero quantity
   * 3. Transform each item to include its total price (price * quantity)
   */

  def flatMapOrders(orders: List[FlatMap.Order]): List[FlatMap.Item] = {
    val mappedList = orders.map(order => order.items)
    mappedList.flatten
  }
  
  def filterZeroQuantityItems(orders: List[Item]) : List[Item] = {
    orders.filter(item => item.quantity > 0)
  }
  
  def transformToTotalPrice(orders: List[Item]): List[Int]  = {
    orders.map(item => (item.price * item.quantity).toInt)
  }

}
