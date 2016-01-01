package org.bitbucket.sudafed.events

import net.minecraft.network.Packet

/**
  * @author sl
  */
class EventPacket(var packet: Packet, outgoing: Boolean) {
  var (cancelled, p, og) = (false, packet, outgoing)

  def isIncoming = !outgoing
}
