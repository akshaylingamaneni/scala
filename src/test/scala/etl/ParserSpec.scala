package org.acl
package etl

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class ParserSpec extends AnyFunSuite with BeforeAndAfter{
  var parser: Parser = _

  before {
    parser = new Parser()
  }

  test("Parser should load CSV file and parse data correctly") {
    val data = parser.readCsv("src/test/resources/sales.csv")
    assert(data.head.date == "2024-03-15T10:30:00Z")
    assert(data.head.store_id == "store123")
    assert(data.head.product_id == "prod456")
    assert(data.head.quantity == 2)
    assert(data.head.price == 29.99)
  }

  test("Parser grouping by 15 min interval") {
    val data = parser.readCsv("src/test/resources/sales.csv")
    val groupedData = parser.groupBy15MinuteInterval(data)
    assert(groupedData.size == 3) // Assuming all data falls into the same 15 min interval
  }
}
