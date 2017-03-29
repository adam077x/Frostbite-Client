package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;
import net.minecraft.network.play.client.C03PacketPlayer;

public class Mhop extends Module{
	
	public static float speed = -0.5F;
	
	public Mhop() {
		super("Mhop", Keyboard.KEY_Y, Category.MOVEMENT);
	}

	public void onEnable() {
		Wrapper.mc.thePlayer.onGround = true;
	}
	
	public void onUpdate() {
		if(!Wrapper.mc.thePlayer.isEating() && !Wrapper.mc.thePlayer.isOnLadder()) {
		if(Wrapper.mc.thePlayer.onGround) {
			Wrapper.mc.thePlayer.jump();
		}else {
			Wrapper.mc.thePlayer.motionY = speed;
		}
	}
	}
	
	public void onDisable() {
		
	}
}