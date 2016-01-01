package org.bitbucket.sudafed.events

import net.minecraft.network.Packet

/**
  * @author sl
  */
class EventPacket(var packet: Packet, og: Boolean) {
  var (cancelled, p, outgoing) = (false, packet, og)

  def isIncoming = !og
}
