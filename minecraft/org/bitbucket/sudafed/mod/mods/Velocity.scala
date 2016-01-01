package org.bitbucket.sudafed.mod.mods

import com.google.common.eventbus.Subscribe
import net.minecraft.network.play.server.S12PacketEntityVelocity
import org.bitbucket.sudafed.events.EventPacket
import org.bitbucket.sudafed.mod.Mod
import org.lwjgl.input.Keyboard

/**
  * @author sl
  */
class Velocity extends Mod("Velocity", Keyboard.KEY_NONE, 0xD0D0D0){
  var velReduction: Int = 0
  name = "Velocity [" + velReduction + "]"

  @Subscribe
  def eventPacket(event: EventPacket){
    if(event.outgoing) return
    if(event.packet.isInstanceOf[S12PacketEntityVelocity]){
      val vel = event.packet.asInstanceOf[S12PacketEntityVelocity]
      if(vel.func_149412_c != mc.thePlayer.getEntityId) return
      vel.setMotX(vel.func_149411_d * velReduction)
      vel.setMotY(vel.func_149410_e * velReduction)
      vel.setMotZ(vel.func_149409_f * velReduction)
    }
  }
}
