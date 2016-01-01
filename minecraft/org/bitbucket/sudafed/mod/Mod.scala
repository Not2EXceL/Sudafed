package org.bitbucket.sudafed.mod

import net.minecraft.client.Minecraft
import org.bitbucket.sudafed.Sudafed

abstract class Mod(label: String, bind: Int, flavor: Int) {

  var (state, visible, name, key, color) = (false, true, label, bind, flavor)
  val mc = Minecraft.getMinecraft

  def postToggle(){}

  def toggle(){
    state = !state
    postToggle()
  }

  Sudafed.printSudafed("Loaded " + name)
}