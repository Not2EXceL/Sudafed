package org.bitbucket.sudafed.util

/**
  * @author sl
  */
class Timer {
  var lastTime = getSysTime

  def getSysTime: Long = System.nanoTime() / 1000000

  def getDifference: Long = getSysTime - lastTime

  def reset {
    lastTime = getSysTime
  }

  def hasReached(milliseconds: Long): Boolean = getDifference >= milliseconds

}
