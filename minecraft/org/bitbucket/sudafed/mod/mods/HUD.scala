package org.bitbucket.sudafed.mod.mods

import com.google.common.eventbus.Subscribe
import org.bitbucket.sudafed.Sudafed
import org.bitbucket.sudafed.events.EventHUDRender
import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

/**
  * @author sl
  */
class HUD extends Mod("HUD", Keyboard.KEY_NONE, 0xFFFFFF) {
  state = true
  visible = false
  Sudafed.eventBus.register(this)

  @Subscribe
  def onHUDRender(event: EventHUDRender) {
    var y = 12
    if (mc.gameSettings.showDebugInfo) return
    mc.fontRendererObj.func_175063_a("Sudafed", 2, 2, 0xFFFFFF)
    for (mods <- Sudafed.modManager.mods) {
      if (mods.state && mods.visible) {
        mc.fontRendererObj.func_175063_a(mods.name, 2, y, mods.color)
        y += 10
      }
    }
  }
}
