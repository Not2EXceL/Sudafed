package org.bitbucket.sudafed.mod

import net.minecraft.client.Minecraft

abstract class Mod(label: String, bind: Int, flavor: Int) {

  var (name, state, key, color, visible) = (label, false, key, flavor, true)
  val mc = Minecraft.getMinecraft

  def toggle = state = !state

  Sudafed.printSudafed("Loaded mod " + name)
}