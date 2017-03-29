package me.adam077x.frostbite.module.mods;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class FastPlace extends Module{

	public FastPlace() {
		super("FastPlace", 0, Category.PLAYER);
	}
	public void onUpdate() {
		Wrapper.mc.rightClickDelayTimer = 0;
	}
	
	public void onDisable() {
		Wrapper.mc.rightClickDelayTimer = 6;
	}
}
