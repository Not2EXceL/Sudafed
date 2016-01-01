package org.bitbucket.sudafed.util

import net.minecraft.client.Minecraft
import net.minecraft.entity.Entity
import net.minecraft.util.MathHelper

/**
  * @author sl
  */
trait EntityUtils {
  val mc = Minecraft.getMinecraft

  def entityRotations(target: Entity): Array[Float] = {
    val x = target.posX - mc.thePlayer.posX
    val y = target.posY + target.getEyeHeight / 1.3 - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight)
    val z = target.posZ - mc.thePlayer.posZ
    val fl = MathHelper.sqrt_double(x * x + z * z)
    val yaw = (Math.atan2(z, x) * 180.0D / Math.PI).toFloat - 90.0F
    val pitch = -(Math.atan2(y, fl) * 180.0D / Math.PI).toFloat
    Array(yaw, pitch)
  }

  def faceEntity(target: Entity){
    val rotations = entityRotations(target)
    if(rotations != null){
      mc.thePlayer.rotationYaw = rotations(0)
      mc.thePlayer.rotationPitch = rotations(1) + 14F
    }
  }
}
