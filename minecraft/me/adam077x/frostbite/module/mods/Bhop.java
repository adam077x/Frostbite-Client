package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.command.BhopCmd;
import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Bhop extends Module{

	public static float speed = 1.1F;
	
	public Bhop() {
		super("Bhop", Keyboard.KEY_J, Category.MOVEMENT);
	}

	public void onUpdate() {
		/*if((Wrapper.mc.thePlayer == null) || ((Wrapper.mc.thePlayer == null))) {
			return;
		}*/
		
		if(Wrapper.mc.gameSettings.keyBindForward.pressed || Wrapper.mc.gameSettings.keyBindBack.pressed || Wrapper.mc.gameSettings.keyBindLeft.pressed || Wrapper.mc.gameSettings.keyBindRight.pressed) {
			if(Wrapper.mc.thePlayer.onGround && !Wrapper.mc.thePlayer.isCollidedHorizontally) {
				Wrapper.mc.thePlayer.jump();
			}
		}
		Wrapper.mc.thePlayer.onGround = true;
		Wrapper.mc.thePlayer.motionX *= speed;
		Wrapper.mc.thePlayer.onGround = false;
		Wrapper.mc.thePlayer.motionZ *= speed;
		Wrapper.mc.thePlayer.onGround = true;
	}
	
	public void onDisable() {
		
	}
}
