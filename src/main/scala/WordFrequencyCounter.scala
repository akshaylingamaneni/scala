package org.acl

class WordFrequencyCounter {
  private var wordCount: Map[String, Int] = Map()

  def addWord(word: String): Unit = {
    if (wordCount.contains(word)) {
      wordCount += (word -> (wordCount(word) + 1))
    } else {
      wordCount += (word -> 1)
    }
  }

  def getWordCount(word: String): Int = {
    if (wordCount.contains(word)) {
      wordCount(word)
    } else {
      0
    }
  }
  
  def parseString(input: String): List[String] = {
    // Remove punctuation and split the string into words
    val words = input.replaceAll("[^a-zA-Z0-9\\s]","").split("\\W+").toList
    words
  }
  
  def getTopNFrequentWords(n: Int): List[String] = {
    // Sort the words by frequency and return the top N
    wordCount.toList.sortBy(-_._2).take(n).map(_._1)
  }
}
