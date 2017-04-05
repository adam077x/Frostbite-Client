package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Stuck extends Module{
	
	public Stuck() {
		super("Stuck", Keyboard.KEY_G, Category.EXPLOITS);
	}
	
	public void onUpdate() {
			Wrapper.mc.thePlayer.isDead = true;
	}
	
	public void onDisable() {
		Wrapper.mc.thePlayer.isDead = false;
	}
}
