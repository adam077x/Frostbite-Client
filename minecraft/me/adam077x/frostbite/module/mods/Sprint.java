package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Sprint extends Module{

	public Sprint() {
		super("Sprint", Keyboard.KEY_C, Category.MOVEMENT);
	}

	public void onUpdate() {
		Wrapper.mc.thePlayer.setSprinting(true);
	}
	
	public void onDisable() {
		Wrapper.mc.thePlayer.setSprinting(false);
	}
}
