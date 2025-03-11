package org.acl

import scala.util.control.Breaks.break

class ArrayImpl {
  var array: Array[Option[Int]] = Array.fill(10)(None)

  def size: Int = {
    array.length
  }

  def addElement(element: Option[Int]): Unit = {
    if(!array(array.length - 1).isEmpty){
        throw new ArrayIndexOutOfBoundsException("Array is full")
    }
    for(i <- array.indices){
      if(array(i).isEmpty){
          array(i) = element
          break
      }
    }
  }

  def getElement(index: Int): Option[Int] = {
    if(index <0 || index >= array.length){
      throw new ArrayIndexOutOfBoundsException("Index out of bounds")
    }
    array(index)
  }
  def removeElementAtIndex(index: Int): Unit = {
    if(index <0 || index >= array.length){
      throw new ArrayIndexOutOfBoundsException("Index out of bounds")
    }
    array(index) = None
  }

  def isElementPresent(element: Option[Int]): Boolean = {
    if(array.isEmpty){
      throw new NullPointerException("Array is empty")
    }
    for(i <- array.indices){
      if(array(i) == element){
        return true
      }
    }
    false
  }

}
