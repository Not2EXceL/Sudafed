package org.bitbucket.sudafed.managers

import org.bitbucket.sudafed.mod.Mod
import org.bitbucket.sudafed.mod.mods.ExampleMod

import scala.collection.mutable

/**
  * @author sl
  */
class ModManager {
  val mods = mutable.MutableList[Mod]()

  def loadMods() {
    registerMod(new ExampleMod)
  }

  def registerMod(mod: Mod){
    mods += mod
  }
}
