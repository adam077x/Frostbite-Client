package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Jesus extends Module{

	public static float JesusSpeed = 0.05F;
	
	public Jesus() {
		super("Jesus", Keyboard.KEY_NONE, Category.MOVEMENT);
	}

	public void onUpdate() {
		if(Wrapper.mc.thePlayer.isInWater()) {
			Wrapper.mc.thePlayer.onGround = true;
			Wrapper.mc.thePlayer.isAirBorne = true;
			Wrapper.mc.thePlayer.motionY = +JesusSpeed;
		}
	}
	
	public void onDisable() {
		
	}
}
