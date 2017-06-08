
def generatePrimes(maxNum: Int): Unit = {
   val isPrime:Array[Boolean] = new Array[Boolean](maxNum+1)
  var i = 2
  while (i <= maxNum) {
    isPrime(i) = true
    i = i + 1
  }

  // mark non-primes <= N using Sieve of Eratosthenes
  i = 2
  while (i <= Math.sqrt(maxNum)) { // if i is prime, then mark multiples of i as nonprime
    if (isPrime(i)) {
      var j = i

      while (i * j <= maxNum){ isPrime(i * j) = false
        j += 1}
      }
      i += 1;
  }

  // count primes
  var primes = 0
   i = 2
  while (i <= maxNum) {
    if (isPrime(i)) {
      primes += 1
    }
    i += 1;
  }
  println("The number of primes <= " + maxNum + " is " + primes)
}

println("Counting between 1 and 3 millions....")
generatePrimes(3000000)
//println("Counting between 1 and 2 billions....")
//generatePrimes(200000000)

