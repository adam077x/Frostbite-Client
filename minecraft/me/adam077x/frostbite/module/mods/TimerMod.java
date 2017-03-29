package me.adam077x.frostbite.module.mods;

import me.adam077x.frostbite.module.Category;
import me.adam077x.frostbite.module.Module;
import me.adam077x.frostbite.utils.Wrapper;

public class TimerMod extends Module{

	public TimerMod() {
		super("Timer", 0, Category.WORLD);
	}

	public void onEnable() {
		net.minecraft.util.Timer.timerSpeed = 2F;
	}
	
	public void onDisable() {
		net.minecraft.util.Timer.timerSpeed = 1F;
	}
}
