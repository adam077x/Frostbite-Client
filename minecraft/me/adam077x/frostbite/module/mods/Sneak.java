package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Sneak extends Module{

	public Sneak() {
		super("Sneak", Keyboard.KEY_Z, Category.MOVEMENT);
	}

	public void onUpdate() {
		Wrapper.mc.thePlayer.setSneaking(true);
	}
	
	public void onDisable() {
		Wrapper.mc.thePlayer.setSneaking(false);
	}
}
