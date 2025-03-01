package org.acl

class Divide {
  def divide(a: Option[Int], b: Option[Int]): Int = {
    if(b.isEmpty || b.get == 0) throw new NullPointerException("Cannot divide by zero")
    else if(a.isEmpty) 0
    else a.get / b.get
  }
}
