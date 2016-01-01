package org.bitbucket.sudafed.mod.mods

import org.bitbucket.sudafed.Sudafed
import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

class ExampleMod extends Mod("Example", Keyboard.KEY_NONE, 0xFFFFFFFF) {
  Sudafed.eventBus.register(this)
  def shit = mc.shutdown

}
