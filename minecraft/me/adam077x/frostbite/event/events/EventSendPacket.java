package me.adam077x.frostbite.event.events;

import me.adam077x.frostbite.event.Event;
import net.minecraft.network.Packet;

public class EventSendPacket extends Event{
	public EventSendPacket(Packet packet) {
		this.packet = packet;
	}
	public Packet packet;
	public boolean cancel = false;
}
