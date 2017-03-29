package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class CreativeFly extends Module{

	public CreativeFly() {
		super("CreativeFly", Keyboard.KEY_F, Category.MOVEMENT);
	}
	public void onUpdate() {
		Wrapper.mc.thePlayer.capabilities.isFlying = true;
	}

	public void onDisable() {
		Wrapper.mc.thePlayer.capabilities.isFlying = false;
	}
}
