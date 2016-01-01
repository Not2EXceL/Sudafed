package org.bitbucket.sudafed.mod.mods

import com.google.common.eventbus.Subscribe
import org.bitbucket.sudafed.events.EventPreUpdate
import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

/**
  * @author sl
  */
class Chameleon extends Mod("Chameleon", Keyboard.KEY_Z, 0xA1FF00){
  @Subscribe
  def preUpdate(eventOnUpdate: EventPreUpdate){
    if(mc.thePlayer.moveForward == 0 && mc.thePlayer.moveStrafing == 0 && !mc.thePlayer.capabilities.isFlying)
      mc.gameSettings.keyBindSneak.pressed = true
    else if(!Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.keyCode))
      mc.gameSettings.keyBindSneak.pressed = false
  }

  override def postToggle = if(!state && !Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.keyCode)) mc.gameSettings.keyBindSneak.pressed = false

}
