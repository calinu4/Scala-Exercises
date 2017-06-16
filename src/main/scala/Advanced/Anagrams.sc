import java.io._
import java.util
import java.util.Collections


object Reader {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val r = new Reader
    r.readFromFile()
    r.sortWordsList()
    System.out.println("\n" + "The sorted list: ")
    r.displayWords(r.sortedwords)
    r.buildHashMap()
    // This will display the word with most anagrams
    r.returnWord()
    // System.out.println(r.areAnagrams("dorm", "mord"));
  }
}

class Reader {
  val words = new util.ArrayList[String]
  val sortedwords = new util.ArrayList[String]
  var newList = null
  val map1 = new util.HashMap[String, util.List[String]]

  /*
     * Display the word or two words with most anagrams
     */ def returnWord(): Unit = {
    var areSame = true
    // used to retrieve each list from the hashmap
    var l1 = null
    val results = new util.ArrayList[String]
    // the maximum number of anagrams
    var max = 0
    // the number of anagrams for each array
    val counts = new util.ArrayList[Integer]
    // it will be used to store the index of counts where the maximum
    // anagrams are located
    val indexes = new util.ArrayList[Integer]
    var i = 0
    while (i < map1.size) {
      l1 = map1.get(newList.get(i)) // get a list of number of anagrams

      // for a word
      counts.add(l1)
      if (l1.size >= max) {
        max = l1.size
        // save the max noo of anagrams
      }

      {
        i+= 1

      }
    }
    var i = 0
    while ( {
      i < counts.size
    }) {
      if (max == counts.get(i)) indexes.add(i)

      {
        i += 1; i - 1
      }
    }
    var j = 0
    while ( {
      j < indexes.size
    }) {
      results.add(newList.get(indexes.get(j))) // grab the keywords that

      // have the most
      // anagrams based on the
      // indexes we saved
      // above

      {
        j += 1; j - 1
      }
    }
    // If there is only one word with maximum anagrams just display it
    if (results.size <= 1) {
      l1 = map1.get(results.get(0))
      System.out.println("The word with most anagrams is: " + results.get(0) + l1.toString)
    }
    else {
      val maxLength = results.get(0).length
      var position = 0
      var i = 0
      while ( {
        i < results.size
      }) {
        if (results.get(i).length != maxLength) {
          areSame = false
          if (results.get(i).length > maxLength) position = i
        }

        {
          i += 1; i - 1
        }
      }
      if (areSame) {
        var i = 0
        while ( {
          i < results.size
        }) {
          l1 = map1.get(results.get(i))
          System.out.println("The word with most anagrams is: " + results.get(i) + l1.toString)

          {
            i += 1; i - 1
          }
        }
      }
      else { // display only the last one which is the longest
        l1 = map1.get(results.get(position))
        System.out.println("The word with most anagrams is: " + results.get(position) + l1.toString)
      }
    }
  }

  /*
     * Build only a list with unique sorted words Build a hash map to store the
     * lists of anagrams for each sorted unique word
     */ def buildHashMap(): Unit = {
    System.out.println("\n \n" + "Unique Sorted List: ")
    // Create a sorted list with unique words
    newList = new util.ArrayList[String](new util.HashSet[String](sortedwords))
    import scala.collection.JavaConversions._
    for (s <- newList) {
      System.out.println(s)
    }
    // Build a hash map with key=sorted word and values=array of anagrams
    var i = 0
    while ( {
      i < newList
    }) {
      checkAnagrams(newList.get(i))

      {
        i += 1; i - 1
      }
    }
  }

  @throws[IOException]
  @throws[FileNotFoundException]
  def readFromFile(): Unit = {
    System.out.println("Unsorted List from file: ")
    try {
      val file = new File("data.txt")
      val br = new BufferedReader(new FileReader(file))
      var st = null
      while ( {
        (st = br.readLine) != null
      }) {
        words.add(st)
        println(st)
      }
    } catch {
      case e: FileNotFoundException =>
        e.printStackTrace()
      case e: IOException =>
        e.printStackTrace()
    }
  }

  def displayWords(w: util.List[String]): Unit = {
    import scala.collection.JavaConversions._
    for (s <- w) {
      System.out.println(s)
    }
  }

  def sortWordsList(): Unit = {
    val s = null
    var i = 0
    while ( {
      i < words.size
    }) { // add sorted words into the sorted words array
      sortedwords.add(returnSortedWord(words.get(i)))

      {
        i += 1; i - 1
      }
    }
  }

  def returnSortedWord(s1: String): String = {
    val chars = s1.toCharArray
    util.Arrays.sort(chars)
    s1 = new String(chars)
    s1
  }

  /*
     * Check if two strings are anagrams
     */ def areAnagrams(one: String, two: String): Boolean = {
    val map = new util.HashMap[Character, Integer]
    for (c <- one.toCharArray) {
      if (map.containsKey(c)) map.put(c, map.get(c) + 1)
      else map.put(c, 1)
    }
    for (c <- two.toCharArray) {
      if (!map.containsKey(c)) return false
      else {
        map.put(c, map.get(c) - 1)
        if (map.get(c) eq 0) map.remove(c)
      }
    }
    map.isEmpty
  }

  /*
     * Check how many anagrams are in the list
     */ def checkAnagrams(one: String): Unit = {
    val temp = new util.ArrayList[String]
    import scala.collection.JavaConversions._
    for (w <- words) {
      if (areAnagrams(one, w)) temp.add(w)
    }
    map1.put(one, temp)
    // return map.isEmpty();
  }
}