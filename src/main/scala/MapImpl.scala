package org.acl
import scala.collection.mutable
import scala.collection.mutable.Map
class MapImpl {
  var _map: Map[Int, Int] = Map()

  def getMap: Map[Int, Int] = _map

  def addElement(key: Int, value: Int): Unit = {
    _map += (key -> value)
  }

  def isElementPresent(key: Int): Boolean = {
    _map.contains(key)
  }
  
  def removeElement(key: Int): Unit = {
    _map -= key
  }
  
  def getFirstElement: (Int, Int) = {
    if(_map.isEmpty)
      throw new NullPointerException("Map is empty")
    _map.head 
  }
  
  def getLastElement: (Int, Int) = {
    if(_map.isEmpty)
      throw new NullPointerException("Map is empty")
    _map.last 
  }
  
  def getKeyOfFirstElement: Int = {
    if(_map.isEmpty)
      throw new NullPointerException("Map is empty")
    _map.head._1
  }
  def getKeyOfLastElement: Int = {
    if(_map.isEmpty)
      throw new NullPointerException("Map is empty")
    _map.last._1
  }
  
  def getSize: Int = {
    _map.size
  }
  
  def getValueOfKey(key: Int): Int = {
    if(!_map.contains(key))
      throw new NullPointerException("Key not found")
    _map(key)
  }
}
