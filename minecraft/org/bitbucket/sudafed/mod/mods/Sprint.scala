package org.bitbucket.sudafed.mod.mods

import com.google.common.eventbus.Subscribe
import org.bitbucket.sudafed.Sudafed
import org.bitbucket.sudafed.events.EventPreUpdate
import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

/**
  * @author sl
  */
class Sprint extends Mod("Sprint", Keyboard.KEY_B, 0x820BBB){
  Sudafed.eventBus.register(this)

  @Subscribe
  def preUpdate(event: EventPreUpdate) {
    mc.thePlayer.setSprinting(canSprint)
  }
  def canSprint = mc.thePlayer.movementInput.moveForward > 0 && mc.thePlayer.movementInput.moveStrafe != 0 || mc.thePlayer.movementInput.moveForward > 0 && !mc.thePlayer.isSneaking && !mc.thePlayer.isCollidedHorizontally || mc.playerController.isInCreativeMode
}
