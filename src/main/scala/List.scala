package org.acl

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class List {
  private val _list: ListBuffer[Int] = mutable.ListBuffer[Int]()

  def list: ListBuffer[Int] = _list

  def addElement(element: Option[Int]): Unit = {
    if (element.isDefined)
      list += element.get
    else if (element.isEmpty)
      throw new IllegalArgumentException("Cannot add empty element")
  }

  def isElementPresent(element: Option[Int]): Boolean = {
    if (element.isEmpty)
      throw new IllegalArgumentException("Cannot check for empty element")
    list.contains(element.get)
  }

  def removeElement(element: Option[Int]): Unit = {
    if (element.isEmpty)
      throw new IllegalArgumentException("Cannot remove empty element")
    list -= element.get
  }
  
  def getFirstElement: Int = {
    if (list.isEmpty)
      throw new IllegalArgumentException("List is empty")
    list.head
  }
  def getLastElement: Int = {
    if (list.isEmpty)
      throw new IllegalArgumentException("List is empty")
    list.last
  }
  
  def getIndexOfElement(element: Option[Int]): Int = {
    if (element.isEmpty)
      throw new IllegalArgumentException("Cannot get index of empty element")
    list.indexOf(element.get)
  }
}
