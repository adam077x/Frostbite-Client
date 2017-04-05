package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Flight extends Module{

	public Flight() {
		super("Flight", Keyboard.KEY_F, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		
		Wrapper.mc.thePlayer.onGround = false;
		Wrapper.mc.thePlayer.fallDistance = 0;
		
		Wrapper.mc.thePlayer.motionX = 0;
		Wrapper.mc.thePlayer.motionY = 0;
		Wrapper.mc.thePlayer.motionZ = 0;
		
		Wrapper.mc.thePlayer.jumpMovementFactor = 0.75f;
		if(Wrapper.mc.gameSettings.keyBindJump.pressed) {
			Wrapper.mc.thePlayer.motionY += 0.75f;
		}
		if(Wrapper.mc.gameSettings.keyBindSneak.pressed) {
			Wrapper.mc.thePlayer.motionY -= 0.75f;
		}
	}
	
}
