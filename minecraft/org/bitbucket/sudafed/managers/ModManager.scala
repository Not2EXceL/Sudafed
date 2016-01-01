package org.bitbucket.sudafed.managers

import com.google.common.eventbus.Subscribe
import org.bitbucket.sudafed.Sudafed
import org.bitbucket.sudafed.events.EventKeyPress
import org.bitbucket.sudafed.mod.Mod
import org.bitbucket.sudafed.mod.mods._
import org.lwjgl.input.Keyboard

import scala.collection.mutable.ArrayBuffer

/**
  * @author sl
  */
class ModManager {
  Sudafed.eventBus.register(this)

  val shit = List(new ExampleMod, new HUD, new ChestStealer, new Chameleon, new Sprint, new Velocity)
  val mods = ArrayBuffer[Mod]()

  def loadMods(){
    mods.clear()
    for(s <- shit){
      mods += s
    }
  }

  @Subscribe
  def toggleCheck(eventKeyPress: EventKeyPress){
    for(s <- shit){
      if(Keyboard.isKeyDown(s.key)){
        s.toggle
        if(s.state){
          Sudafed.eventBus.register(s)
        }else{
          Sudafed.eventBus.unregister(s)
        }
      }
    }
  }
}
