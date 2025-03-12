package org.acl

import org.scalatest.BeforeAndAfter
import org.scalatest.funsuite.AnyFunSuite

class WordFrequencyCounterSpec extends AnyFunSuite with BeforeAndAfter {
  var wordFrequencyCounter: WordFrequencyCounter = _

  before {
    wordFrequencyCounter = new WordFrequencyCounter()
  }

  test("WordFrequencyCounter should add a word and update its count") {
    wordFrequencyCounter.addWord("hello")
    assert(wordFrequencyCounter.getWordCount("hello") == 1)
    wordFrequencyCounter.addWord("hello")
    wordFrequencyCounter.addWord("world")
    wordFrequencyCounter.addWord("hello")
    assert(wordFrequencyCounter.getWordCount("hello") == 3)
    assert(wordFrequencyCounter.getWordCount("world") == 1)
  }

  test("WordFrequencyCounter should return list of words from a string") {
    val input = "Hello World This is a test"
    val expectedOutput = List("Hello", "World", "This", "is", "a", "test")
  }

  test("WordFrequencyCounter should remove punctuation and split words") {
    val input = "Hello, World! This is a test."
    val expectedOutput = List("Hello", "World", "This", "is", "a", "test")
    assert(wordFrequencyCounter.parseString(input) == expectedOutput)
  }
  test("WordFrequencyCounter should return the top N frequent words") {
    wordFrequencyCounter.addWord("hello")
    wordFrequencyCounter.addWord("world")
    wordFrequencyCounter.addWord("hello")
    wordFrequencyCounter.addWord("scala")
    wordFrequencyCounter.addWord("scala")
    wordFrequencyCounter.addWord("scala")
    val topWords = wordFrequencyCounter.getTopNFrequentWords(2)
    assert(topWords.size == 2)
    assert(topWords.contains("scala"))
    assert(topWords.contains("hello"))
  }
}