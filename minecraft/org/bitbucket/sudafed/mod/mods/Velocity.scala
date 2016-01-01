package org.bitbucket.sudafed.mod.mods

import com.google.common.eventbus.Subscribe
import net.minecraft.network.play.server.S12PacketEntityVelocity
import org.bitbucket.sudafed.Sudafed
import org.bitbucket.sudafed.events.EventPacket
import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

/**
  * @author sl
  */
class Velocity extends Mod("Velocity", Keyboard.KEY_NONE, 0xD0D0D0){
  Sudafed.eventBus.register(this)
  state = true
  var velReduction: Int = 0
  name = "Velocity [" + velReduction + "]"

  @Subscribe
  def eventPacket(event: EventPacket){
    if(event.og) return
    if(event.packet.isInstanceOf[S12PacketEntityVelocity]){
      val v = event.packet.asInstanceOf[S12PacketEntityVelocity]
      if(v.func_149412_c != mc.thePlayer.getEntityId) return
      v.setMotX(v.func_149411_d() * velReduction)
      v.setMotY(v.func_149410_e() * velReduction)
      v.setMotZ(v.func_149409_f() * velReduction)
    }
  }
}
