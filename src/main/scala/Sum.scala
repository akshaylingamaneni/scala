package org.acl

class Sum {
  def sum(a: Option[Int], b: Option[Int]): Int = {
    if(a.isEmpty && b.isEmpty) 0
    else if(a.isEmpty) b.get
    else if(b.isEmpty) a.get
    else a.get + b.get
  }
}

object Main extends App {
    val sumInstance = new Sum()
    println(sumInstance.sum(Some(1), Some(2)))
}