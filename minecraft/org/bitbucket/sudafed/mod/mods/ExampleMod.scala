package org.bitbucket.sudafed.mod.mods

import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

class ExampleMod extends Mod("Example", Keyboard.KEY_NONE, 0xFFFFFFFF) {
  def shit = mc.shutdown
}
