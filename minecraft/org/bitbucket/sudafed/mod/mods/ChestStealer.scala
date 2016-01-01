package org.bitbucket.sudafed.mod.mods

import com.google.common.eventbus.Subscribe
import net.minecraft.client.gui.inventory.GuiChest
import org.bitbucket.sudafed.events.EventPreUpdate
import org.bitbucket.sudafed.mod.Mod
import org.bitbucket.sudafed.util.Timer
import org.lwjgl.input.Keyboard

/**
  * @author sl
  */
class ChestStealer extends Mod("Chest Stealer", Keyboard.KEY_C, 0xFFFFEE){
  val timer = new Timer
  @Subscribe
  def preUpdate(event: EventPreUpdate){
    if(mc.currentScreen.isInstanceOf[GuiChest]){
        val chest = mc.currentScreen.asInstanceOf[GuiChest]
        if (empty(chest) || inventoryFull) mc.thePlayer.closeScreen()
        for (index <- 0 until chest.lowerChestInventory.getSizeInventory) {
          val stack = chest.lowerChestInventory.getStackInSlot(index)
          if (stack == null)
            if (timer.hasReached(150L)) {
              mc.playerController.windowClick(chest.inventorySlots.windowId, index, 0, 1, mc.thePlayer)
              timer.reset
            }
        }
    }
  }
  def empty(chest: GuiChest) = {
    var index = 0
    while (index <= chest.lowerChestInventory.getSizeInventory) {
      val stack = chest.lowerChestInventory.getStackInSlot(index)
      if (stack != null) false
      index += 1
    }
    true
  }
  def inventoryFull = {
    var index = 9
    while (index <= 44) {
      val stack = mc.thePlayer.inventoryContainer.getSlot(index).getStack
      if (stack == null) false
      index += 1
    }
    true
  }
}
