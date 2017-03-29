package me.adam077x.frostbite.module.mods;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.event.Event;
import me.adam077x.frostbite.event.events.EventSendPacket;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.network.Packet;

public class Blink extends Module{

	public Blink() {
		super("Blink", Keyboard.KEY_B, Category.MOVEMENT);
	}
	public void onEnable() {
		Packets.clear();
	}
	
	public void onDisable() {
		for(Packet p : Packets) {
			Wrapper.mc.thePlayer.sendQueue.addToSendQueue(p);
		}
		
		Packets.clear();
	}

	public ArrayList<Packet> Packets = new ArrayList<Packet>();
	public void onEvent(Event e) {
		if(e instanceof EventSendPacket) {
			Packets.add(((EventSendPacket) e).packet);
			((EventSendPacket) e).cancel = true;
		}
	}
}
