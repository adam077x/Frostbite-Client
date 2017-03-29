package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Step extends Module{

	public Step() {
		super("Step", Keyboard.KEY_L, Category.MOVEMENT);
	}
	public void onUpdate() {
		Wrapper.mc.thePlayer.stepHeight = 1F;
	}
	
	public void onDisable() {
		Wrapper.mc.thePlayer.stepHeight = 0.5F;
	}
}
