package org.bitbucket.sudafed.mod

object Sudafed {
  val modManager = new ModManager

  def printSudafed(str: String) = println("[SUDAFED]: " + str)
  
  def setup: Unit ={
    modManager.loadMods()
  }
}
