package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Nofall extends Module{

	public Nofall() {
		super("Nofall", Keyboard.KEY_NONE, Category.MOVEMENT);
	}
	
	public void onEnable() {
	}
	
	public void onUpdate() {
			if(Wrapper.mc.thePlayer.fallDistance > 2F){
				Wrapper.mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
			
	}
	
	public void onDisable() {
		Wrapper.mc.thePlayer.onGround = false;
	}
}
