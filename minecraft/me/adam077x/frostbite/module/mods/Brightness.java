package me.adam077x.frostbite.module.mods;

import org.lwjgl.input.Keyboard;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class Brightness extends Module{

	public Brightness() {
		super("Brightness", Keyboard.KEY_NONE, Category.RENDER);
	}

	public void onEnable() {
		Wrapper.mc.gameSettings.gammaSetting = 10f;
	}
	
	public void onDisable() {
		Wrapper.mc.gameSettings.gammaSetting = 1f;
	}
}
