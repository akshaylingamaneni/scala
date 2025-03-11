package org.acl

import scala.collection.mutable

class TwoSum {

  def twoSum(nums: Option[Array[Int]], target: Option[Int]): Array[Int] = {
    if (nums.isEmpty || target. isEmpty) {
      throw new NullPointerException("Input array or target is null")
    }
    val map = mutable.Map[Int, Int]()
    for (i <- nums.get.indices) {
      val diff = target.get - nums.get(i)
      if (map.contains(diff)) {
        return Array(map(diff), i)
      } else {
        map.put(nums.get(i), i)
      }
    }
    Array(-1, -1) // Return an invalid result if no solution is found
  }
}
