package org.acl
package etl

import java.time.LocalDateTime
import scala.io.Source.fromFile

case class Sale(date: String, store_id: String, product_id: String, quantity: Int, price: Double)

case class WindowStats(
                        storeSales: Map[String, Double],
                        productQuantities: Map[String, Int],
                        transactionCount: Int
                      )
class Parser {

  def readCsv(filePath: String): List[Sale] = {
    val source = fromFile(filePath)
    val lines = source.getLines().toList
    source.close()
    var data = List[Sale]()
    for ((line, index) <- lines.zipWithIndex) {
      if (line.nonEmpty && index > 0) {
        val columns = line.split(",")
        if (columns.length == 5) {
          val date = columns(0)
          val store_id = columns(1)
          val product_id = columns(2)
          val quantity = columns(3).toInt
          val price = columns(4).toDouble
          val sale = Sale(date, store_id, product_id, quantity, price)
          data = data :+ sale
        }
      }
    }
    data
  }

  def validateData(data: List[Sale]): List[Sale] = {
    data.filter(sale => sale.date.nonEmpty &&
      sale.store_id.nonEmpty &&
      sale.product_id.nonEmpty &&
      sale.quantity > 0
      && sale.price > 0)
  }

  def transformData(data: List[Sale]): List[Sale] = {
    data.map(sale => Sale(sale.date, sale.store_id, sale.product_id, sale.quantity, sale.price * sale.quantity))
  }

  def groupBy15MinuteInterval(data: List[Sale]): Map[String, List[Sale]] = {
    println("Grouping data by 15-minute intervals...")
    data.groupBy(sale => {
      val dateTime = LocalDateTime.parse(sale.date, java.time.format.DateTimeFormatter.ISO_DATE_TIME)
      val intervalStart = dateTime.minusMinutes(dateTime.getMinute % 15)
      intervalStart.format(java.time.format.DateTimeFormatter.ISO_DATE_TIME)
    })
  }

  def calculateWindowStats(data: Map[String, List[Sale]]): Map[String, WindowStats] = {
    data.map { case (window, sales) =>
      val storeSales = sales.groupBy(_.store_id).map { case (store, storeSales) =>
        store -> storeSales.map(_.price).sum
      }

      val productQuantities = sales.groupBy(_.product_id).map { case (product, productSales) =>
        product -> productSales.map(_.quantity).sum
      }

      val transactionCount = sales.size

      window -> WindowStats(
        storeSales,
        productQuantities,
        transactionCount
      )
    }
  }
}
