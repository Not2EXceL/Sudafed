package org.bitbucket.sudafed

import com.google.common.eventbus.EventBus
import org.bitbucket.sudafed.managers.ModManager

object Sudafed {
  val eventBus = new EventBus
  val modManager = new ModManager

  def printSudafed(str: String) = println("[SUDAFED]: " + str)
  
  def setup {
    modManager.loadMods
    Sudafed.printSudafed("Loaded " + modManager.mods.size + " mod(s)")
    printSudafed("Setup complete!")
  }
}
